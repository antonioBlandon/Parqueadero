package co.com.ceiba.parqueadero.model;

import android.content.Context;
import android.test.mock.MockContext;

import org.junit.Assert;
import org.junit.Test;

import co.com.ceiba.parqueadero.storage.DataBaseHelper;
import co.com.ceiba.parqueadero.storage.DataBaseParqueaderoManager;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DataBaseParqueaderoManagerTest {

    @Test
    public void createTest(){
        Context context = new MockContext();
        //Estos son los dos intentos que he hecho de crear una instancia de la clase
        DataBaseParqueaderoManager db2 = new DataBaseParqueaderoManager(context);
        DataBaseParqueaderoManager db = mock(DataBaseParqueaderoManager.class);
        when(db.read(anyString())).thenReturn(1);
    }

}
