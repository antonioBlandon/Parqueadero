package co.com.ceiba.parqueadero.model;

public class ParqueaderoBuilder {

    //Contadores
    private int cantidadCarros;
    private int cantidadMotos;

    public ParqueaderoBuilder() {
        cantidadCarros = 19;
        cantidadMotos = 9;
    }

    public ParqueaderoBuilder withLimitCar(int cantidadCarros){
        this.cantidadCarros = cantidadCarros;
        return this;
    }

    public ParqueaderoBuilder withLimitMoto(int cantidadMotos){
        this.cantidadMotos = cantidadMotos;
        return this;
    }

    public Parqueadero build(){
        return new Parqueadero(cantidadCarros,cantidadMotos);
    }

    public static ParqueaderoBuilder aParking(){
        return new ParqueaderoBuilder();
    }

}
