package co.com.ceiba.parqueadero.utils;

import java.text.SimpleDateFormat;

public class Utils {

    static Utils reference;

    private Utils (){}

    public static Utils getInstance(){
        if(reference == null){
            reference = new Utils();
        }
        return reference;
    }

    public String getDateHourInFormat(long timeInMillis){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy HH:mm:SS");
        return sdf.format(timeInMillis);
    }

}
