/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._a_bk_basicsofjava;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author MartyMcAir
 */
public class DateTime {

    public static void main(String[] args) {

    }

    public static void showExamplesInstant(){
        Instant ins = Instant.now();
        System.out.println(ins);   // 2019-02-07T09:28:30.996210Z

        Instant ins2 = Instant.ofEpochMilli(System.currentTimeMillis());
        System.out.println(ins2);   // 2019-02-07T09:31:56.283Z

        Instant ins3 = Instant.ofEpochSecond(1461883818L, 3800000000L);
        System.out.println(ins3);   // 2016-04-28T22:50:21.800Z

        Instant ins4 = Instant.parse("2019-02-07T12:35:18.380Z");
        System.out.println(ins4);   // 2019-02-07T12:35:18.380Z
        // ну или на основе объекта Date класса
        Instant ins5 = new Date().toInstant();
        System.out.println(ins5);   // 2019-02-07T09:37:59.728Z

        System.out.println(Date.from(ins5));   // Thu Feb 07 12:39:21 MSK 2019
    }
    
    public static void showExamplesLocalDateTime() {
        LocalTime tNow = LocalTime.now();
        System.out.println(tNow.toString());  // 16:14:09.674741900

        LocalTime tOf = LocalTime.of(12, 4, 36, 253000000);
        System.out.println(tOf.toString());  // 12:04:36.253

        LocalTime sDay = LocalTime.ofSecondOfDay(5 * 60 * 60);
        System.out.println(sDay.toString());  // 05:00

        LocalTime nanoDay = LocalTime.ofNanoOfDay(5 * 60 * 60 * 1_000_000_000L);
        System.out.println(nanoDay.toString());  // 05:00

        LocalTime lt = LocalTime.parse("13:18:06.333");
        System.out.println(lt.toString()); // 13:18:06.333

        LocalTime lt2 = LocalTime.parse("13.16", DateTimeFormatter.ofPattern("mm.HH"));
        System.out.println(lt2.toString()); // 16:13

        LocalTime lt3 = LocalTime.of(9, 9, 9);
        lt3 = lt3.withHour(13);
        lt3 = lt3.withMinute(16);
        lt3 = lt3.withSecond(18);
        lt3 = lt3.withNano(19);
        System.out.println(lt3.toString());

        LocalTime lt4 = LocalTime.of(1, 0);
        LocalTime lt5 = LocalTime.of(1, 0);
        System.out.println(lt4.toSecondOfDay());   // 3600
        System.out.println(lt4.toNanoOfDay());   // 3600000000000

        System.out.println(lt4.plusHours(1));
        System.out.println(lt4.minusMinutes(30));

        LocalDate ld = LocalDate.of(2019, 03, 03);
        System.out.println(lt4.atDate(ld));  // 2019-03-03T01:00

        System.out.println(lt4.equals(lt3)); // false
        System.out.println(lt4.equals(lt5)); // true

        System.out.println(lt4.compareTo(lt3)); // -1
        System.out.println(lt3.compareTo(lt4)); // 1
        System.out.println(lt4.compareTo(lt5)); // 0

        System.out.println(lt4.isBefore(lt3)); // true
        System.out.println(lt3.isBefore(lt4)); // false

        LocalTime lt6 = LocalTime.of(13, 16, 18);
        System.out.println(lt6.format(DateTimeFormatter.ofPattern("HH:mm"))); // 13:16

        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt); // 2019-02-06T17:12:38.438937700

        LocalDateTime ldt2 = LocalDateTime.of(2333, 6, 28, 13, 00);

        System.out.println(ldt2);   // 2333-06-28T13:00

        LocalDateTime ldt3 = LocalDateTime.ofEpochSecond(
                System.currentTimeMillis() / 1000, 0, ZoneOffset.of("+3")); // GMT+3 Moscow
        System.out.println(ldt3);   // 2019-02-06T17:20:07

        LocalDateTime ldt4 = LocalDateTime.ofInstant(
                Instant.now(), ZoneId.of("Europe/Moscow"));
        System.out.println(ldt4);   // 2019-02-06T17:26:29.036578800

        LocalDateTime ldt5 = LocalDateTime.parse("13.03.2019 11:08",
                DateTimeFormatter.ofPattern("dd.MM.uuuu HH:mm"));
        System.out.println(ldt5);   // 2019-03-13T11:08

        ldt2 = ldt2.withYear(2333);
        ldt2 = ldt2.withMonth(3);
        System.out.println(ldt2);   // 2333-03-28T13:00

        System.out.println(ldt2.getDayOfMonth());   // 28
        System.out.println(ldt2.getDayOfWeek());   // TUESDAY
        System.out.println(ldt2.getHour());   // 13

        System.out.println(ldt2.plusHours(1));   // 2333-03-28T14:00
        System.out.println(ldt2.plusNanos(5000000000L));   // 2333-03-28T13:00:05
        System.out.println(ldt2.minusHours(1));   // 2333-03-28T12:00

//        LocalDate ld9 = ldt2.toLocalDate();
//        
//        ldt2 = ldt2.withDayOfYear(32);
//        System.out.println(ldt2);   // 2333-02-01T13:00
        LocalDateTime ldt6 = LocalDateTime.of(2333, 6, 28, 13, 00);
        LocalDateTime ldt7 = LocalDateTime.of(2333, 6, 28, 13, 00);
        LocalDateTime ldt8 = LocalDateTime.of(2333, 6, 28, 11, 00);
        System.out.println(ldt6.equals(ldt7));   // true
        System.out.println(ldt6.equals(ldt8));   // false

        System.out.println(ldt6.compareTo(ldt7));   // 0
        System.out.println(ldt6.compareTo(ldt8));   // 1
        System.out.println(ldt8.compareTo(ldt6));   // -1

        System.out.println(ldt6.isBefore(ldt7));   // false
        System.out.println(ldt8.isBefore(ldt6));   // true
        System.out.println(ldt6.isBefore(ldt8));   // false

        System.out.println(ldt6.isAfter(ldt7));   // false
        System.out.println(ldt8.isAfter(ldt6));   // false
        System.out.println(ldt6.isAfter(ldt8));   // true

        System.out.println(ldt6.format(
                DateTimeFormatter.ofPattern("dd.MM.uuuu HH:mm:ss")));   // 28.06.2333 13:00:00
    }

    public static void showExamplesLocalDate() {
        System.out.println(LocalDate.MAX);
        System.out.println(LocalDate.MIN);

        LocalDate ld = LocalDate.now();
        System.out.println(ld);

        LocalDate myD = LocalDate.of(2300, 06, 13);
        System.out.println(myD);

        LocalDate myD2 = LocalDate.of(2330, Month.JULY, 13);
        System.out.println(myD2);

        LocalDate myD3 = LocalDate.ofYearDay(2333, 32);
        System.out.println(myD3);

        LocalDate myD4 = LocalDate.parse("2333-06-13");
        System.out.println(myD4);

        LocalDate myD5 = LocalDate.parse("2333-08-13",
                DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(myD5);

        LocalDate myD6 = LocalDate.of(2900, 8, 19);
        myD6 = myD6.withYear(3300);
        myD6 = myD6.withMonth(9);
        myD6 = myD6.withDayOfMonth(13);
        System.out.println(myD6);

        LocalDate myD7 = LocalDate.of(3333, 6, 6);
        myD7 = myD7.withDayOfYear(38);
        System.out.println(myD7);

        LocalDate myD8 = LocalDate.of(2333, 6, 13);
        System.out.println(myD8.getDayOfMonth());

        LocalDate myD9 = LocalDate.of(2333, 8, 16);
        System.out.println(myD9.getDayOfYear());
        System.out.println(myD9.getDayOfWeek());
        System.out.println(myD9.lengthOfMonth());
        System.out.println(myD9.lengthOfYear());
        System.out.println(myD9.toEpochDay());
        System.out.println(myD9.plusMonths(1));
        System.out.println(myD9.minusDays(3));
        System.out.println(myD9.atStartOfDay());

        System.out.println(myD9.atTime(10, 2));   // 2333-08-16T10:02
        // 2333-08-16T10:02:20.000000025
        System.out.println(myD9.atTime(10, 2, 20, 25));
        System.out.println(myD9.atTime(LocalTime.of(20, 17))); // 2333-08-16T20:17 

        LocalDate myD10 = LocalDate.of(2033, 3, 13);
        LocalDate myD11 = LocalDate.of(2033, 3, 13);
        LocalDate myD12 = LocalDate.of(2033, 3, 16);
        System.out.println(myD10.equals(myD11));   // true
        System.out.println(myD10.equals(myD12));   // false

        System.out.println(myD10.compareTo(myD11));   // 0
        System.out.println(myD10.compareTo(myD12));   // -3
        System.out.println(myD12.compareTo(myD10));   // 3

        System.out.println(myD10.isBefore(myD11));   // false
        System.out.println(myD10.isBefore(myD12));   // true
        System.out.println(myD12.isBefore(myD10));   // false

        System.out.println(myD10.isAfter(myD11));   // false
        System.out.println(myD10.isAfter(myD12));   // false
        System.out.println(myD12.isAfter(myD10));   // true

        System.out.println(myD10.toString());   // 2033-03-13
        System.out.println(myD10.format(
                DateTimeFormatter.ofPattern("dd.MM.uuuu")));   //  13.03.2033
    }
}
