package co.com.ceiba.parqueadero.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static co.com.ceiba.parqueadero.model.ParqueaderoBuilder.aParking;
import static co.com.ceiba.parqueadero.model.VehiculoBuilder.aVehicle;
import java.util.Calendar;

public class VigilanteImplTest {

    private Vigilante vigilante;

    @Before
    public void preparaData(){
        vigilante = new VigilanteImpl();
    }

    @Test
    public void testValidarCantidadCarrosMenor(){
        //Arrange
        Parqueadero parqueadero = aParking().build();
        //Act
        boolean puedeIngresar = vigilante.validarCantidadCarros(parqueadero.getCantidadCarros());
        //Assert
        Assert.assertEquals(true,puedeIngresar);
    }

    @Test
    public void testValidarCantidadCarrosMayor(){
        //Arrange
        Parqueadero parqueadero = aParking().withLimitCar(20).build();
        //Act
        boolean puedeIngresar = vigilante.validarCantidadCarros(parqueadero.getCantidadCarros());
        //Assert
        Assert.assertEquals(false,puedeIngresar);
    }

    @Test
    public void testValidarCantidadMotosMenor(){
        //Arrange
        Parqueadero parqueadero = aParking().build();
        //Act
        boolean puedeIngresar = vigilante.validarCantidadMotos(parqueadero.getCantidadMotos());
        //Assert
        Assert.assertEquals(true,puedeIngresar);
    }

    @Test
    public void testValidarCantidadMotosMayor(){
        //Arrange
        Parqueadero parqueadero = aParking().withLimitMoto(10).build();
        //Act
        boolean puedeIngresar = vigilante.validarCantidadMotos(parqueadero.getCantidadMotos());
        //Assert
        Assert.assertEquals(true,puedeIngresar);
    }

    @Test
    public void testValidarPlacaConAInicial(){
        /*//Arrange
        String placa = "ABC123";
        long fechaIngreso = Calendar.getInstance().getTimeInMillis();
        //Act
        boolean puedeIngresar = vigilante.validarPlaca(placa,fechaIngreso);
        //Assert
        Assert.assertEquals(true,puedeIngresar);*/
    }

    @Test
    public void testValidarPlacaSinAInicial(){
        //Arrange
        String placa = "BAC123";
        long fechaIngreso = Calendar.getInstance().getTimeInMillis();
        //Act
        boolean puedeIngresar = vigilante.validarPlaca(placa,fechaIngreso);
        //Assert
        Assert.assertEquals(true,puedeIngresar);
    }

    @Test
    public void testValidarPlacaConAInicialDiaValido(){

    }

    @Test
    public void testValidarPlacaConAInicialDiaInvalido(){

    }

    @Test
    public void testCalcularTiempoVehiculoParqueadero(){

    }

    @Test
    public void testCobrarParqueadero(){

    }

    @Test
    public void testSacarCarro(){
        //Arrange
        Carro carro = aVehicle().buildCar();
        Parqueadero parqueadero = aParking().withLimitCar(20).build();
        //Act
        boolean conVehiculos = vigilante.sacarVehiculo(carro,parqueadero.getCantidadCarros());
        //Assert
        Assert.assertEquals(true,conVehiculos);
    }

    @Test
    public void testSacarMoto(){
        //Arrange
        Moto moto = aVehicle().buildMoto();
        Parqueadero parqueadero = aParking().withLimitMoto(10).build();
        //Act
        boolean conVehiculos = vigilante.sacarVehiculo(moto,parqueadero.getCantidadMotos());
        //Assert
        Assert.assertEquals(true,conVehiculos);
    }

    @Test
    public void testSacarCarroSinTenerCarros(){
        //Arrange
        Carro carro = aVehicle().buildCar();
        Parqueadero parqueadero = aParking().build();
        //Act
        boolean conVehiculos = vigilante.sacarVehiculo(carro,parqueadero.getCantidadCarros());
        //Assert
        Assert.assertEquals(false,conVehiculos);
    }

    @Test
    public void testSacarMotoSinTenerMotos(){
        //Arrange
        Moto moto = aVehicle().buildMoto();
        Parqueadero parqueadero = aParking().build();
        //Act
        boolean conVehiculos = vigilante.sacarVehiculo(moto,parqueadero.getCantidadMotos());
        //Assert
        Assert.assertEquals(false,conVehiculos);
    }

    @Test
    public void testObtenerCantidadDeDiasYHoras(){

    }

}