package co.com.ceiba.parqueadero.registrar;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Calendar;

import co.com.ceiba.parqueadero.R;
import co.com.ceiba.parqueadero.cobrar.ActivityCobrar;
import co.com.ceiba.parqueadero.entities.Carro;
import co.com.ceiba.parqueadero.entities.Moto;
import co.com.ceiba.parqueadero.entities.Vehiculo;
import co.com.ceiba.parqueadero.entities.VigilanteImpl;
import co.com.ceiba.parqueadero.storage.DataBaseConstans;
import co.com.ceiba.parqueadero.storage.DataBaseParqueaderoManager;
import co.com.ceiba.parqueadero.storage.DataBaseVehiculoManager;

public class RegistrarActivity extends AppCompatActivity {

    private Context context = this;
    private boolean isCar;

    private EditText etPlaca;
    private EditText etCilindraje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar);

        etCilindraje = (EditText) findViewById(R.id.edit_text_ingresar_cilindraje);

        etPlaca = (EditText) findViewById(R.id.edit_text_ingresar_placa);
        etPlaca.setFilters(new InputFilter[]{new InputFilter.AllCaps(), new InputFilter.LengthFilter(6)});

        Button btnRegistrarIngreso = (Button) findViewById(R.id.btn_ingresar_ingresar_vehiculo);
        btnRegistrarIngreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarIngreso(etPlaca.getText().toString(), etCilindraje.getText().toString());
            }
        });

        // Set up floating action button
        FloatingActionButton fabIrAcobrar = findViewById(R.id.fab_ingresar_ir_a_cobrar);
        fabIrAcobrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(RegistrarActivity.this, ActivityCobrar.class));
            }
        });

        initDataBase();
        getTRM();

    }

    public Vehiculo crearVehiculo(String placa, String cilindraje) {

        Vehiculo vehiculo = new Carro();
        if (!cilindraje.isEmpty()) {
            vehiculo = new Moto();
            ((Moto) vehiculo).setCilindraje(Integer.valueOf(cilindraje));
        }
        vehiculo.setPlaca(placa);
        vehiculo.setFechaIngreso(Calendar.getInstance().getTimeInMillis());
        return vehiculo;

    }

    public void getTRM() {

        final TextView tvTRM = (TextView) findViewById(R.id.text_view_ingresar_trm);

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://app.docm.co/prod/Dmservices/Utilities.svc/GetTRM";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        tvTRM.setText("$ " + response.replace("\"", ""));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tvTRM.setText(getString(R.string.error_cargando_trm));
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);

    }

    private void initDataBase() {
        DataBaseParqueaderoManager dataBase = new DataBaseParqueaderoManager(context);
        if (!dataBase.validateInit()) {
            dataBase.create();
        }
    }

    public void registrarIngreso(String placa, String cilindraje) {
        DataBaseVehiculoManager tableVehiculo = new DataBaseVehiculoManager(context);
        DataBaseParqueaderoManager tableParqueadero = new DataBaseParqueaderoManager(context);

        if (!placa.isEmpty()) {

            Vehiculo vehiculo = crearVehiculo(placa, cilindraje);
            boolean tieneCupo = validarCupo(cilindraje);
            boolean placaValida = VigilanteImpl.getInstance().validarPlaca(vehiculo.getPlaca(), vehiculo.getFechaIngreso());
            boolean placaExiste = tableVehiculo.read(placa).getPlaca() != null;
            boolean ingresoExitoso = false;

            if (tieneCupo && placaValida && !placaExiste) {

                ingresoExitoso = validarIngresoExitoso(tableVehiculo.create(vehiculo));
                if (ingresoExitoso) {
                    if (isCar) {
                        tableParqueadero.update(DataBaseConstans.TablaParqueadero.CANTIDAD_CARROS, true);
                    } else {
                        tableParqueadero.update(DataBaseConstans.TablaParqueadero.CANTIDAD_MOTOS, true);
                    }
                }

            }
            showMessage(ingresoExitoso, placaValida, tieneCupo, placaExiste);
        } else {
            Toast.makeText(context, getString(R.string.placa_vacia), Toast.LENGTH_SHORT).show();
        }
    }

    public void showMessage(boolean ingresoExitoso, boolean placaValida, boolean tieneCupo, boolean placaExiste) {
        if (ingresoExitoso) {
            Toast.makeText(context, getString(R.string.ingreso_exitoso), Toast.LENGTH_SHORT).show();
        } else if ( placaValida && tieneCupo && !placaExiste) { //Solo se muestra si los otros mensajes no se han de mostrar
            Toast.makeText(context, getString(R.string.error_registro), Toast.LENGTH_SHORT).show();
        }
        if (!placaValida) {
            Toast.makeText(context, getString(R.string.vehiculo_no_autorizado), Toast.LENGTH_LONG).show();
        }
        if (!tieneCupo) {
            Toast.makeText(context, getString(R.string.parqueadero_lleno), Toast.LENGTH_LONG).show();
        }
        if (placaExiste) {
            Toast.makeText(context, getString(R.string.placa_existe), Toast.LENGTH_LONG).show();
        }
    }

    public boolean validarCupo(String cilindraje) {
        DataBaseParqueaderoManager db = new DataBaseParqueaderoManager(context);
        if (cilindraje.isEmpty()) {
            isCar = true;
            return VigilanteImpl.getInstance().validarCantidadCarros(db.read(DataBaseConstans.TablaParqueadero.CANTIDAD_CARROS));
        } else {
            isCar = false;
            return VigilanteImpl.getInstance().validarCantidadMotos(db.read(DataBaseConstans.TablaParqueadero.CANTIDAD_MOTOS));
        }
    }

    public boolean validarIngresoExitoso(long id) {
        if (id >= 0) {
            etCilindraje.setText("");
            etPlaca.setText("");
            return true;
        }
        return false;
    }

}
