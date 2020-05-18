/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._InOutPutFiles;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author MartyMcAir
 */
public class clsByteInOutStream {

    public void readIn() throws IOException {
//        byte[] bt = " I want to be strong and smart.".getBytes("cp1251");
//        Files.write(Paths.get("C:\\z_n\\new_test_folder\\1\\2\\file_in.txt"), bt,
//                StandardOpenOption.TRUNCATE_EXISTING);
        System.out.println("Побайтовое чтение через цикл while \n"
                + " метод read() читает по одному байту если дойдет до конца вернет -1");
        InputStream in = null;
        try {
            in = new FileInputStream("C:\\z_n\\new_test_folder\\1\\2\\file_in.txt");
            int c;
            while ((c = in.read()) != -1) {
                System.out.print((char) c + " ");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            if (in != null) {
                in.close();
            }
        }

        System.out.println("читаем файл по 5 байт \n");
        byte[] bt = new byte[5];
        InputStream in2 = null;
        //File f = new File("C:\\z_n\\new_test_folder\\1\\2\\file_in2.txt");
        try {
            //in2 = new FileInputStream(f); // тоже подходящий вариант
            in2 = new FileInputStream("C:\\z_n\\new_test_folder\\1\\2\\file_in2.txt");
            int n;
            while ((n = in2.read(bt, 0, 5)) != -1) {
                for (int i = 0; i < n; i++) {
                    System.out.print((char) bt[i] + ", ");
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            //if(in2!=null) in2.close();
        }

        System.out.println("\n читаем из потока кол-во "
                + "байтов равное или меньшее bt2");
        InputStream in3 = null;
        try {
            in3 = new FileInputStream("C:\\z_n\\new_test_folder\\1\\2\\file_out2.txt");
            byte[] bt2 = new byte[in3.available()];
            in3.read(bt2);
            for (int i = 0; i < bt2.length; i++) {
                System.out.print((char) bt2[i] + "_ ");
            }
            String str3 = new String(bt2, Charset.forName("cp1251"));
            System.out.println("Всего прочитано байт: " + bt2.length + " и это текст:"
                    + "\n" + str3);
        } finally {
            if (in3 != null) {
                in3.close();
            }
        }

        InputStream in4 = new FileInputStream(FileDescriptor.in);
        System.out.print("Введите stop (или 3) для остановки или"
                + " ваш текст для записи в файл. Или вывода: ");
        int c;
        while ((c = in4.read()) != -1) {
            // работает на определении кода цифры так 3 это 51
            if (Integer.toString(c).equals("51")) {
                break;
            }
            System.out.print((char) c + " _ ");
            //System.out.println( c+" _ "); // 3 это 51
        }
        // после завршения дозаписывает в конец файла последнее т.е. только 3
        OutputStream stream = new FileOutputStream(
                "C:\\z_n\\new_test_folder\\1\\2\\fileDecriptorIn.txt", true);
        //int str = in4.read();
        stream.write(c);
        in = null;
    }

    public void writeFileOutPutStream() throws IOException {
        OutputStream out = null;
        try {
            // параметр true - позволяет дозаписать данные в конец файла
            out = new FileOutputStream(
                    "C:\\z_n\\new_test_folder\\1\\2\\file_out.txt", true);
            byte[] bt = "test line _ \n".getBytes("cp1251");
            out.write(bt);
            System.out.println("Дозапись в файл успешно выполнена.\n");
            out.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        OutputStream out2 = null;
        File f = new File("C:\\z_n\\new_test_folder\\1\\2\\file_out2.txt");
        try {
            // параметр true - позволяет дозаписать данные в конец файла
            out2 = new FileOutputStream(f);
            byte[] bt2 = "a cup of tea _ \n".getBytes("cp1251");
            out2.write(bt2);
            System.out.println("Запись в файл " + f.getName() + ", успешно выполнена.");
            out2.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void writeOut() throws IOException {
        Path p = Paths.get("C:\\z_n\\new_test_folder\\1\\2\\write_byte_file.txt");

        System.out.println("Первый способ записи из предыдущих..: ");
        OutputStream stream = null;
        String str = "333 666 999 \n 888";
        byte[] bt = str.getBytes();
        try {
            // Append Дозапись а не перезапись файла
//            stream = Files.newOutputStream(p, StandardOpenOption.APPEND);
            stream = Files.newOutputStream(p);
            stream.write(bt);
        } finally {
            if (stream != null) {
                stream.close();
            }
            System.out.println("в Файл: " + p + "  записано: " + str);
        }

        System.out.println("\nВторой способ записи из текущего варианта..: ");
        Path p2 = Paths.get("C:\\z_n\\new_test_folder\\1\\2\\write_byte_file2.txt");
        OutputStream out2 = null;
        byte[] bt2 = "0123456".getBytes("cp1251");
        String str2 = new String(bt2, "cp1251");
        try {
            try {
//            out2 = new FileOutputStream("C:\\z_n\\new_test_folder\\1\\2\\write_byte_file2.txt");
                out2 = new FileOutputStream(p2.toString());
                // байтовая запись по индексам
                out2.write(bt2[0]); // 00
                out2.write(bt2, 0, 3); // 0 0120
                out2.write(bt2); // 00120123456
            } finally {
                if (out2 != null) {
                    out2.close();
                }
                System.out.println("в Файл: " + p2 + "  записано: "
                        + str2);
            }
        } catch (UnsupportedEncodingException e) {
            System.err.println("Проблемы с кодировкой");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Неудалось записать файл");
            System.exit(1);
        }

        System.out.println("\nУкороченная версия второго варианта.");
        OutputStream out = null;
        try {
            out = new FileOutputStream(
                    "C:\\z_n\\new_test_folder\\1\\2\\write_file3.txt");
            byte[] bt3 = "STRING".getBytes("cp1251");
            out.write(bt3);
            System.out.println("Файл №3 записан");
            out.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        System.out.println("\nDариант4 c побайтовой записью через цикл.");
        OutputStream out3 = null;
        try {
            out3 = new FileOutputStream(
                    "C:\\z_n\\new_test_folder\\1\\2\\write_file4.txt");
            byte[] bt4 = "STRING WRONG GLOW".getBytes("cp1251");
            for (int i = 0; i < bt4.length; i++) {
                out3.write(bt4[i]);
            }
            System.out.println("Файл №4 записан кол-во элементов  byte[] bt3: "
                    + bt4.length);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
