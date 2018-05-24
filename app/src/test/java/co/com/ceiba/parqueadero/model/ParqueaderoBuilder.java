package co.com.ceiba.parqueadero.model;

import co.com.ceiba.parqueadero.entities.Parqueadero;

public class ParqueaderoBuilder {

    //Contadores
    private int cantidadCarros;
    private int cantidadMotos;

    public ParqueaderoBuilder() {
        cantidadCarros = 0;
        cantidadMotos = 0;
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
