/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepByStep.step6Six.clon4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Calendar;

/**
 *
 * @author MartyMcAir
 */
public class Run {

    public static void main(String[] args) {
        clsClon orig = new clsClon(LocalDate.now());
        orig.ldMinusMonth(3);
        orig.setCalendar(Calendar.getInstance());
        orig.getCalendar().set(9999, 6, 13);
        orig.setStr("_ Оригинальная строка");
        orig.setArr(new int[]{33,18,38});
        clsClon notClon = orig;

        System.out.println("#1 Step #1 _ Выводим оригинальные данные: ");  
        int year = orig.getLd().getYear();
        int month = orig.getLd().getMonthValue();
        int day = orig.getLd().getDayOfMonth();
        System.out.println("orig.getLd() _ ldMinusMonth неработает: "
                +orig.getLd());
        System.out.println("orig.getCalendar() _ изменение даты работает: "
                +orig.getCalendar().getTime());
        System.out.println("orig.formatLd форматирование даты: "+
                orig.formatLd(year, month, day));
        System.out.println("orig.getDate(): "+orig.getDate());
        System.out.println("orig.getStr(): " + orig.getStr());
        System.out.println("orig.getArr(): "+Arrays.toString(orig.getArr()));
        
        ////////////////////////////////////////////////////////////////////////
        System.out.println("\n#2 Step #2 _ Выводим измененные данные не клона: ");  
        notClon.ldMinusMonth(3); //минус 3мес объект изменен,а на результ это не повлияло
        notClon.getCalendar().set(8888, 8, 18);
        notClon.setStr("_ строка не клона");
        notClon.changeDate(Long.MIN_VALUE);
        notClon.setArr(new int[]{88,99,66});
        System.out.println("LocalDate минус не сработал: " + notClon.getLd());
        System.out.println("измененный Calendar() не клона (изменения работают): "
                +notClon.getCalendar().getTime());
        System.out.println("измененная Date не клона: " + notClon.getDate());
        System.out.println("измененная cтрока не клона: " + notClon.getStr());
        System.out.println("измененный массив не клона: "+
                Arrays.toString(notClon.getArr()));
        
        ////////////////////////////////////////////////////////////////////////        
        System.out.println("\n#3 Step #3 _ Проверяем оригинальные данные изменились "
                + "ли они, от изменений объекта не клона: ");
        System.out.println("orig LocalDate без изменений: "+orig.getLd());
        System.out.println("orig Calendar() изменен: "
                +notClon.getCalendar().getTime());
        System.out.println("orig Date изминена "+orig.getDate());
        System.out.println("orig Строка изминена "+orig.getStr());
        System.out.println("orig Arr изминен: "+Arrays.toString(orig.getArr()));

        ////////////////////////////////////////////////////////////////////////        
        System.out.println("\n#4 Step #4 _ Выводим измененные данные клона: ");  
        clsClon clon = orig.clone();
        clon.ldMinusMonth(3); //минус 3мес объект изменен,а на результ это не повлияло
        clon.setStr("_ строка клона");
        clon.changeDate(Long.MAX_VALUE);
        clon.setArr(new int[]{999,888,666});
        clon.getCalendar().set(13000, 3, 3);
        System.out.println("минус не сработал: " + clon.getLd());
        System.out.println("измененный Calendar() клона: "
                +clon.getCalendar().getTime());
        System.out.println("измененная Date клона: " + clon.getDate());
        System.out.println("измененная cтрока клона: " + clon.getStr());
        System.out.println("измененный массив клона: "+
                Arrays.toString(clon.getArr()));

        ////////////////////////////////////////////////////////////////////////        
        System.out.println("\n#5 Step #5 _ Проверяем оригинальные данные изменились "
                + "ли они, от изменений объекта клона _"
                + "\nт.е. тут должны быть данные не клона: ");
        System.out.println("orig LocalDate без изменений: "+orig.getLd());
        System.out.println("orig Calendar() не изменен: "
                +notClon.getCalendar().getTime());
        System.out.println("orig Date изминена "+orig.getDate());
        System.out.println("orig Строка изминена "+orig.getStr());
        System.out.println("orig Arr изминен: "+Arrays.toString(orig.getArr()));        
    }

    void showOthMinus() throws ParseException {
        Run cls = new Run();
        LocalTime lt = LocalTime.now();
        System.out.println("lt: " + lt); // 00:59:46.771692300
        System.out.println("Duration minus: " + lt.minus(Duration.ofDays(1)));
        //        System.out.println(sdf.parse(lt.toString())); // err

        LocalDate ld = LocalDate.now();
        System.out.println("\nld: " + ld); // 2019-05-10
        System.out.println("ChronoUnit minus: " + ld.minus(1, ChronoUnit.MONTHS));
        System.out.println("Period minus: " + ld.minus(Period.ofMonths(1)));
        cls.universalFormatDate(ld.getYear(), ld.getMonthValue(), ld.getDayOfMonth());

        LocalDateTime ldt = LocalDateTime.now();
        System.out.println("\nldt: " + ldt); // 2019-05-10T00:59:46.806127400
        System.out.println("ChronoUnit minus: " + ldt.minus(1, ChronoUnit.MONTHS));
        System.out.println("Period minus: " + ldt.minus(Period.ofMonths(1)));
        System.out.println("Duration minus: " + ldt.minus(Duration.ofDays(1)));
        cls.universalFormatDate(ldt.getYear(), ldt.getMonthValue(), ldt.getDayOfMonth());

        Instant ins = Instant.now();
        System.out.println("\nins: " + ins); // 2019-05-09T21:59:46.809122100Z
        System.out.println("Duration minus: " + ins.minus(Duration.ofDays(1)));

        ZonedDateTime zdt = ZonedDateTime.now();
        System.out.println("\nzdt: " + zdt); // 2019-05-10T00:59:46.824093300+03:00[Europe/Moscow]
        System.out.println("ChronoUnit minus: " + zdt.minus(1, ChronoUnit.MONTHS));
        System.out.println("Period minus: " + zdt.minus(Period.ofMonths(1)));
        System.out.println("Duration minus: " + zdt.minus(Duration.ofDays(1)));
        cls.universalFormatDate(zdt.getYear(), zdt.getMonthValue(), zdt.getDayOfMonth());

        OffsetDateTime odt = OffsetDateTime.now();
        System.out.println("\nodt: " + odt); // 2019-05-10T00:59:46.828584800+03:00
        System.out.println("ChronoUnit minus: " + odt.minus(1, ChronoUnit.MONTHS));
        System.out.println("Period minus: " + odt.minus(Period.ofMonths(1)));
        System.out.println("Duration minus: " + odt.minus(Duration.ofDays(1)));
        cls.universalFormatDate(odt.getYear(), odt.getMonthValue(), odt.getDayOfMonth());

    }

    void universalFormatDate(int year, int month, int day) {
        // Deprecated
        //        Date d = Date.from(Instant.MIN);
        //        d.setYear(year);
        //        d.setMonth(month);
        //        d.setDate(day);
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day);
        SimpleDateFormat sdf = new SimpleDateFormat("y.mm.dd _ HH:mm");
        System.out.println("universalFormatDate костыль show: "
                + sdf.format(cal.getTime()));
    }
}
