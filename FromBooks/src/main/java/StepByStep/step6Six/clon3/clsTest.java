/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepByStep.step6Six.clon3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 *
 * @author MartyMcAir
 */
public class clsTest {

    public static void main(String[] args) throws ParseException {
        clsTest cls = new clsTest();
//        cls.showUsePeriod();
//        cls.showCalendar();
//        cls.showUseChronoUnit();
        cls.showOthMinus();
//        cls.universalFormatDate(0, 0, 0);
//        cls.stringToDate();
    }

    void showOthMinus() throws ParseException {
        clsTest cls = new clsTest();
        
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
        System.out.println("universalFormatDate костыль show: "+
                sdf.format(cal.getTime()));
    }

    void xzEarlyMain() {
        //        SimpleDateFormat sdf = new SimpleDateFormat("MM.dd");
//        System.out.println(sdf.get2DigitYearStart());
//        sdf.format(new Date());
//        sdf.applyPattern("dd.MM.yyyy");
//        System.out.println(sdf.get2DigitYearStart());
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date d = new Date();
        ZonedDateTime zdt = ZonedDateTime.now();
        System.out.println("zdt: " + zdt);
        zdt.minusYears(1L);
        System.out.println("zdt2 minus: " + zdt);

        System.out.println("SDF: " + sdf.format(d)); // 24.04.2016

        Calendar cl = Calendar.getInstance();

        sdf.applyPattern("y.MM.dd");
        System.out.println("SDF: " + sdf.format(d)); // 24.04.2016

        System.out.println("Date: " + d.toString()); // 24.04.2016

        LocalDate ld = LocalDate.now();
        LocalDate ld3 = LocalDate.of(2019, Month.MARCH, 03);

        LocalDateTime ldt = LocalDateTime.now();

        System.out.println("\nld: " + ld);
        ld.minusYears(1L);
        System.out.println("ld2: " + ld);
        System.out.println("ldt: " + ldt);
        ldt.minusYears(1L);
        ldt.minusMonths(1L);
        System.out.println("ldt2: " + ldt);

        //////////////////////////////////////////
        Calendar cal = Calendar.getInstance();
        System.out.println("cal: " + cal.getTime());
        cal.setTime(new Date());
        cal.add(Calendar.MONTH, -1);
        Date result = cal.getTime();
//        System.out.println("cal1: " + cal.getTime());
        System.out.println("cal2: " + result);

//        Date date = java.sql.Date.valueOf(LocalDate.now().minus(3, ChronoUnit.MONTHS));
        // Add 2 months
        Date dOriginal = new Date();
        Date d1 = Date.from(LocalDate.now().plusMonths(2).
                atStartOfDay(ZoneId.systemDefault()).toInstant());
        SimpleDateFormat sdf9 = new SimpleDateFormat();
        System.out.println("dOriginal: " + dOriginal);
        System.out.println("d1: " + sdf9.format(d1));

// Add 5 days
        Date d2 = Date.from(LocalDate.now().plusDays(5).
                atStartOfDay(ZoneId.systemDefault()).toInstant());
        System.out.println("d2: " + sdf9.format(d2));

// Minus 1 day and 1 year
        Date d3 = Date.from(LocalDate.now().minusYears(1).minusDays(1).
                atStartOfDay(ZoneId.systemDefault()).toInstant());
        System.out.println("d3: " + sdf9.format(d3));

        //
        LocalDate mydate = LocalDate.now(); // Or whatever you want
        System.out.println("mydate original: " + mydate);
        mydate = mydate.minusMonths(1);
        System.out.println("mydate minusMonths: " + mydate);

        mydate.plusMonths(1);
        mydate.with(TemporalAdjusters.next(DayOfWeek.SUNDAY)).getDayOfMonth();
        mydate.with(TemporalAdjusters.lastDayOfMonth());
    }

    public Date addHoursToJavaUtilDate(Date date, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hours);
        return calendar.getTime();
    }

    void showCalendar() {
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.getTime());
        cal.add(Calendar.MONTH, -3);
        System.out.println(cal.getTime());

        SimpleDateFormat sdf = new SimpleDateFormat("mm.dd.y _ H:m");
        System.out.println(sdf.format(cal.getTime()));

        cal.roll(Calendar.MONTH, -6);
        System.out.println(sdf.format(cal.getTime()));
    }

    void showUseChronoUnit() {
        LocalDate d = LocalDate.now();
        LocalDate d1 = LocalDate.of(2016, Month.NOVEMBER, 12);
        System.out.println(d);

        System.out.println("YEARS: " + d.minus(1, ChronoUnit.YEARS));
        System.out.println("MONTHS: " + d.minus(1, ChronoUnit.MONTHS));
        System.out.println("DAYS: " + d.minus(1, ChronoUnit.DAYS));
        System.out.println("DECADES: " + d.minus(1, ChronoUnit.DECADES));
    }

    void showUsePeriod() {
        // Create periods in days, weeks, months and years.
        Period p1 = Period.ofDays(7);
        Period p2 = Period.ofWeeks(2);
        Period p3 = Period.ofMonths(1);
        Period p4 = Period.ofYears(1);
        Period p5 = Period.of(1, 1, 7);

        // Obtains current date and add some period to the current date using 
        // the plus() method.
        LocalDate now = LocalDate.now();
        LocalDate date1 = now.plus(p1);
        LocalDate date2 = now.plus(p2);
        LocalDate date3 = now.plus(p3);
        LocalDate date4 = now.plus(p4);
        LocalDate date5 = now.plus(p5);

        // Print out the result of adding some period to the current date.
        System.out.printf("Add some period to the date: %s%n", now);
        System.out.printf("Plus %7s = %s%n", p1, date1);
        System.out.printf("Plus %7s = %s%n", p2, date2);
        System.out.printf("Plus %7s = %s%n", p3, date3);
        System.out.printf("Plus %7s = %s%n", p4, date4);
        System.out.printf("Plus %7s = %s%n%n", p5, date5);

        // Subtract some period from the date using the minus() method.
        System.out.printf("Subtract some period from the date: %s%n", now);
        System.out.printf("Minus %7s = %s%n", p1, now.minus(p1));
        System.out.printf("Minus %7s = %s%n", p2, now.minus(p2));
        System.out.printf("Minus %7s = %s%n", p3, now.minus(p3));
        System.out.printf("Minus %7s = %s%n", p4, now.minus(p4));
        System.out.printf("Minus %7s = %s%n%n", p5, now.minus(p5));
    }

    void stringToDate() throws ParseException, ParseException {
        String sDate1 = "31/12/1998";
        String sDate2 = "31-Dec-1998";
        String sDate3 = "12 31, 1998";
        String sDate4 = "Thu, Dec 31 1998";
        String sDate5 = "Thu, Dec 31 1998 23:37:50";
        String sDate6 = "31-Dec-1998 23:37:50";
        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MMM-yyyy");
        SimpleDateFormat formatter3 = new SimpleDateFormat("MM dd, yyyy");
        SimpleDateFormat formatter4 = new SimpleDateFormat("E, MMM dd yyyy");
        SimpleDateFormat formatter5 = new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");
        SimpleDateFormat formatter6 = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        Date date1 = formatter1.parse(sDate1);
        // Unparseable date: "31-Dec-1998 23:37:50"
//        Date date2 = formatter2.parse(sDate2); // err
        Date date3 = formatter3.parse(sDate3);
//        Date date4 = formatter4.parse(sDate4); // err
//        Date date5 = formatter5.parse(sDate5); // err
//        Date date6 = formatter6.parse(sDate6); // err
        System.out.println(sDate1 + "\t" + date1);
//        System.out.println(sDate2 + "\t" + date2);
        System.out.println(sDate3 + "\t" + date3);
//        System.out.println(sDate4 + "\t" + date4);
//        System.out.println(sDate5 + "\t" + date5);
//        System.out.println(sDate6 + "\t" + date6);

        LocalDate date = LocalDate.parse("2018-05-05");
        LocalDateTime dateTime = LocalDateTime.parse("2018-05-05T11:50:55");
        ZonedDateTime zonedDateTime = ZonedDateTime.parse("2015-05-05T10:15:30+01:00[Europe/Paris]");

        String dateInString = "19590709";
        LocalDate dateIs = LocalDate.parse(dateInString,
                DateTimeFormatter.BASIC_ISO_DATE);
        String dateInStringg = "Mon, 05 May 1980";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, d MMM yyyy", Locale.ENGLISH);
        LocalDate dateTimes = LocalDate.parse(dateInStringg, formatter);

        SimpleDateFormat formatters = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        String dateInStrings = "7-Jun-2013";
        // Text '7-Jun-2013' could not be parsed at index 0
//        Date dateS = (Date) formatter.parse(dateInStrings); // err

        SimpleDateFormat formatter22 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss a", Locale.ENGLISH);
        formatter22.setTimeZone(TimeZone.getTimeZone("America/New_York"));

        String dateInString2 = "22-01-2015 10:15:55 AM";
        Date date2 = formatter22.parse(dateInString2);
        String formattedDateString = formatter22.format(date2);
    }
}
