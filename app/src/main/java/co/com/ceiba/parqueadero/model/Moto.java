package co.com.ceiba.parqueadero.model;

public class Moto extends Vehiculo {

    private int cilindraje;

    public Moto(String placa, long fechaIngreso, long fechaSalida, int tiempoEnParqueadero, double valorApagarParqueadero) {
        super(placa, fechaIngreso, fechaSalida, tiempoEnParqueadero, valorApagarParqueadero);
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }
}
