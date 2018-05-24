package co.com.ceiba.parqueadero.model;

public class VehiculoBuilder {

    private String placa;
    private long fechaIngreso;
    private long fechaSalida;
    private int tiempoEnParqueadero = 21;
    private double valorApagarParqueadero = 0;

    public VehiculoBuilder() {
        placa = "ABC123";
        fechaIngreso = 1353934000; //Fri Jan 16 1970 11:05:34 GMT-0500
        fechaSalida = 1429534000; //Sat Jan 17 1970 08:05:34 GMT-0500
        tiempoEnParqueadero = 21;
        valorApagarParqueadero = 0;
    }

    public VehiculoBuilder withPlacaWithoutAinit(String placa){
        this.placa = placa;
        return this;
    }

    public VehiculoBuilder withFechaValida(long fechaIngreso){
        this.fechaIngreso = fechaIngreso;
        return this;
    }

    public Carro buildCar(){
        return new Carro(placa,fechaIngreso,fechaSalida,tiempoEnParqueadero,valorApagarParqueadero);
    }

    public Moto buildMoto(){
        return new Moto(placa,fechaIngreso,fechaSalida,tiempoEnParqueadero,valorApagarParqueadero);
    }

    public Vehiculo build(){
        return new Vehiculo(placa,fechaIngreso,fechaSalida,tiempoEnParqueadero,valorApagarParqueadero);
    }

    public static VehiculoBuilder aVehicle(){
        return new VehiculoBuilder();
    }

}
