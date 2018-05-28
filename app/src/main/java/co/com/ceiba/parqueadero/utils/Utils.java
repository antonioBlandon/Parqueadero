package co.com.ceiba.parqueadero.utils;

import java.text.SimpleDateFormat;

public class Utils {

    static Utils reference;

    private Utils (){}

    public static String getDateHourInFormat(long timeInMillis){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy HH:mm");
        return sdf.format(timeInMillis);
    }

}
