package co.com.ceiba.parqueadero.entities;

public class Moto extends Vehiculo {

    private int cilindraje;

    public Moto(String placa, long fechaIngreso, long fechaSalida, long horasEnParqueadero, long diasEnParqueadero, double valorApagarParqueadero) {
        super(placa, fechaIngreso, fechaSalida, horasEnParqueadero, diasEnParqueadero, valorApagarParqueadero);
    }

    public Moto() {
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }
}
