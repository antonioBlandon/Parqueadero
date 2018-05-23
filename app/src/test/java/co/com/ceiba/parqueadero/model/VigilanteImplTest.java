package co.com.ceiba.parqueadero.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VigilanteImplTest {

    private Vigilante vigilante;

    @Before
    public void preparaData(){
        vigilante = new VigilanteImpl();
    }

    @Test
    public void testValidarCantidadCarros(){
        //Arrange
        int cantidadCarrosActual = 19;
        //Act
        boolean puedeIngresar = vigilante.validarCantidadCarros(cantidadCarrosActual);
        //Assert
        Assert.assertEquals(true,puedeIngresar);
    }

    @Test
    public void testValidarCantidadCarros1(){
        //Arrange
        int cantidadCarrosActual = 21;
        //Act
        boolean puedeIngresar = vigilante.validarCantidadCarros(cantidadCarrosActual);
        //Assert
        Assert.assertEquals(false,puedeIngresar);
    }

    @Test
    public void testValidarCantidadMotos(){

    }

    @Test
    public void testValidarPlaca(){

    }

    @Test
    public void testCalcularTiempoVehiculoParqueadero(){

    }

    @Test
    public void testCobrarParqueadero(){

    }

    @Test
    public void testSacarVehiculo(){

    }

    @Test
    public void testObtenerCantidadDeDiasYHoras(){

    }

}