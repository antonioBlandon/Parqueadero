package co.com.ceiba.parqueadero.model;

public interface Vigilante {

    boolean validarCantidadCarros(int cantidadCarrosActual);

    boolean validarCantidadMotos(int cantidadMotosActual);

    boolean validarPlaca(String placa, long fechaIngreso);

    int calcularTiempoVehiculoParqueadero(long fechaIngreso, long fechaSalida);

    double cobrarParqueadero(Vehiculo vehiculo);

    void sacarVehiculo(String tipoVehiculo);

}