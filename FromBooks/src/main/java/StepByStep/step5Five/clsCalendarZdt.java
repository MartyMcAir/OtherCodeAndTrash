/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepByStep.step5Five;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 *
 * @author MartyMcAir
 */
public class clsCalendarZdt {

    public static void main(String[] args) {
        clsCalendarZdt cls = new clsCalendarZdt();
//            cls.showMonthZdt(2019, 4, 1); // вариант не оч.
        LocalDate lc = LocalDate.now();
        int mCurrent = lc.getMonthValue();
        int mPast = mCurrent - 1;
        int mFuture = mCurrent + 2;
        
        for (int i = mPast; i < mFuture; i++) {
        cls.showMonth(2019, i, 1);
        }
    }

    void showMonth(int year, int m, int startDay) {
        LocalDate ld = LocalDate.of(year, m, startDay);
        System.out.println();
        System.out.printf("%18s", ld.getMonth() + "\n");

        String[] weekArr = getWeek();
        for (int i = 0; i < 7; i++) {
            System.out.printf("%4s", weekArr[i]);
        }
        System.out.println();

        if (ld.getDayOfWeek() != DayOfWeek.MONDAY) {
            getIndent(ld);
        }

        for (int i = 1; i < (ld.lengthOfMonth() + 1); i++) {
            System.out.printf("%4s", i);
            if (ld.withDayOfMonth(i).getDayOfWeek() == DayOfWeek.SUNDAY) {
                System.out.println();
            }
        }
    }

    static void getIndent(LocalDate ld) {
        switch (ld.getDayOfWeek()) {
            case MONDAY:
                System.out.print("");
                break;
            case TUESDAY:
                System.out.printf("%4s", " ");   //
                break;
            case WEDNESDAY:
                System.out.printf("%8s", " ");
                break;
            case THURSDAY:
                System.out.printf("%12s", " ");
                break;
            case FRIDAY:
                System.out.printf("%16s", " ");  //
                break;
            case SATURDAY:
                System.out.printf("%20s", " ");
                break;
            case SUNDAY:
                System.out.printf("%24s", " ");
                break;
        }
    }

    void showMonthZdt(int year, int m, int startDay) {
        LocalDate ld = LocalDate.of(year, m, startDay);
        ZoneId zd = ZoneId.systemDefault();
        ZonedDateTime zdt = ZonedDateTime.of(year, m, startDay, 1, 1, 1, 1, zd);
        System.out.println();
        System.out.printf("%18s", ld.getMonth() + "\n");

        String[] weekArr = getWeek();
        for (int i = 0; i < 7; i++) {
            System.out.printf("%4s", weekArr[i]);
        }
        System.out.println();

        if (zdt.getDayOfWeek() != DayOfWeek.MONDAY) {
            getIndentZdt(zdt);
        }

        for (int i = 1; i < (ld.lengthOfMonth() + 1); i++) {
            System.out.printf("%4s", i);
            if (zdt.withDayOfMonth(i).getDayOfWeek() == DayOfWeek.SUNDAY) {
                System.out.println();
            }
        }
    }

    static void getIndentZdt(ZonedDateTime zdt) {
        switch (zdt.getDayOfWeek()) {
            case MONDAY:
                System.out.print("");
                break;
            case TUESDAY:
                System.out.printf("%4s", " ");   //
                break;
            case WEDNESDAY:
                System.out.printf("%8s", " ");
                break;
            case THURSDAY:
                System.out.printf("%12s", " ");
                break;
            case FRIDAY:
                System.out.printf("%16s", " ");  //
                break;
            case SATURDAY:
                System.out.printf("%20s", " ");
                break;
            case SUNDAY:
                System.out.printf("%24s", " ");
                break;
        }
    }

    static String[] getWeek() {
        return new String[]{"Пн", "Вт", "Ср", "Чт", "Пт", "Сб", "Вс"};
    }

    static String[] getMonth() {
        return new String[]{"Янв", "Февр", "Март", "Апр", "Май", "Июн", "Июл",
            "Авг", "Сент", "Окт", "Нояб", "Дек"};
    }
}
