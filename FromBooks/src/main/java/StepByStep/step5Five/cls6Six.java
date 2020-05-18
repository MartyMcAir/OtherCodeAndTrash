/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepByStep.step5Five;

import java.nio.charset.Charset;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;

/**
 *
 * @author MartyMcAir
 */
public class cls6Six {

    public static void main(String[] args) {
        cls6Six cls = new cls6Six();
//        cls.methodTryCatch(0);
//        cls.formatString();
//        cls.useLocale();
//        cls.useNumberFormat();
//        cls.useCharset();
    }

    void useCharset() {
        System.out.println("поддерживаемые кодировки: \n"
                + Charset.availableCharsets().toString());
        String str = "АБВ ABC 123";
        byte[] cp1251 = new byte[1];
        byte[] cp866 = new byte[1];
        try {
            cp1251 = str.getBytes(Charset.forName("cp1251"));
            cp866 = str.getBytes("cp866");
        } catch (Exception e) {
            System.err.print(e.getMessage());
        }
        System.out.printf("%6s %7s %7s \n", "символ", "cp1251", "cp866");
        for (int i = 0; i < cp1251.length; i++) {
            System.out.printf("%6s %7d %7d\n",
                    str.charAt(i), cp1251[i], cp866[i]);
        }
    }

    void useNumberFormat() {
        NumberFormat nf = NumberFormat.getNumberInstance();
        NumberFormat cur = NumberFormat.getCurrencyInstance();
        NumberFormat per = NumberFormat.getPercentInstance();

        float fl = 3.13f;
        System.out.println("число: " + nf.format(fl));
        System.out.println("валюта: " + cur.format(fl));
        System.out.println("проценты: " + per.format(fl));
        System.out.println("current locale: " + Locale.getDefault());

        Locale.setDefault(Locale.US);
        System.out.println("\ncurrent locale: " + Locale.getDefault());
        System.out.println("число: " + nf.format(fl));
        System.out.println("валюта: " + cur.format(fl));
        System.out.println("проценты: " + per.format(fl));
    }

    void useLocale() {
        System.out.println("Locale.getISOLanguages() ru en?: \n"
                + Arrays.toString(Locale.getISOLanguages()));
        System.out.println("Locale.getAvailableLocales() ru_RU en_US?: \n"
                + Arrays.toString(Locale.getAvailableLocales()));
        System.out.println("current Locale is: " + Locale.getDefault());
        String strNum = "999,666";
        String strNumDot = "999.666";
        double dl = Math.PI;
        float fl = 3.13f;
        System.out.println("dl: " + dl + ", fl: " + fl + ", strNum: " + strNum
                + ", strNumDot: " + strNumDot);

        System.out.printf("Разница видна только через Printf().: %f", fl);
        System.out.println("\n");

        Locale.setDefault(Locale.US);
        System.out.println("current Locale is: " + Locale.getDefault());
        System.out.println("dl: " + dl + ", fl: " + fl + ", strNum: " + strNum
                + ", strNumDot: " + strNumDot);

        System.out.printf("Разница видна только через Printf().: %f", fl);
        System.out.println("\n");

        String ruF = String.format(new Locale("ru"), "%.2f", fl);
        String enF = String.format(new Locale("en"), "%.2f", fl);

        System.out.printf("ruF: " + ruF + "\n");
        System.out.printf("enF: " + enF);
    }

    void methodTryCatch(int a) {
        try {
            System.out.println("Демонстрация работы блока обработки ошибок.");
            int res = 10 / a;
            System.out.println(res);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.out.println("На ноль делить нельзя! _ "
                    + "ArithmeticException - класс обработки арифметических ошибок");
        } catch (Exception e) {
            System.err.print(e.getMessage());
            e.printStackTrace();
            System.out.println("Какая-то друга ошибка! _ "
                    + "Exception -главнй класс обработки всех ошибок");
        } finally {
            System.out.println("Завершающая операция, которая срабатывает "
                    + "при любых условиях");
        }
    }

    void formatString() {
        System.out.println("Форматирование строки");
        System.out.printf("%d%s", 99, "руб - без индекса _ нельзя дублировать\n");
        System.out.printf("%1$d.0 %2$s%n", 666, 3, "руб\n");
        // double 
        System.out.println("где $- указание что предыдуш цифра это индекс,"
                + " а % - разделитель следующего элемента строки, "
                + " \n n - новая строка, d - double с запятой или без (13,33 13),"
                + " s - String, "
                + " \n индекс можно продублировать несколько раз: ");
        System.out.printf("%1$d%2$s %1$d%2$s", 333, "руб");

        System.out.println("\nЕсли описать только первый тип данных,\n"
                + "но присутствует и 2 и 3ий, то все остальное будет игнорироваться:");
        System.out.printf("'%10d' ", 777, "ffffff", 5);   // '      777' 

        System.out.println("\n\nf- float c точкой:");
        System.out.printf("%1$f %2$s", 88.13, "руб");

        System.out.println("\n\nf- float c точкой, c - char 1 символ:");
        System.out.printf("%1$f %2$s %3$c ", 88.13, "руб", 'a');

        System.out.println("\n\nцифра до d т.е. до обозначения типа данных, "
                + "указывает на миним кол-во символов в строке этого типа:");
        System.out.printf("'%10f %n '", 12.5);   // ' 12,500000' 
        System.out.printf("'%1$36f' %n ''%2$36s''", 13.3, "'с индексом и длиной строки 36 '");

        System.out.println("\n\nb - boolean:");
        System.out.printf("'%4f %b '", 13.8, true);

        System.out.println("\n\n 0 перед типом данных указывает на то что 0 ведущий:");
        System.out.printf("'%04d %b '", 13, true);

        System.out.println("\n\n , - вывод разделителя тысячных групп:");
        System.out.print("d без разделителя: ");
        System.out.printf("%d %s %n", 1000000, 50, "d без разделителя");
        System.out.print("d c разделителя: ");
        System.out.printf("%,d %s %n", 1000000, 50, "d с разделителя");

        System.out.printf("%f %s %n", 1000000.50, "f без разделителя");
        System.out.printf("%,f %s %n", 1000000.50, "f с разделителем ,");
    }
}
