package co.com.ceiba.parqueadero.model;

public class VigilanteImpl extends Lugar implements Vigilante{

    @Override
    public boolean validarCantidadCarros(int cantidadCarrosActual) {

        int cantidadCarros = cantidadCarrosActual + 1;
        if( cantidadCarros <= 20 ){
            return true;
        }
        return false;
    }

    @Override
    public boolean validarCantidadMotos(int cantidadMotosActual) {
        return false;
    }

    @Override
    public boolean validarPlaca() {
        return false;
    }

    @Override
    public int calcularTiempoVehiculoParqueadero() {
        return 0;
    }

    @Override
    public double cobrarParqueadero() {
        return 0;
    }

}
