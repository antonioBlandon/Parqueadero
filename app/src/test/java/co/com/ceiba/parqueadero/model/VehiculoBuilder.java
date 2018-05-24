package co.com.ceiba.parqueadero.model;

public class VehiculoBuilder {

    private String placa;
    private long fechaIngreso;
    private long fechaSalida;
    private int tiempoEnParqueadero;
    private double valorApagarParqueadero;

    public VehiculoBuilder() {
        placa = "ABC123";
        fechaIngreso = 0;
        fechaSalida = 0;
        tiempoEnParqueadero = 9;
        valorApagarParqueadero = 8000;
    }

    public Carro buildCar(){
        return new Carro(placa,fechaIngreso,fechaSalida,tiempoEnParqueadero,valorApagarParqueadero);
    }

    public Moto buildMoto(){
        return new Moto(placa,fechaIngreso,fechaSalida,tiempoEnParqueadero,valorApagarParqueadero);
    }

    public static VehiculoBuilder aVehicle(){
        return new VehiculoBuilder();
    }

}
