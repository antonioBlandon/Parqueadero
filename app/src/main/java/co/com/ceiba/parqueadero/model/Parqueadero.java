package co.com.ceiba.parqueadero.model;

public class Parqueadero extends Lugar {

    //Tarifas carro
    public static final int valorHoraCarro = 1000;
    public static final int valorDiaCarro = 8000;

    //Tarifas moto
    public static final int valorHoraMoto = 500;
    public static final int valorDiaMoto = 4000;
    public static final int adicionCilindraje = 2000;

    public static final int topeCilindraje = 500;

    //Contadores
    private int cantidadCarros;
    private int cantidadMotos;

    public static Parqueadero parqueadero;

    public Parqueadero(int cantidadCarros, int cantidadMotos) {
        this.cantidadCarros = cantidadCarros;
        this.cantidadMotos = cantidadMotos;
    }

    public static Parqueadero getInstance(){
        if(parqueadero == null){
            parqueadero = new Parqueadero(0,0);
        }
        return parqueadero;
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
