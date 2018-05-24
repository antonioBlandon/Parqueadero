package co.com.ceiba.parqueadero.model;

import co.com.ceiba.parqueadero.entities.Carro;
import co.com.ceiba.parqueadero.entities.Moto;
import co.com.ceiba.parqueadero.entities.Vehiculo;

public class VehiculoBuilder {

    private String placa;
    private long fechaIngreso;
    private long fechaSalida;
    private long horasEnParqueadero;
    private long diasEnParqueadero;
    private double valorApagarParqueadero;

    public VehiculoBuilder() {
        placa = "ABC123";
        fechaIngreso = 1353934000; //Fri Jan 16 1970 11:05:34 GMT-0500
        fechaSalida = 1451134000; //Sat Jan 17 1970 14:05:34 GMT-0500
        horasEnParqueadero = 0;
        diasEnParqueadero = 1;
        valorApagarParqueadero = 11000;
    }

    public VehiculoBuilder withPlacaWithoutAinit(String placa){
        this.placa = placa;
        return this;
    }

    public VehiculoBuilder withFechaValida(long fechaIngreso){
        this.fechaIngreso = fechaIngreso;
        return this;
    }

    public VehiculoBuilder withFechaDeSalida(long fechaSalida){
        this.fechaSalida = fechaSalida;
        return this;
    }

    public VehiculoBuilder withTiempoEnParqueadero(long horasEnParqueadero,long diasEnParqueadero){
        this.horasEnParqueadero = horasEnParqueadero;
        this.diasEnParqueadero = diasEnParqueadero;
        return this;
    }

    public Carro buildCar(){
        return new Carro(placa,fechaIngreso,fechaSalida,horasEnParqueadero,diasEnParqueadero,valorApagarParqueadero);
    }

    public Moto buildMoto(){
        return new Moto(placa,fechaIngreso,fechaSalida,horasEnParqueadero,diasEnParqueadero,valorApagarParqueadero);
    }

    public Moto buildMotoWithCilindraje(int cilindraje){
        Moto moto = new Moto(placa,fechaIngreso,fechaSalida,horasEnParqueadero,diasEnParqueadero,valorApagarParqueadero);
        moto.setCilindraje(cilindraje);
        return moto;
    }

    public Vehiculo build(){
        return new Vehiculo(placa,fechaIngreso,fechaSalida,horasEnParqueadero,diasEnParqueadero,valorApagarParqueadero);
    }

    public static VehiculoBuilder aVehicle(){
        return new VehiculoBuilder();
    }

}
