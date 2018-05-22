package co.com.ceiba.parqueadero.model;

public interface Vigilante {

    boolean validarCantidadCarros(int cantidadCarrosActual);

    boolean validarCantidadMotos(int cantidadMotosActual);

    boolean validarPlaca();

    int calcularTiempoVehiculoParqueadero();

    double cobrarParqueadero();

}
