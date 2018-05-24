package co.com.ceiba.parqueadero.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import co.com.ceiba.parqueadero.entities.Moto;
import co.com.ceiba.parqueadero.entities.Vehiculo;

public class DataBaseVehiculoManager {

    private SQLiteDatabase db;
    private DataBaseHelper dBhelper;

    public DataBaseVehiculoManager(Context context) {

        dBhelper = new DataBaseHelper(context);
        db = dBhelper.getWritableDatabase();

    }

    public void create(Vehiculo vehiculo) {

        ContentValues contentValues = new ContentValues();

        contentValues.put(DataBaseConstans.TablaVehiculo.PLACA, vehiculo.getPlaca());
        contentValues.put(DataBaseConstans.TablaVehiculo.FECHA_INGRESO, vehiculo.getFechaIngreso());

        if (vehiculo instanceof Moto) {
            contentValues.put(DataBaseConstans.TablaVehiculo.PLACA, ((Moto) vehiculo).getCilindraje());
        }

        db.insert(DataBaseConstans.TablaVehiculo.TABLE_NAME, null, contentValues);

    }

    public Vehiculo read(Vehiculo vehiculo) {

        String selection = DataBaseConstans.TablaVehiculo.VALOR_PAGADO + " = ? AND " + DataBaseConstans.TablaVehiculo.VALOR_PAGADO + " = ? ";
        Cursor cursor = db.query(DataBaseConstans.TablaVehiculo.TABLE_NAME, null, selection,
                new String[]{vehiculo.getPlaca(), Long.toString(vehiculo.getFechaIngreso())}, null, null, null);

        if(cursor.moveToFirst()){

            Vehiculo retorno = new Vehiculo();
            if(cursor.getString(5) != null){
                retorno =  new Moto();
                ((Moto) retorno).setCilindraje(cursor.getInt(5));
            }
            retorno.setPlaca(cursor.getString(1));
            retorno.setFechaIngreso(Long.valueOf(cursor.getString(2)));
            cursor.close();
            return retorno;

        }

        cursor.close();
        return null;

    }

    public void update(Vehiculo vehiculo) {

        ContentValues contentValues = new ContentValues();

        contentValues.put(DataBaseConstans.TablaVehiculo.VALOR_PAGADO, vehiculo.getValorApagarParqueadero());
        contentValues.put(DataBaseConstans.TablaVehiculo.FECHA_SALIDA, vehiculo.getFechaSalida());

        String where = DataBaseConstans.TablaVehiculo.VALOR_PAGADO + " = ? AND " + DataBaseConstans.TablaVehiculo.VALOR_PAGADO + " = ? ";
        db.update(DataBaseConstans.TablaVehiculo.TABLE_NAME,
                contentValues,
                where,
                new String[]{vehiculo.getPlaca(), Long.toString(vehiculo.getFechaIngreso())});

    }

    public void delete(Vehiculo vehiculo) {

    }

}
