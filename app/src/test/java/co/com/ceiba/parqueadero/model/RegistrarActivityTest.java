package co.com.ceiba.parqueadero.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.parqueadero.entities.Vehiculo;
import co.com.ceiba.parqueadero.registrar.RegistrarActivity;

import static co.com.ceiba.parqueadero.model.VehiculoBuilder.aVehicle;

public class RegistrarActivityTest {

    RegistrarActivity registrarActivity;

    @Before
    public void prepareData() {
        registrarActivity = new RegistrarActivity();
    }

    @Test
    public void validarPlacaConAutorizacionSinAinicial() {
        //Arrange
        Vehiculo vehiculo = aVehicle().withPlacaWithoutAinit("BTA234").build();
        //Act
        boolean tieneAutorizacion = registrarActivity.validarPlacaConAutorizacion(vehiculo);
        //Assert
        Assert.assertEquals(true, tieneAutorizacion);
    }

    @Test
    public void validarPlacaConAutorizacionConAinicialDiasValidos() {
        //Arrange
        Vehiculo vehiculo = aVehicle().withFechaValida(1515934000).build();//Sun Jan 18 1970 08:05:34 GMT-0500
        //Act
        boolean tieneAutorizacion = registrarActivity.validarPlacaConAutorizacion(vehiculo);
        //Assert
        Assert.assertEquals(true, tieneAutorizacion);
    }

}
