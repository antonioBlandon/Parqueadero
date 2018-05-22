package co.com.ceiba.parqueadero.model;

public class Parqueadero extends Lugar {

    //Tarifas carro
    private static final int valorHoraCarro = 1000;
    private static final int valorDiaCarro = 8000;

    //Tarifas moto
    private static final int valorHoraMoto = 500;
    private static final int valorDiaMoto = 4000;

    //Contadores
    private int cantidadCarros;
    private int cantidadMotos;

    public Parqueadero(int cantidadCarros, int cantidadMotos) {
        this.cantidadCarros = cantidadCarros;
        this.cantidadMotos = cantidadMotos;
    }

    public int getCantidadCarros() {
        return cantidadCarros;
    }

    public void setCantidadCarros(int cantidadCarros) {
        this.cantidadCarros = cantidadCarros;
    }

    public int getCantidadMotos() {
        return cantidadMotos;
    }

    public void setCantidadMotos(int cantidadMotos) {
        this.cantidadMotos = cantidadMotos;
    }

}
