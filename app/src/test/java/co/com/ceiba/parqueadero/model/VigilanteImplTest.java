package co.com.ceiba.parqueadero.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static co.com.ceiba.parqueadero.model.VehiculoBuilder.aVehicle;

import co.com.ceiba.parqueadero.entities.Vehiculo;
import co.com.ceiba.parqueadero.entities.Vigilante;
import co.com.ceiba.parqueadero.entities.VigilanteImpl;

public class VigilanteImplTest {

    private Vigilante vigilante;

    @Before
    public void preparaData() {
        vigilante = VigilanteImpl.getInstance();
    }

    @Test
    public void testValidarPlacaSinAInicial() {
        //Arrange
        Vehiculo vehiculo = aVehicle().withPlacaWithoutAinit("BTA234").build();
        //Act
        boolean puedeIngresar = vigilante.validarPlaca(vehiculo.getPlaca(), vehiculo.getFechaIngreso());
        //Assert
        Assert.assertEquals(true, puedeIngresar);
    }

    @Test
    public void testValidarPlacaConAInicialDiasValidos() {
        //Arrange
        Vehiculo vehiculo = aVehicle().withFechaValida(1515934000).build();//Sun Jan 18 1970 08:05:34 GMT-0500
        //Act
        boolean puedeIngresar = vigilante.validarPlaca(vehiculo.getPlaca(), vehiculo.getFechaIngreso());
        //Assert
        Assert.assertEquals(true, puedeIngresar);
    }

    @Test
    public void testValidarPlacaConAInicialDiasNoValidos() {
        //Arrange
        Vehiculo vehiculo = aVehicle().build();
        //Act
        boolean puedeIngresar = vigilante.validarPlaca(vehiculo.getPlaca(), vehiculo.getFechaIngreso());
        //Assert
        Assert.assertEquals(false, puedeIngresar);
    }

    @Test
    public void testCalcularTiempoVehiculoParqueadero() {
        //Arrange
        Vehiculo vehiculo = aVehicle().build();
        //Act
        long horasEnParqueadero = vigilante.calcularTiempoVehiculoParqueadero(vehiculo.getFechaIngreso(), vehiculo.getFechaSalida());
        //Assert
        Assert.assertEquals(27, horasEnParqueadero);
    }

    //Si el carro permaneció un día y 3 horas se debe cobrar 11.000
    @Test
    public void testCobrarParqueaderoCarro() {
        //Arrange
        Vehiculo vehiculo = aVehicle()
                .withTiempoEnParqueadero(3, 1).buildCar();
        //Act
        long cobro = vigilante.cobrarParqueadero(vehiculo);
        //Assert
        Assert.assertEquals(11000, cobro);
    }

    //Si la moto permaneció un 10 horas y es de 650CC se cobra 6.000
    @Test
    public void testCobrarParqueaderoMotoConAltoCilindraje() {
        //Arrange
        Vehiculo vehiculo = aVehicle()
                .withFechaDeSalida(1389934000) //Fri Jan 16 1970 21:05:34 GMT-0500
                .withTiempoEnParqueadero(0, 1)
                .buildMotoWithCilindraje(650);
        //Act
        long cobro = vigilante.cobrarParqueadero(vehiculo);
        //Assert
        Assert.assertEquals(6000, cobro);
    }

    //Si la moto permaneció un 10 horas se cobra 4.000
    @Test
    public void testCobrarParqueaderoMotoConBajoCilindraje() {
        //Arrange
        Vehiculo vehiculo = aVehicle()
                .withFechaDeSalida(1389934000) //Fri Jan 16 1970 21:05:34 GMT-0500
                .withTiempoEnParqueadero(0, 1)
                .buildMotoWithCilindraje(250);
        //Act
        System.out.println(vehiculo.toString());
        long cobro = vigilante.cobrarParqueadero(vehiculo);
        //Assert
        Assert.assertEquals(4000, cobro);
    }

    @Test
    public void testCalcularDiasHoras() {
        //Arrange
        Vehiculo vehiculo = aVehicle().build();
        //Act
        long[] diasHoras = vigilante.calcularDiasHoras(35);
        //Assert
        Assert.assertArrayEquals(new long[]{2, 0}, diasHoras);
    }

}