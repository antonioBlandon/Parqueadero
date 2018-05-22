package co.com.ceiba.parqueadero.model;

public interface Vigilante {

    boolean validarCantidadVehiculos();

    boolean validarPlaca();

    int calcularTiempoVehiculoParqueadero();

    double cobrarParqueadero();

}
