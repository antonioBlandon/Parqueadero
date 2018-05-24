package co.com.ceiba.parqueadero.registrar;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import co.com.ceiba.parqueadero.R;
import co.com.ceiba.parqueadero.cobrar.ActivityCobrar;
import co.com.ceiba.parqueadero.entities.Moto;
import co.com.ceiba.parqueadero.entities.Vehiculo;
import co.com.ceiba.parqueadero.entities.Vigilante;
import co.com.ceiba.parqueadero.entities.VigilanteImpl;
import co.com.ceiba.parqueadero.storage.DataBaseVehiculoManager;

public class RegistrarActivity extends AppCompatActivity {

    private Context context = this;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar);

        final EditText etPlaca = (EditText) findViewById(R.id.edit_text_ingresar_placa);
        final EditText etCilindraje = (EditText) findViewById(R.id.edit_text_ingresar_cilindraje);
        
        Button btnRegistrarIngreso = (Button) findViewById(R.id.btn_ingresar_ingresar_vehiculo);
        btnRegistrarIngreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingresarVehiculo(etPlaca.getText().toString(), etCilindraje.getText().toString());
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

    public void ingresarVehiculo(String placa, String cilindraje){

        long fechaIngreso = Calendar.getInstance().getTimeInMillis();
        Vigilante vigilante = new VigilanteImpl();

        if(vigilante.validarPlaca(placa, fechaIngreso)){
            DataBaseVehiculoManager db = new DataBaseVehiculoManager(context);
            Vehiculo vehiculo = new Vehiculo();
            if(!cilindraje.isEmpty()){
                vehiculo = new Moto();
            }
            vehiculo.setPlaca(placa);
            vehiculo.setFechaIngreso(fechaIngreso);
            ((Moto)vehiculo).setCilindraje(Integer.valueOf(cilindraje));
            db.create(vehiculo);
            Toast.makeText(RegistrarActivity.this, getString(R.string.ingreso_exitoso), Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(RegistrarActivity.this, getString(R.string.vehiculo_no_autorizado), Toast.LENGTH_LONG).show();
        }

    }

}
