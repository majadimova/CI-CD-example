package util;

import java.util.Date;
import java.util.concurrent.TimeUnit;


public class DateCalculator{
    public static long izracunajBrojDana(Date datumRodjenja,Date danas){
        long razlikaVremena = danas.getTime() - datumRodjenja.getTime();
        return TimeUnit.DAYS.convert(razlikaVremena, TimeUnit.MILLISECONDS);

    }
}
