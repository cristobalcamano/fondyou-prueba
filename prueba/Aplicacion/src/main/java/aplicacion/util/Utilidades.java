package aplicacion.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class Utilidades {

    private static final String ZONA_HORARIA_AMERICA_BOGOTA = "America/Bogota";

    public static Boolean vacio(Object cadena){

        if(cadena == null){
            return true;
        } else if(cadena instanceof String){
            String cadenaval = (String) cadena;
            if(cadenaval.equals("") ||
                    cadenaval.replace(" ","").equals("")){
                return true;
            }
        } else if(cadena instanceof Long){
            Long numeroValor = (Long) cadena;
            if(numeroValor < 0 ){
                return true;
            }
        }

        return false;
    }

    public static String validarHorarioExamen(String fecha, String zonaValidacion) throws ParseException {

        SimpleDateFormat horaMexico = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        horaMexico.setTimeZone(TimeZone.getTimeZone(zonaValidacion));

        Date fechaBogota = Utilidades.stringtoDate(fecha);
        String response = horaMexico.format(fechaBogota);

        return response;


    }

    public static Date stringtoDate(String fecha) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date horaBogotaDate = formatter.parse(fecha);

        return horaBogotaDate;
    }

    public static String dateToString(Date fecha){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String fechaCadena = formatter.format(fecha);

        return fechaCadena;
    }

}
