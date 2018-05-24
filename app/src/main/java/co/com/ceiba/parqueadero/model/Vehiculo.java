package co.com.ceiba.parqueadero.model;

public class Vehiculo {

    private String placa;
    private long fechaIngreso;
    private long fechaSalida;
    private long horasEnParqueadero;
    private long diasEnParqueadero;
    private double valorApagarParqueadero;

    public Vehiculo(String placa, long fechaIngreso, long fechaSalida, long horasEnParqueadero, long diasEnParqueadero, double valorApagarParqueadero) {
        this.placa = placa;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.horasEnParqueadero = horasEnParqueadero;
        this.diasEnParqueadero = diasEnParqueadero;
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

    public long getHorasEnParqueadero() {
        return horasEnParqueadero;
    }

    public void setHorasEnParqueadero(long horasEnParqueadero) {
        this.horasEnParqueadero = horasEnParqueadero;
    }

    public long getDiasEnParqueadero() {
        return diasEnParqueadero;
    }

    public void setDiasEnParqueadero(long diasEnParqueadero) {
        this.diasEnParqueadero = diasEnParqueadero;
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
                ", fechaIngreso=" + fechaIngreso +
                ", fechaSalida=" + fechaSalida +
                ", horasEnParqueadero=" + horasEnParqueadero +
                ", diasEnParqueadero=" + diasEnParqueadero +
                ", valorApagarParqueadero=" + valorApagarParqueadero +
                '}';
    }

}
