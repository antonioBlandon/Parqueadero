package co.com.ceiba.parqueadero.model;

import android.content.Context;
import android.test.mock.MockContext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import co.com.ceiba.parqueadero.entities.Vehiculo;
import co.com.ceiba.parqueadero.registrar.RegistrarActivity;
import co.com.ceiba.parqueadero.storage.DataBaseParqueaderoManager;
import co.com.ceiba.parqueadero.storage.DataBaseVehiculoManager;

import static co.com.ceiba.parqueadero.model.VehiculoBuilder.aVehicle;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RegistrarActivityTest {

    RegistrarActivity registrarActivity;

    @Mock
    Context context;

    @Before
    public void prepareData() {
        registrarActivity = new RegistrarActivity();
    }

    @Test
    public void crearCarroNotNull() {
        //Arrange
        String placa = "TRE343";
        String cilindraje = "";
        //Act
        Vehiculo vehiculo = registrarActivity.crearVehiculo(placa,cilindraje);
        //Assert
        Assert.assertNotNull(vehiculo);
    }

    @Test
    public void crearMotoNotNull() {
        //Arrange
        String placa = "TRE343";
        String cilindraje = "490";
        //Act
        Vehiculo vehiculo = registrarActivity.crearVehiculo(placa,cilindraje);
        //Assert
        Assert.assertNotNull(vehiculo);
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
