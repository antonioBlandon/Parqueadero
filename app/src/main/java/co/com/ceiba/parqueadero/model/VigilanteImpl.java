package co.com.ceiba.parqueadero.model;

import java.util.Calendar;

public class VigilanteImpl extends Lugar implements Vigilante {

    @Override
    public boolean validarCantidadCarros(int cantidadCarrosActual) {

        int cantidadCarros = cantidadCarrosActual + 1;
        if (cantidadCarros <= 20) {
            return true;
        }
        return false;
    }

    @Override
    public boolean validarCantidadMotos(int cantidadMotosActual) {
        int cantidadMotos = cantidadMotosActual + 1;
        if (cantidadMotos <= 20) {
            return true;
        }
        return false;
    }

    @Override
    public boolean validarPlaca(String placa, long fechaIngreso) {

        if (placa.contains("A")) {
            int lunes = 2;
            int domingo = 1;
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(fechaIngreso);
            int diaIngresoDeLaSemana = calendar.getInstance().get(Calendar.DAY_OF_WEEK);
            if ((diaIngresoDeLaSemana == domingo) || (diaIngresoDeLaSemana == lunes)) {
                return false;
            }
            return true;
        }
        return true;

    }

    @Override
    public int calcularTiempoVehiculoParqueadero(long fechaIngreso, long fechaSalida) {
        return 0;
    }

    @Override
    public double cobrarParqueadero(Vehiculo vehiculo) {
        return 0;
    }

    @Override
    public void sacarVehiculo(String tipoVehiculo) {

    }

}
