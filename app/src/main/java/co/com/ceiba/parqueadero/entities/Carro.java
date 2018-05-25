package co.com.ceiba.parqueadero.entities;

public class Carro extends Vehiculo {

    public Carro(String placa, long fechaIngreso, long fechaSalida, long horasEnParqueadero, long diasEnParqueadero, double valorApagarParqueadero) {
        super(placa, fechaIngreso, fechaSalida, horasEnParqueadero, diasEnParqueadero, valorApagarParqueadero);
    }

}
