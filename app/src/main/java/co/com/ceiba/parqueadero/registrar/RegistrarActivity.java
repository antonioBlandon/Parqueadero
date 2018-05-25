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
import co.com.ceiba.parqueadero.entities.Vigilante;
import co.com.ceiba.parqueadero.entities.VigilanteImpl;
import co.com.ceiba.parqueadero.storage.DataBaseVehiculoManager;

public class RegistrarActivity extends AppCompatActivity {

    private Context context = this;
    private Vigilante vigilante;

    private EditText etPlaca;
    private EditText etCilindraje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar);

        etCilindraje = (EditText) findViewById(R.id.edit_text_ingresar_cilindraje);

        etPlaca = (EditText) findViewById(R.id.edit_text_ingresar_placa);
        etPlaca.setFilters(new InputFilter[]{new InputFilter.AllCaps()});

        Button btnRegistrarIngreso = (Button) findViewById(R.id.btn_ingresar_ingresar_vehiculo);
        btnRegistrarIngreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vigilante = new VigilanteImpl();
                boolean tieneCupo = validarCupo(etCilindraje.getText().toString());
                boolean placaValida = validarPlaca();
                if (tieneCupo && placaValida) {
                    validarIngresoExitoso(ingresarVehiculo(etPlaca.getText().toString(), etCilindraje.getText().toString()));
                }
            }
        });

        // Set up floating action button
        FloatingActionButton fabIrAcobrar = (FloatingActionButton) findViewById(R.id.fab_ingresar_ir_a_cobrar);

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

    public boolean validarCupo(String cilindraje) {
        Parqueadero parqueadero = Parqueadero.getInstance();
        if (cilindraje.isEmpty()) {
            return vigilante.validarCantidadCarros(parqueadero.getCantidadCarros());
        } else {
            return vigilante.validarCantidadMotos(parqueadero.getCantidadMotos());
        }
    }

    public void validarIngresoExitoso(long id) {
        if (id >= 0) {
            Toast.makeText(context, getString(R.string.ingreso_exitoso), Toast.LENGTH_SHORT).show();
            etCilindraje.setText("");
            etPlaca.setText("");
        } else {
            Toast.makeText(RegistrarActivity.this, getString(R.string.error_registro), Toast.LENGTH_SHORT).show();
        }
    }

    public boolean validarPlaca() {
        boolean placaValida = vigilante.validarPlaca(etPlaca.getText().toString(), Calendar.getInstance().getTimeInMillis());
        if (!placaValida) {
            Toast.makeText(RegistrarActivity.this, getString(R.string.vehiculo_no_autorizado), Toast.LENGTH_LONG).show();
        }
        return placaValida;
    }

}
