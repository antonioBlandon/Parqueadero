package co.com.ceiba.parqueadero.entities;

import android.content.Context;

import co.com.ceiba.parqueadero.storage.DataBaseConstans;
import co.com.ceiba.parqueadero.storage.DataBaseParqueaderoManager;

public class Parqueadero {

    //Tarifas carro
    public static final long VALOR_HORA_CARRO = 1_000L;
    public static final long VALOR_DIA_CARRO = 8_000L;

    //Tarifas moto
    public static final int VALOR_HORA_MOTO = 500;
    public static final long VALOR_DIA_MOTO = 4_000L;
    public static final long ADICION_CILINDRAJE = 2_000L;

    public static final int TOPE_CILINDRAJE = 500;

    //Contadores
    private int cantidadCarros;
    private int cantidadMotos;

    static Parqueadero parqueadero;

    public Parqueadero(int cantidadCarros, int cantidadMotos) {
        this.cantidadCarros = cantidadCarros;
        this.cantidadMotos = cantidadMotos;
    }

    public static Parqueadero getInstance(){
        if(parqueadero == null){
            parqueadero = new Parqueadero(0,0);
        }
        return parqueadero;
    }

    public int getCantidadCarros() {
        return cantidadCarros;
    }

    public void setCantidadCarros(int cantidadCarros) {
        this.cantidadCarros = cantidadCarros;
    }

    public int getCantidadMotos() {
        return cantidadMotos;
    }

    public void setCantidadMotos(int cantidadMotos) {
        this.cantidadMotos = cantidadMotos;
    }

}
