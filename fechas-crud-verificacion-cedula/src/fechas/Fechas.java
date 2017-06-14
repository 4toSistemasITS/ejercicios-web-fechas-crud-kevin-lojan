/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fechas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import static java.time.temporal.TemporalQueries.zone;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.util.calendar.Gregorian;

/**
 *
 * @author Kevin
 */
public class Fechas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here gregorian
            Date fechaactual = new Date();
//        SimpleDateFormat formato =new SimpleDateFormat("yyyy--mm-dd");
//        String fecha=formato.format(fechaactual);
//        //para transformar un string a una fecha
//        
//        String fechacambiar ="2017-05-29";
//        try {
//            Date fechacambiada = formato.parse(fechacambiar);
//                    System.out.println("La fecha es"+ fechacambiada);
//
//        } catch (ParseException ex) {
//            Logger.getLogger(Fechas.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
            GregorianCalendar calender = new GregorianCalendar();
            calender.setTime(fechaactual);
            int diseño = calender.get(GregorianCalendar.DAY_OF_MONTH);
            
            calender.add(GregorianCalendar.HOUR_OF_DAY, GregorianCalendar.HOUR_OF_DAY);
            System.out.println(calender.getTime());

            calender.add( GregorianCalendar.HOUR, -1);
            System.out.println(calender.getTime());
            
            
            System.out.println("El mes es"+diseño);
       }
    
    
}
