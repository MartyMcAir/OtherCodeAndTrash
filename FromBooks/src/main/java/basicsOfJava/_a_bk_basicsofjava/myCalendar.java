/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._a_bk_basicsofjava;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;

/**
 *
 * @author MartyMcAir
 */
public class myCalendar {

    public static void main(String[] args) {
//        String[] weeks = getNameWeeks();
//        System.out.println(weeks[0]);

//        System.out.println("_" + showOnCenter("mytext", 20) + "_");
//        System.out.println("_" + showOnCenter("mytext", 20, '*') + "_");
//        System.out.println("_" + showOnCenter("mytextmytext", 10) + "_");

//        printCalendarOnMonth(2019, 02, LocalDate.now());
        printCalendarOnYear(LocalDate.now().getYear(), LocalDate.now());
    }

    public static void printCalendarOnYear(int year, LocalDate currDay) {
        System.out.println(showOnCenter("Календарь на " + year + " год", 28));
        for (int i = 1; i <= 12; i++) {
            System.out.println();
            printCalendarOnMonth(year, i, currDay);
        }
    }

    public static void printCalendarOnMonth(int year, int month, LocalDate currDay) {
        if (currDay == null || month < 1 || month > 12) {
            // оператор return и пользуется для выхода из метода
            // и передачи управленя инструкциям следующим после вызова метода
            return;
        }
        // создаем объект LocalDate _ и заполняем полученными аргументами
        // year и month _ 1-т.е. первого дня
        LocalDate d = LocalDate.of(year, month, 1);

        // получаем массивы месяцев и дней недели
        String[] nameMonths = getNameMonth();
        String[] nameWeek = getNameWeeks();

        // выводим значения месяца и дней недели
        // метод возвращает номер месяца от 1 до 12, 
        // а индекс массива nameMonths считается от 0 до 11
        // поэтому для корректной выборки из массива минусуем от getMonthValue -1
        // и отправляем на выравнивание по центру в метод showOnCenter()
        System.out.println(showOnCenter(nameMonths[d.getMonthValue() - 1], 28));
        // выводим все названия недели и выравниваем их через showOnCenter()
        for (int i = 0; i < nameWeek.length; i++) {
            System.out.print(showOnCenter(nameWeek[i], 4));
        }

        // формируем отступ для первой строки
        int indent = 0;

        LocalDate d2 = d.withDayOfMonth(1);   // указан 1ый день месяца
        DayOfWeek currDayOfWeek = d2.getDayOfWeek(); //сохран название 1го дн недели
        DayOfWeek firstDayOfWeek = DayOfWeek.MONDAY; // присваиваем  Monday

        while (firstDayOfWeek != currDayOfWeek) {
            indent++; // с каждой интерацией отступ увеливчивается
            d2 = d2.minusDays(1); // "сдвигаем дату" на один день назад
            currDayOfWeek = d2.getDayOfWeek();
        }

        if (indent != 0) {
            System.out.println();
        }
        // Выводи отступы
        for (int i = 0; i < indent; i++) {
            System.out.print("    ");
        }

        // выводим числа месяца
        for (int i = 1, j = d.lengthOfMonth() + 1; i < j; i++) {
            // Если текущий день недели равен первому дню, то с новой строки
            if (d.withDayOfMonth(i).getDayOfWeek() == firstDayOfWeek) {
                System.out.println();
            }
            // выводим текущ значение дня в поле шир 3 символа
            System.out.printf("%3d", i);

            // если текущий день, то помечаем его символом *
            // сравниваем withDayOfMonth() с днём текущим
            if (d.withDayOfMonth(i).equals(currDay)) {  // currDay - текущий день 
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    // массив строк с назв месяцев на русск
    public static String[] getNameMonth() {
        return new String[]{"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь",
            "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
    }

    // массив названий дней недели на русск
    public static String[] getNameWeeks() {
        return new String[]{"Понедельник", "Вторник", "Среда", "Четверг",
            "Пятница", "Суббота", "Воскресенье"};
    }

    // для выравнивания текста по центру внутри строки с заданной длиной
    public static String showOnCenter(String str, int alignIndent) {
        return showOnCenter(str, alignIndent, ' ');
    } // alignIndent длина выравнивания текста str, chr - символ разделитель

    public static String showOnCenter(String str, int alignIndent, char chr) {
        int strLength = str.length();
        // если строка пустая _ да бы невызвалось исключение
        if (str == null) {
            return "";
        } // опять проверка на 0 _если strLength=0 или alignIndent выравнивание<0
        if (alignIndent <= 0 || strLength == 0) {
            return "";
        } // если длин строки равна требуемой длине выравниван то вернуть строку
        if (strLength == alignIndent) {
            return str;
        } // если длина строки больше требуемому alignIndent выравниванию по центру
        // то обрезаем строку до требуемого кол-ва символов alignIndent выравнивания
        if (strLength > alignIndent) {
            return str.substring(0, alignIndent);
        }
        // вычитаем из нужного отступа длину строки и делим на 2
        // для олучения кол-ва симв сколько нужно добавить в начало
        int start = (alignIndent - strLength) / 2;
        int end = alignIndent - start - strLength;
        char[] arrStart = new char[start];
        char[] arrEnd = new char[end];
        // заполняем массивы полученными символами chr
        Arrays.fill(arrStart, chr);
        Arrays.fill(arrEnd, chr);
        // valueOf() преобразуем массивы в строку и совмещая
        // с нужной строкй возвращаем
        return String.valueOf(arrStart) + str
                + String.valueOf(arrEnd);
    }

}
