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
    public void testValidarPlacaSinAInicial(){
        //Arrange
        Vehiculo vehiculo = aVehicle().withPlacaWithoutAinit("BTA234").build();
        //Act
        boolean puedeIngresar = vigilante.validarPlaca(vehiculo.getPlaca(),vehiculo.getFechaIngreso());
        //Assert
        Assert.assertEquals(true,puedeIngresar);
    }

    @Test
    public void testValidarPlacaConAInicialDiasValidos(){
        //Arrange
        Vehiculo vehiculo = aVehicle().withFechaValida(1515934000).build();//Sun Jan 18 1970 08:05:34 GMT-0500
        //Act
        boolean puedeIngresar = vigilante.validarPlaca(vehiculo.getPlaca(),vehiculo.getFechaIngreso());
        //Assert
        Assert.assertEquals(true,puedeIngresar);
    }

    @Test
    public void testValidarPlacaConAInicialDiasNoValidos(){
        //Arrange
        Vehiculo vehiculo = aVehicle().build();
        //Act
        boolean puedeIngresar = vigilante.validarPlaca(vehiculo.getPlaca(),vehiculo.getFechaIngreso());
        //Assert
        Assert.assertEquals(false,puedeIngresar);
    }

    @Test
    public void testCalcularTiempoVehiculoParqueadero(){
        //Arrange
        Vehiculo vehiculo = aVehicle().build();
        //Act
        long horasEnParqueadero = vigilante.calcularTiempoVehiculoParqueadero(vehiculo.getFechaIngreso(),vehiculo.getFechaSalida());
        //Assert
        Assert.assertEquals(21,horasEnParqueadero);
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