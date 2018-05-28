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
import android.widget.Toast;

import java.util.Calendar;

import co.com.ceiba.parqueadero.R;
import co.com.ceiba.parqueadero.cobrar.ActivityCobrar;
import co.com.ceiba.parqueadero.entities.Moto;
import co.com.ceiba.parqueadero.entities.Parqueadero;
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

        initDataBase();

        etCilindraje = (EditText) findViewById(R.id.edit_text_ingresar_cilindraje);

        etPlaca = (EditText) findViewById(R.id.edit_text_ingresar_placa);
        etPlaca.setFilters(new InputFilter[]{new InputFilter.AllCaps(), new InputFilter.LengthFilter(6)});

        Button btnRegistrarIngreso = (Button) findViewById(R.id.btn_ingresar_ingresar_vehiculo);
        btnRegistrarIngreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String placa = etPlaca.getText().toString();
                if (!placa.isEmpty()) {
                    boolean tieneCupo = validarCupo(etCilindraje.getText().toString());
                    boolean placaValida = validarPlaca(placa);
                    if (tieneCupo && placaValida) {
                        validarIngresoExitoso(ingresarVehiculo(placa, etCilindraje.getText().toString()));
                    }
                } else {
                    Toast.makeText(context, getString(R.string.placa_vacia), Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set up floating action button
        FloatingActionButton fabIrAcobrar = findViewById(R.id.fab_ingresar_ir_a_cobrar);

        fabIrAcobrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrarActivity.this, ActivityCobrar.class));
            }
        });

    }

    public long ingresarVehiculo(String placa, String cilindraje) {

        DataBaseVehiculoManager db = new DataBaseVehiculoManager(context);
        Vehiculo vehiculo = new Vehiculo();
        if (!cilindraje.isEmpty()) {
            vehiculo = new Moto();
            ((Moto) vehiculo).setCilindraje(Integer.valueOf(cilindraje));
        }
        vehiculo.setPlaca(placa);
        vehiculo.setFechaIngreso(Calendar.getInstance().getTimeInMillis());
        return db.create(vehiculo);

    }

    public void initDataBase() {
        DataBaseParqueaderoManager dataBase = new DataBaseParqueaderoManager(context);
        if (!dataBase.validateInit()) {
            dataBase.create();
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

    public void validarIngresoExitoso(long id) {
        if (id >= 0) {
            DataBaseParqueaderoManager dataBase = new DataBaseParqueaderoManager(context);
            if (isCar) {
                dataBase.update(DataBaseConstans.TablaParqueadero.CANTIDAD_CARROS, true);
            } else {
                dataBase.update(DataBaseConstans.TablaParqueadero.CANTIDAD_MOTOS, true);
            }
            Toast.makeText(context, getString(R.string.ingreso_exitoso), Toast.LENGTH_SHORT).show();
            etCilindraje.setText("");
            etPlaca.setText("");
        } else {
            Toast.makeText(RegistrarActivity.this, getString(R.string.error_registro), Toast.LENGTH_SHORT).show();
        }
    }

    public boolean validarPlaca(String placa) {
        boolean placaValida = VigilanteImpl.getInstance().validarPlaca(placa, Calendar.getInstance().getTimeInMillis());
        if (!placaValida) {
            Toast.makeText(context, getString(R.string.vehiculo_no_autorizado), Toast.LENGTH_LONG).show();
        }
        return placaValida;
    }

}
