package co.com.ceiba.parqueadero.model;

public class VigilanteImpl extends Lugar implements Vigilante{

    @Override
    public boolean validarCantidadVehiculos() {
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
