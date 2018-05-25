package co.com.ceiba.parqueadero.cobrar;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;

import co.com.ceiba.parqueadero.R;
import co.com.ceiba.parqueadero.entities.Moto;
import co.com.ceiba.parqueadero.entities.Vehiculo;
import co.com.ceiba.parqueadero.storage.DataBaseVehiculoManager;

public class ActivityCobrar extends AppCompatActivity {

    private Context context = ActivityCobrar.this;
    private Vehiculo vehiculo;

    private LinearLayout llInfoVehiculo;
    private TextView tvPlaca;
    private TextView tvCilindraje;
    private TextView tvFechaIngreso;
    private EditText etBuscarPlaca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cobrar);

        llInfoVehiculo = (LinearLayout) findViewById(R.id.linear_layout_cobra_info_vehiculo);
        etBuscarPlaca = (EditText) findViewById(R.id.edit_text_cobrar_placa);
        tvPlaca = (TextView) findViewById(R.id.text_view_cobrar_placa);
        tvCilindraje = (TextView) findViewById(R.id.text_view_cobrar_cilindraje);
        tvFechaIngreso = (TextView) findViewById(R.id.text_view_cobrar_fecha_ingreso);

        etBuscarPlaca = (EditText) findViewById(R.id.edit_text_cobrar_placa);
        etBuscarPlaca.setFilters(new InputFilter[]{new InputFilter.AllCaps()});

        Button btnBuscarPlaca = (Button) findViewById(R.id.btn_cobrar_buscar_placa);
        btnBuscarPlaca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBaseVehiculoManager dataBase = new DataBaseVehiculoManager(context);
                vehiculo = dataBase.read(etBuscarPlaca.getText().toString());
                setUpInfo();
            }
        });

        Button btnCobrarParqueadero = (Button) findViewById(R.id.btn_cobrar_cobrar_parqueadero);
        btnCobrarParqueadero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cobrar();
            }
        });

    }

    public void cobrar() {
        //Método en desarrollo
    }

    public void setUpInfo() {

        if (vehiculo == null) {
            llInfoVehiculo.setVisibility(View.GONE);
            Toast.makeText(context, getString(R.string.error_read_data_base), Toast.LENGTH_SHORT).show();
            return;
        } else if (vehiculo.getPlaca() == null) {
            llInfoVehiculo.setVisibility(View.GONE);
            Toast.makeText(context, getString(R.string.placa_no_existe), Toast.LENGTH_SHORT).show();
            return;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy HH:mm:SS");
        llInfoVehiculo.setVisibility(View.VISIBLE);
        tvPlaca.setText(vehiculo.getPlaca());
        tvFechaIngreso.setText(sdf.format(vehiculo.getFechaIngreso()));
        if (vehiculo instanceof Moto) {
            tvCilindraje.setText(Integer.toString(((Moto) vehiculo).getCilindraje()));
        }

    }

}
