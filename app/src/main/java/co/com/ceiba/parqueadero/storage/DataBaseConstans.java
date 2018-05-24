package co.com.ceiba.parqueadero.storage;

public class DataBaseConstans {

    public static final int VERSION_DB = 1;
    public static final String DB_NAME = "parqueadero";

    public static final String CREATE = "CREATE TABLE ";
    public static final String ID_AUTOINCREMENT = " ( ID INTEGER PRIMARY KEY AUTOINCREMENT,";
    public static final String INTEGER = " INTEGER,";
    public static final String TEXT = " TEXT,";
    public static final String TEXT_FINAL = " TEXT);";
    public static final String INTEGER_FINAL = " INTEGER);";
    public static final String ID = "id";

    public class TablaVehiculo {
        public static final String TABLE_NAME = "vehiculo";
        public static final String PLACA = "placa";
        public static final String FECHA_INGRESO = "fecha_ingreso";
        public static final String FECHA_SALIDA = "fecha_salida";
        public static final String VALOR_PAGADO = "valor_pagado";
        public static final String CILINDRAJE = "cilindraje";
        public static final String CREATE_TABLE = CREATE +
                TABLE_NAME +
                ID_AUTOINCREMENT +
                PLACA +TEXT +
                FECHA_INGRESO + INTEGER +
                FECHA_SALIDA + INTEGER +
                CILINDRAJE + INTEGER +
                VALOR_PAGADO + INTEGER_FINAL;
    }

    public class TablaParqueadero {
        public static final String TABLE_NAME = "vehiculo";
        public static final String CANTIDAD_CARROS = "cantidad_carros";
        public static final String CANTIDAD_MOTOS = "cantidad_motos";
        public static final String CREATE_TABLE = CREATE +
                TABLE_NAME +
                ID_AUTOINCREMENT +
                CANTIDAD_CARROS + INTEGER +
                CANTIDAD_MOTOS + INTEGER_FINAL;
    }

}
