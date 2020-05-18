/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._InOutPutFiles;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

/**
 *
 * @author MartyMcAir
 */
public class clsSEAdditionally {

    public void runConsole() {
        Console con = System.console();
        if (con != null) {
            con.printf("%", "Текст в консоли");
            Scanner in = new Scanner(con.reader());
            String str = in.nextLine();
            con.writer().print(str);
        } else {
            // если приложение не связано с консолью то будет null
            System.out.println("con = null");
        }
    }

    public void sumVarMy() {
        int x = 0, result = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите целое число или 0 для получения резулта:");

        while (true) {
            System.out.print("ваше число: ");
            if (sc.hasNextInt()) { // если из потока получено int
                x = sc.nextInt();
            } else if (sc.hasNextLine()) { // а иначе если получено другое
                System.out.println("Целое число а не это!: " + sc.nextLine());
                continue; // переход к след интерации
            }
            if (x == 0) {
                break; // прерывание цикла
            }
            result += x;
        }
        System.out.println("результ: " + result);
    }

    public void sumVariableInt() {
        int x = 0, result = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ввведите челое число "
                + "или 0 для получения суммы всех ваших чисел");
        while (true) {
            System.out.print("Введите число: ");
            if (sc.hasNextInt()) { // если введено int
                x = sc.nextInt();
                if (x == 0) {
                    break; // прерываем цикл для получения результата
                }
                result += x;
                // clean buffer
                if (sc.hasNextLine()) {
                    sc.nextLine();
                }
            } else {
                if (sc.hasNextLine()) {
                    sc.nextLine(); // пропускаем ввод
                    System.out.println("Необходимо ввести целое число/");
                } // любая другая не предвиденная ситуация вызывает прерывание цикла
                else {
                    break;
                }
            }
        }
        System.out.println("Сумма веденых вами цифр: " + result);
    }

    public void scFindAndGetTegsBody2() throws FileNotFoundException {
//        Scanner sc = new Scanner("text<b>Text 0</b>j<b>Text1</b> text\n<b>Text2\n5<\b>");
        File f = new File("C:\\z_n\\new_test_folder\\1\\2\\tegFromOracle3.txt");
        Scanner sc = new Scanner(f, "cp1251");
        Pattern p = Pattern.compile("<b>(.*?)</b>", Pattern.CASE_INSENSITIVE
                + Pattern.UNICODE_CASE + Pattern.DOTALL);
        MatchResult m = null; // Интерфейс реализуемый Match классом
        // findWithinHorizon() выполняет поиск во фрагменте огранич кол-во сиволом
        // второй аргумент 0 означает что поиск производится без ограничний
        while (sc.findWithinHorizon(p, 0) != null) {
            m = sc.match(); // Возвращает объект Match с результатом предыдущего поиска
            for (int i = 0; i < m.groupCount(); i++) { // groupCount() кол-во групп в шаблоне
                // group() возвращает фрагмент совпадающ с шаблоном 
                // или фрагмент внтури круглых скобок
                System.out.print(m.group(i + 1) + " ");
            } // Text 0 Text1 
        }
        sc.close();
    }

    public void scFindAndGetTegsBody() throws FileNotFoundException {
        // Основы Java 580 стр. Пример не верен Не работает
//        Scanner sc = new Scanner("text<b>Text 0</b>j<b>Text1</b> text\n<b>Text2\n5<\b>");
        File f = new File("C:\\z_n\\new_test_folder\\1\\2\\tegFromOracle3.txt");
        Scanner sc = new Scanner(f, "cp1251");
        Pattern pt = Pattern.compile("<b>(.*?)</b>", Pattern.CASE_INSENSITIVE
                + Pattern.UNICODE_CASE);
        Scanner scN = null;
        MatchResult mrN = null;
        while (sc.hasNext()) {
            scN = new Scanner(sc.nextLine());
        }
        while (sc.findInLine(pt) != null) {
            mrN = sc.match();
            for (int i = 0; i < mrN.groupCount(); i++) {
                System.out.print(mrN.group(i + 1) + " ");
            }
        }
        scN.close();
    }

    public void showWithSeparator() throws FileNotFoundException {
        File f = new File("C:\\z_n\\new_test_folder\\1\\2\\printWr.txt");
        Scanner sc = new Scanner(f, "cp1251");
        //sc.useDelimiter(Pattern.compile("\\s+")); // если раскоментить то без изменений
        while (sc.hasNext()) {
            System.out.println(sc.next() + "_/"); // в конце кадой строки _/
        }
    }

    public void showOnlyWithNum() throws FileNotFoundException {
        // читаем из файла
        File f = new File("C:\\z_n\\new_test_folder\\1\\2\\printWr.txt");
        Scanner sc = new Scanner(f, "cp1251");
        // читаем из строки
//        Scanner sc = new Scanner("string1 string string3");
        Pattern pt = Pattern.compile(".*[0-9]+");
        // выводим только цифры или строки с цифрами
        while (sc.hasNext()) {
            if (sc.hasNext(pt)) {
//                System.out.println(sc.next(pt));
                System.out.println(sc.next()); // тоже работает
            } else {
                sc.next();
            }
        }
//        sc.close(); // без close работает
    }

    public void scanShowNextFromFile() throws FileNotFoundException {
        File f = new File("C:\\z_n\\new_test_folder\\1\\2\\printWr.txt");
        Scanner sc = new Scanner(f, "cp1251");
        // построчное чтение из файла
        System.out.println(sc.nextLine()); // print write string 
        System.out.println(sc.nextLine()); // 10true13.33 string 
        System.out.println(sc.nextLine()); // string2 

        // выводит все следующие строки потока
        while (sc.hasNext()) { // sc.hasNext() проверяет доступность следующих данных 
            System.out.println(sc.next());  // next() для любых данных
        }
    }

    public void scannerFileIs() throws FileNotFoundException, IOException {
        File f = new File("C:\\z_n\\new_test_folder\\1\\2\\printWr.txt");
        // если файла нет, то создаем его _ а иначе ошибка
        if (!f.exists()) {
            f.createNewFile();
        }
        Scanner scf = new Scanner(f, "cp1251");

        Path p = Paths.get(f.toString());
        Scanner scp = new Scanner(p, "cp1251");

        InputStream in = new FileInputStream(f);
        Scanner scIn = new Scanner(in, "cp1251");

    }

    public void printWriterIs() throws FileNotFoundException, UnsupportedEncodingException {
        try (PrintWriter pw = new PrintWriter(
                "C:\\z_n\\new_test_folder\\1\\2\\printWr.txt", "cp1251");) {
            // все данные запишутся в файл в виде строки
            // символ \n перенос строки в файле не работает
            // но при выводе через Scanner, будет новая строка
            pw.write(" print write string \n");
            pw.print(10);
            pw.print(true);
            pw.print(13.33);
            pw.println(" string ");
            pw.println(" string2 "); // перенос на новую строку 
            //pw.close(); // если раскоментить то все что ниже записано не будет
            // pw.flush(); // ни как не влияет
            pw.printf("%.2f", 33.32749).println(); // 33,33
            pw.printf(new Locale("en", "US"), "%.2f", 66.237981); // 66.24
            pw.println(" "); // перенос на новую строку 
            pw.printf("%d %s", 13, " string3 "); // 13 string
            pw.println(" "); // перенос на новую строку 
            pw.format("%d %s", 88, " string4 "); // 13 string
            // Поверка на наличие ошибок
            System.out.println("pw.checkError()?: " + pw.checkError()); // false
        }
    }

    public void printStreamIs() throws FileNotFoundException, UnsupportedEncodingException {
        // запись в файл
        try (PrintStream pr = new PrintStream(
                "C:\\z_n\\new_test_folder\\1\\2\\printStr.txt", "cp1251");) {
            pr.write(333);
            pr.print(" String1 ");
            pr.println();
            pr.print(" String2 ");
        }
    }
}
