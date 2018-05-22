package co.com.ceiba.parqueadero.model;

public class Moto extends Vehiculo {

    private int cilindraje;

    public Moto(String placa, String fechaIngreso, String fechaSalida, int tiempoEnParqueadero, double valorApagarParqueadero, int cilindraje) {
        super(placa, fechaIngreso, fechaSalida, tiempoEnParqueadero, valorApagarParqueadero);
        this.cilindraje = cilindraje;
    }

}
