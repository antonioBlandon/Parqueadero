package co.com.ceiba.parqueadero.entities;

public class Parqueadero {

    //Tarifas carro
    public static final long VALOR_HORA_CARRO = 1_000L;
    public static final long VALOR_DIA_CARRO = 8_000L;

    //Tarifas moto
    public static final int VALOR_HORA_MOTO = 500;
    public static final long VALOR_DIA_MOTO = 4_000L;
    public static final long ADICION_CILINDRAJE = 2_000L;

    public static final int TOPE_CILINDRAJE = 500;

    private Parqueadero() {
    }
}
