/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepByStep.step5Five;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

/**
 *
 * @author MartyMcAir
 */
public class clsDateTime {
    public static void main(String[]args){
        clsDateTime cls = new clsDateTime();
//        cls.getDateTimeMethods();
//        cls.formatDatePattern();
//        cls.showMonthWeeksArr();
        cls.calendarCurrentMonth();
    }
    
    void calendarCurrentMonth(){
        LocalDate ld = LocalDate.now();
        System.out.println(ld.withDayOfMonth(1));
        LocalDate ld2 = ld.withDayOfMonth(1);
        
    }
    
    void showMonthWeeksArr(){
        ZonedDateTime zdt = ZonedDateTime.now();
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] arrMonth = dfs.getMonths();
        String[] arrWeek = dfs.getWeekdays();
        System.out.println("ZonedDateTime arrMonth[(zdt.getMonthValue()-1)]) "
                + "_ текущий месяц: "+
                arrMonth[(zdt.getMonthValue()-1)]);
        
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.format(dt);
        sdf.applyLocalizedPattern("M");
        
        String[] arrMyMonth = {"январь", "февраль", "март", "апрель",
            "май", "июнь", "июль", "август", 
            "сентябрь", "октябрь", "ноябрь", "декабрь"};
        dfs.setMonths(arrMyMonth);
        String[] arrNewMonth = dfs.getMonths();
        System.out.println("\nпосле dfs.setMonths(arrMyMonth): ");
        System.out.println("arrMonth[ (Integer.parseInt(sdf.format(dt))-1) ] "
                + "_ текущий месяц: "+
                arrNewMonth[ (Integer.parseInt(sdf.format(dt))-1) ]);
        
        sdf.applyLocalizedPattern("F");
        System.out.println("arrWeek[ (Integer.parseInt(sdf.format(dt))+1) ] "
                + "_ день недели: "+
                arrWeek[ (Integer.parseInt(sdf.format(dt))+1) ]);
        
    }
    
    void formatDatePattern(){
        DateFormatSymbols dfs = new DateFormatSymbols();
        System.out.println(dfs.getLocalPatternChars()); // GyMdkHmsSEDFwWahKzZ

        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat();
        System.out.print("Pattern по умолчанию: "+sdf.toPattern()+": "); // dd.MM.y, H:mm
        
        System.out.println("\n"+sdf.get2DigitYearStart()); // Mon Apr 24 22:14:41 MSK 1939
        sdf.applyLocalizedPattern("dd.MM.y, H:mm");
        System.out.println("\napplyLocalizedPattern(\"dd.MM.y, H:mm\"): "+
                sdf.get2DigitYearStart()); // без изменений
        
        System.out.println("sdf.format(dt): "+
                sdf.format(dt));  // 25.04.2019, 19:06
        sdf.applyLocalizedPattern("dd.MM.yy");
//        System.out.println(sdf.toPattern()); // dd.MM.yy
        System.out.println("sdf.applyLocalizedPattern(\"dd.MM.yy\"): "+
                sdf.format(dt));  // 25.04.19
        
               
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd.MM.yyyy");
        System.out.println("\nSimpleDateFormat(\"dd.MM.yyyy\"): "+
                sdf2.format(dt)); // 25.04.2019
        sdf2.applyLocalizedPattern("dd yyyy MMMM, Z; EEEE; E _ F _ FF _ M _ MM");
        System.out.println("sdf2.applyLocalizedPattern(\"dd yyyy MMMM, Z; EEEE; "
                + "E _ F _ FF _ M _ MM\"): "+
                sdf2.format(dt)); // 25 2019 апреля, +0300; четверг; чт  
    }
    
    void getDateTimeMethods(){
        Date d = new Date();
        System.out.println("get Методы Date класса: ");
        System.out.println("d.toString(): "+d.toString()); // Tue Apr 23 21:30:25 MSK 2019
        System.out.println("d.getTime(): "+d.getTime()); // 1556044225784
        System.out.println("Все остальные методы Deprecated в том числе getDay"
                + " в понед показывает 1 d.getDay(): "+d.getDay()); // 2
        
        
        Instant iNow = Instant.now();
        System.out.println("\nМетоды Instant класса: ");
        System.out.println("iNow.getEpochSecond(): "+
                iNow.getEpochSecond()); // 1556047742
        System.out.println("iNow.getNano(): "+iNow.getNano()); // 354214800
  
        
        Calendar cl = Calendar.getInstance();
        System.out.println("\nМетоды Calendar класса: ");
        System.out.println("cl.get(Calendar.YEAR): "+cl.get(Calendar.YEAR)); // 2019
        System.out.println("сейчас 4ый мес апр а показывает 3ий _ "
                + "cl.get(Calendar.MONTH): "+cl.get(Calendar.MONTH)); // 3
        System.out.println("cl.get(Calendar.DATE): "+cl.get(Calendar.DATE)); // 23
        System.out.println("в понед показыв почему-то 2 "
                + "cl.get(Calendar.DAY_OF_WEEK): "+
                cl.get(Calendar.DAY_OF_WEEK)); // 3
        System.out.println("cl.get(Calendar.HOUR_OF_DAY): "+
                cl.get(Calendar.HOUR_OF_DAY)); //21
        System.out.println("cl.get(Calendar.Minute): "+
                cl.get(Calendar.MINUTE)); // 30
        System.out.println("cl.get(Calendar.SECOND): "+
                cl.get(Calendar.SECOND)); // 25
        
        System.out.println("\ncl.getTime(): "+
                cl.getTime()); // Tue Apr 23 21:30:25 MSK 2019
        System.out.println("cl.getTimeInMillis(): "+
                cl.getTimeInMillis()); // 1556044225919
        System.out.println("cl.getTimeZone(): "+cl.getTimeZone());
        System.out.println("cl.getCalendarType(): "+
                cl.getCalendarType()); // gregory
        System.out.println("правильно вторник это 2 cl.getFirstDayOfWeek(): "+
                cl.getFirstDayOfWeek()); // 2
        
        
        GregorianCalendar grc = new GregorianCalendar();
        System.out.println("\nМетоды GregorianCalendar класса: ");
        System.out.println("grc.getTimeInMillis(): "+
                grc.getTimeInMillis()); // 1556044225957
        System.out.println("grc.getTime(): "+
                grc.getTime()); // Tue Apr 23 21:30:25 MSK 2019
        System.out.println("grc.getWeekYear(): "+grc.getWeekYear()); // 2019
        System.out.println("grc.getWeeksInWeekYear(): "+
                grc.getWeeksInWeekYear()); // 52
        System.out.println("grc.getFirstDayOfWeek(): "+grc.getFirstDayOfWeek());
        System.out.println("grc.getCalendarType(): "+
                grc.getCalendarType()); // gregory
        System.out.println("grc.getTimeZone(): "+grc.getTimeZone());
        System.out.println("правильно вторник это 2 grc.getGregorianChange(): "
                +grc.getGregorianChange()); // Fri Oct 15 03:00:00 MSK 1582
        
        
        SimpleDateFormat df = new SimpleDateFormat();
        System.out.println("\nМетоды SimpleDateFormat класса _ \n"
                + "(для форматирования дат _ использзует Date и Locale): ");
        System.out.println("df.get2DigitYearStart(): "+
                df.get2DigitYearStart()); // Sun Apr 23 21:30:25 MSK 1939
        System.out.println("df.getNumberFormat(): "+df.getNumberFormat());
        System.out.println("df.getCalendar(): "+df.getCalendar());
        System.out.println("df.getTimeZone(): "+df.getTimeZone());
        System.out.println("df.getDateFormatSymbols(): "+df.getDateFormatSymbols());

        // Locale.setDefault(Locale.US); // При изменении локали меняет язык
        DateFormatSymbols dfs = new DateFormatSymbols();
        System.out.println("\nМетоды DateFormatSymbols класса _ \n"
                +"(для получения или задать название компонента даты"
                + " на яз. соотвеств. указанной локали): ");
        System.out.println("dfs.getAmPmStrings(): "+
                Arrays.toString(dfs.getAmPmStrings()));   // [AM, PM]
        System.out.println("dfs.getEras(): "+
                Arrays.toString(dfs.getEras())); // [до н. э., н. э.]
        System.out.println("dfs.getMonths(): "+
                Arrays.toString(dfs.getMonths())); // [января, февраля, марта, апреля, мая,
        System.out.println("dfs.getShortMonths(): "+
                Arrays.toString(dfs.getShortMonths())); // [янв., февр., мар., апр., мая, июн.,
        System.out.println("dfs.getShortWeekdays(): "+
                Arrays.toString(dfs.getShortWeekdays())); // [, вс, пн, вт, ср, чт, пт, сб]
        System.out.println("dfs.getZoneStrings() 2D array: "+
                Arrays.deepToString(dfs.getZoneStrings()));
        
        
        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        System.out.println("\nМетоды DateTimeFormatter класса _ \n"
                +"(для форматирования даты и времени _ а так же при преобразовании "
                + "строки в объекты:\n LocalDate, LocalTime, LocalDateTime, Instant)");
        System.out.println("dtf.getChronology(): "+dtf.getChronology()); // ISO
        System.out.println("dtf.getDecimalStyle(): "+
                dtf.getDecimalStyle()); // DecimalStyle[0+-.]
        System.out.println("dtf.getLocale(): "+dtf.getLocale()); // ru_RU
        System.out.println("dtf.getZone(): "+dtf.getZone()); // null
        System.out.println("dtf.getResolverStyle(): "+dtf.getResolverStyle()); // SMART
        System.out.println("dtf.getResolverFields(): "+dtf.getResolverFields()); // null


        ZonedDateTime sd = ZonedDateTime.now();
        System.out.println("\nZonedDateTime методы_"
                + "(для манипуляций с временными зонами Использует Locale Zoneid..) ");
        System.out.println("sd.getChronology(): "+sd.getChronology()); // ISO
        System.out.println("sd.getDayOfMonth(): "+sd.getDayOfMonth()); // 24
        System.out.println("sd.getDayOfWeek(): "+sd.getDayOfWeek()); // WEDNESDAY
        System.out.println("sd.getDayOfYear(): "+sd.getDayOfYear()); // 114
        System.out.println("sd.getHour(): "+sd.getHour()); // 20
        System.out.println("sd.getMinute(): "+sd.getMinute()); // 14
        System.out.println("sd.getMonth(): "+sd.getMonth()); // APRIL
        System.out.println("sd.getMonthValue(): "+sd.getMonthValue()); // 4
        System.out.println("sd.getNano(): "+sd.getNano()); // 296326900
        System.out.println("sd.getOffset(): "+sd.getOffset()); // +03:00
        System.out.println("sd.getSecond(): "+sd.getSecond()); // 55
        System.out.println("sd.getYear(): "+sd.getYear()); //2019
        System.out.println("sd.getZone(): "+sd.getZone()); // Europe/Moscow
        
        System.out.println("\nClock методы _ (для манипуляций с временными зонами"
                + " использует ZoneID _ ZoneOffset..)");
        System.out.println("Clock.systemDefaultZone(): "+
                Clock.systemDefaultZone()); // SystemClock[Europe/Moscow]
        System.out.println("Clock.systemUTC(): "+
                Clock.systemUTC()); //  SystemClock[Z]
        
        System.out.println("\nZoneOffset.getAvailableZoneIds(): "+
                ZoneOffset.getAvailableZoneIds()); // [Asia/Aden, America/Cuiaba, Etc/GMT+9, ..
        
        System.out.println("\nLocalTime методы для операций над временем");
        LocalTime lt =  LocalTime.now();
        System.out.println("lt.getHour(): "+lt.getHour()); // 22
        System.out.println("lt.getMinute(): "+lt.getMinute()); // 33
        System.out.println("lt.getSecond(): "+lt.getSecond()); // 36
        System.out.println("lt.getNano(): "+lt.getNano()); // 656986400
        
        System.out.println("\nLocalDate методы для операций над временем");
        LocalDate ld = LocalDate.now();
        System.out.println("ld.getChronology(): "+ld.getChronology()); // ISO
        System.out.println("ld.getDayOfMonth(): "+ld.getDayOfMonth()); // 23
        System.out.println("ld.getDayOfWeek(): "+ld.getDayOfWeek()); // TUESDAY
        System.out.println("ld.getDayOfYear(): "+ld.getDayOfYear()); // 113
        System.out.println("ld.getEra(): "+ld.getEra()); // CE
        System.out.println("ld.getMonth(): "+ld.getMonth()); // APRIL
        System.out.println("ld.getMonthValue(): "+ld.getMonthValue()); // 4
        System.out.println("ld.getYear(): "+ld.getYear()); // 2019
        
        System.out.println("\nLocalDateTime методы для операций над временем");
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println("ldt.getChronology(): "+ldt.getChronology()); // ISO
        System.out.println("ldt.getDayOfMonth(): "+ldt.getDayOfMonth()); // 23
        System.out.println("ldt.getDayOfWeek(): "+ldt.getDayOfWeek()); // TUESDAY
        System.out.println("ldt.getDayOfYear(): "+ldt.getDayOfYear()); // 113
        System.out.println("ldt.getHour(): "+ldt.getHour()); // 22
        System.out.println("ldt.getMinute(): "+ldt.getMinute()); // 44
        System.out.println("ldt.getMonth(): "+ldt.getMonth()); // APRIL
        System.out.println("ldt.getMonthValue(): "+ldt.getMonthValue()); // 4
        System.out.println("ldt.getNano(): "+ldt.getNano()); // 797049800
        System.out.println("ldt.getSecond(): "+ldt.getSecond()); // 13
        System.out.println("ldt.getYear(): "+ldt.getYear()); // 2019
        
        System.out.println("\nTimeZone методы: ");
        TimeZone tm = TimeZone.getDefault();
        System.out.println("tm.getDSTSavings(): "+tm.getDSTSavings()); // 0
        System.out.println("tm.getDisplayName(): "+
                tm.getDisplayName()); // Москва, стандартное время
        System.out.println("tm.getID(): "+tm.getID()); // Europe/Moscow
        System.out.println("tm.getRawOffset(): "+tm.getRawOffset()); // 10800000
    }
}
