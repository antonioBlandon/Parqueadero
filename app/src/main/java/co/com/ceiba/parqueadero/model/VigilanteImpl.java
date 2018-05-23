package co.com.ceiba.parqueadero.model;

import java.util.Calendar;

public class VigilanteImpl implements Vigilante {

    @Override
    public boolean validarCantidadCarros(int cantidadCarrosActual) {

        int cantidadCarros = cantidadCarrosActual + 1;
        return cantidadCarros <= 20;

    }

    @Override
    public boolean validarCantidadMotos(int cantidadMotosActual) {
        int cantidadMotos = cantidadMotosActual + 1;
        return cantidadMotos <= 20;
    }

    @Override
    public boolean validarPlaca(String placa, long fechaIngreso) {

        if (placa.contains("A")) {
            int lunes = 2;
            int domingo = 1;
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(fechaIngreso);
            int diaIngresoDeLaSemana = calendar.get(Calendar.DAY_OF_WEEK);
            return ((diaIngresoDeLaSemana == domingo) || (diaIngresoDeLaSemana == lunes));
        }
        return true;

    }

    @Override
    public long calcularTiempoVehiculoParqueadero(long fechaIngreso, long fechaSalida) {
        long tiempo = fechaSalida - fechaIngreso;
        long tiempoEnSegundos = tiempo/1000;
        return tiempoEnSegundos/3600;
    }

    @Override
    public long cobrarParqueadero(Vehiculo vehiculo) {

        long valor;
        long[] diasHoras = obtenerCantidadDeDiasYHoras(vehiculo.getTiempoEnParqueadero());
        long dias = diasHoras[0];
        long horas = diasHoras[1];
        if(vehiculo instanceof Moto){
            int cilindraje = ((Moto) vehiculo).getCilindraje();
            valor = (dias*Parqueadero.VALOR_DIA_MOTO) + (horas*Parqueadero.VALOR_HORA_MOTO);
            if(cilindraje>Parqueadero.TOPE_CILINDRAJE){
                valor = valor + Parqueadero.ADICION_CILINDRAJE;
            }
            return valor;
        }else if(vehiculo instanceof Carro){
            valor = (dias*Parqueadero.VALOR_DIA_CARRO) + (horas*Parqueadero.VALOR_HORA_CARRO);
            return valor;
        }else{
            return 0;
        }

    }

    @Override
    public boolean sacarVehiculo(Vehiculo vehiculo) {

        int cantidad = 0;
        if (vehiculo instanceof Moto) {
            cantidad = Parqueadero.getInstance().getCantidadMotos();
            if (cantidad > 0) {
                Parqueadero.getInstance().setCantidadMotos(cantidad - 1);
                return true;
            }
            return false;
        } else if (vehiculo instanceof Carro) {
            cantidad = Parqueadero.getInstance().getCantidadCarros();
            if (cantidad > 0) {
                Parqueadero.getInstance().setCantidadCarros(cantidad - 1);
                return true;
            }
            return false;
        } else {
            return false;
        }

    }

    public long[] obtenerCantidadDeDiasYHoras(long horas){
        long dias = 0;
        long[] diasHoras = new long[2];
        while(horas >= 0){

            if(horas > 9){
                dias++;
                horas = horas - 24;
            }else if(horas >= 0){
                diasHoras[0]=dias;
                diasHoras[1]=horas;
            }

        }
        return diasHoras;
    }

}
