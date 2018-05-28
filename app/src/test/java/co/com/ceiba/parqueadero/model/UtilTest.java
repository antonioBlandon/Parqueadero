package co.com.ceiba.parqueadero.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.parqueadero.utils.Utils;

public class UtilTest {

    @Test
    public void getDateHourInFormat() {
        //Arrange
        long timeInMillis = 1353934000; //Fri Jan 16 1970 11:05:34 GMT-0500
        String fechaHoraEsperada = "16-01-70 11:05";
        //Act
        String fechaHora = Utils.getInstance().getDateHourInFormat(timeInMillis);
        //Assert
        System.out.println(fechaHora);
        System.out.println(fechaHoraEsperada);
        Assert.assertEquals(fechaHoraEsperada, fechaHora);
    }
}
