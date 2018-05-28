package co.com.ceiba.parqueadero.entities;

public interface Vigilante {

    boolean validarCantidadCarros(int cantidadCarrosActual);

    boolean validarCantidadMotos(int cantidadMotosActual);

    boolean validarPlaca(String placa, long fechaIngreso);

    long calcularTiempoVehiculoParqueadero(long fechaIngreso, long fechaSalida);

    long cobrarParqueadero(Vehiculo vehiculo);

    long[] calcularDiasHoras(long horas);

}
