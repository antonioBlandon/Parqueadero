package co.com.ceiba.parqueadero.model;

public class Parqueadero extends Lugar {

    //Tarifas carro
    public static final int VALOR_HORA_CARRO = 1000;
    public static final int VALOR_DIA_CARRO = 8000;

    //Tarifas moto
    public static final int VALOR_HORA_MOTO = 500;
    public static final int VALOR_DIA_MOTO = 4000;
    public static final int ADICION_CILINDRAJE = 2000;

    public static final int TOPE_CILINDRAJE = 500;

    //Contadores
    private int cantidadCarros;
    private int cantidadMotos;

    static Parqueadero parqueadero;

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
