package co.com.ceiba.parqueadero.entities;

import android.content.Context;

public interface Vigilante {

    boolean validarCantidadCarros(int cantidadCarrosActual);

    boolean validarCantidadMotos(int cantidadMotosActual);

    boolean validarPlaca(String placa, long fechaIngreso);

    long calcularTiempoVehiculoParqueadero(long fechaIngreso, long fechaSalida);

    long cobrarParqueadero(Vehiculo vehiculo);

    boolean sacarVehiculo(Context context, boolean isCar);

    long[] calcularDiasHoras(long horas);

}
