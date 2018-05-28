package co.com.ceiba.parqueadero.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DataBaseParqueaderoManager {

    private SQLiteDatabase db;
    private DataBaseHelper dBhelper;

    public DataBaseParqueaderoManager(Context context) {

        dBhelper = new DataBaseHelper(context);
        db = dBhelper.getWritableDatabase();

    }

    public long create(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBaseConstans.TablaParqueadero.CANTIDAD_CARROS, 0);
        contentValues.put(DataBaseConstans.TablaParqueadero.CANTIDAD_MOTOS, 0);
        return db.insert(DataBaseConstans.TablaParqueadero.TABLE_NAME,null,contentValues);
    }

    private int getCurrentValue(String typeVehicle){
        if(typeVehicle.equals(DataBaseConstans.TablaParqueadero.CANTIDAD_CARROS)){
            return read(DataBaseConstans.TablaParqueadero.CANTIDAD_CARROS);
        }else{
            return read(DataBaseConstans.TablaParqueadero.CANTIDAD_MOTOS);
        }
    }

    public int read(String columna){
        Cursor cursor = db.query(DataBaseConstans.TablaParqueadero.TABLE_NAME,new String[]{columna},null,null,null,null,null);
        int value = 0;
        if(cursor.moveToFirst()){
            value = cursor.getInt(0);
        }
        cursor.close();
        return value;
    }

    public int update(String key, boolean ingresarVehiculo){
        ContentValues contentValues = new ContentValues();
        int value = getCurrentValue(key);
        if(ingresarVehiculo){
            contentValues.put(key,value+1);
        }else {//Caso contrario, se está sacando un vehiculo
            contentValues.put(key,value-1);
        }
        return db.update(DataBaseConstans.TablaParqueadero.TABLE_NAME,contentValues,null,null);
    }

    public boolean validateInit(){
        Cursor cursor = db.query(DataBaseConstans.TablaParqueadero.TABLE_NAME,null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            cursor.close();
            return true;
        }
        cursor.close();
        return false;
    }

}
