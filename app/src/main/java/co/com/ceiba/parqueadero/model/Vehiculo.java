package co.com.ceiba.parqueadero.model;

public class Vehiculo {

    private String placa;
    private long fechaIngreso;
    private long fechaSalida;
    private int tiempoEnParqueadero;
    private double valorApagarParqueadero;

    public Vehiculo(String placa, long fechaIngreso, long fechaSalida, int tiempoEnParqueadero, double valorApagarParqueadero) {
        this.placa = placa;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.tiempoEnParqueadero = tiempoEnParqueadero;
        this.valorApagarParqueadero = valorApagarParqueadero;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public long getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(long fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public long getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(long fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getTiempoEnParqueadero() {
        return tiempoEnParqueadero;
    }

    public void setTiempoEnParqueadero(int tiempoEnParqueadero) {
        this.tiempoEnParqueadero = tiempoEnParqueadero;
    }

    public double getValorApagarParqueadero() {
        return valorApagarParqueadero;
    }

    public void setValorApagarParqueadero(double valorApagarParqueadero) {
        this.valorApagarParqueadero = valorApagarParqueadero;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "placa='" + placa + '\'' +
                ", fechaIngreso='" + fechaIngreso + '\'' +
                ", fechaSalida='" + fechaSalida + '\'' +
                ", tiempoEnParqueadero=" + tiempoEnParqueadero +
                ", valorApagarParqueadero=" + valorApagarParqueadero +
                '}';
    }

}
