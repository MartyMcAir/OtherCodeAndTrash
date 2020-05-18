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
import java.nio.file.StandardOpenOption;

/**
 *
 * @author MartyMcAir
 */
public class zclsCharacterStream {

    public void charBack() throws UnsupportedEncodingException, IOException {
        try (InputStream in = new FileInputStream(
                "C:\\z_n\\new_test_folder\\1\\2\\charBufWr2.txt");
                Reader rd = new InputStreamReader(in, "cp1251");
                BufferedReader bufR = new BufferedReader(rd);
                PushbackReader push = new PushbackReader(bufR, 10);) {
            char[] charArr = new char[5];
            push.read(charArr);
            for (int i = 0; i < charArr.length; i++) {
                System.out.print(charArr[i] + " ");
            } // T e s t 1 

            int c;
            while ((c = push.read()) != -1) {
                System.out.print((char) c);
            } // \n Test2 __ если закоменить, то внизу результат тот же

            push.unread(charArr); // взврат символов в поток
            push.read(charArr);
            for (int i = 0; i < charArr.length; i++) {
                System.out.print(charArr[i] + " ");
            }  // T e s t 1 
        }
    }

    public void charBufReader() throws IOException {
        File fp = new File("C:\\z_n\\new_test_folder\\1\\2\\charBufWr2.txt");
        try (BufferedReader bufRd = Files.newBufferedReader(fp.toPath(),
                Charset.forName("cp1251"));) {
            // Посимвольное чтение
//            int c;
//            while((c=bufRd.read())!=-1){
//                System.out.print((char)c);
//            }

            System.out.println("\nПо строковое чтение");
            String str = "";
            int i = 1;
            while ((str = bufRd.readLine()) != null) {
                System.out.print("строка# " + i + ": " + str + "\n");
                i++;
            }
        }
    }

    public void charBufWriter() throws FileNotFoundException, IOException {
        File fp = new File("C:\\z_n\\new_test_folder\\1\\2\\charBufWr2.txt");
        // Если файл не существует то создастся
        if (!fp.exists()) {
            fp.createNewFile();
        }
        // дозапись в файл
        try (BufferedWriter bufWr = Files.newBufferedWriter(fp.toPath(),
                Charset.forName("cp1251"),
                StandardOpenOption.APPEND);) {
            bufWr.write("Test1");
            bufWr.newLine(); // \n из ходя из в какой системе запущено
            // Следующая черта записывается все верно!
            // А в OutputStream знак новой строки в файле \n несрабатывал
            bufWr.write("Test2");
            bufWr.flush();
        }
    }

    public void charMark() throws IOException, Exception {
        Path p = Paths.get("C:\\z_n\\new_test_folder\\1\\2\\charBufWr2.txt");
        try (BufferedReader bufR = Files.newBufferedReader(p,
                Charset.forName("cp1251"));) {
            // true 
            System.out.println("bufR.markSupported()?: " + bufR.markSupported());

            bufR.mark(10);
            System.out.println(bufR.readLine());
            bufR.reset();
            System.out.println(bufR.readLine());
        }
    }

    public void charMarkOrigin() throws IOException, Exception {
        Path p = Paths.get("C:\\z_n\\new_test_folder\\1\\2\\charBufWr2.txt");
        try (InputStream in = new FileInputStream(p.toFile());
                Reader rd = new InputStreamReader(in, "cp1251");
                BufferedReader buf = new BufferedReader(rd);) {
            // true
            System.out.println("buf.markSupported()?: " + buf.markSupported());

            buf.mark(10);   // Устанавливаем маркер 
            System.out.println(buf.readLine());
            buf.reset();   // Возвращаемся к позиции маркера 
            System.out.println(buf.readLine());
        }
    }

    public void readInCharAvg() throws IOException {
        try (InputStream in = new FileInputStream(
                "C:\\z_n\\new_test_folder\\1\\2\\character1.txt");
                Reader rd = new InputStreamReader(in, "cp1251");) {
            char[] char10 = new char[10];
            int n;
            StringBuilder sb = new StringBuilder();
            // Читаем равное char10 или меньшее кол-во символов
            // читаемое автоматички записывается в char10 от туда же и выводит
            while ((n = rd.read(char10)) != -1) {
                sb.append(char10, 0, n);
            }
            System.out.print("sb.toString(): " + sb.toString());
        }
    }

    public void readInChar5() throws IOException {
        try (InputStream in = new FileInputStream(
                "C:\\z_n\\new_test_folder\\1\\2\\character1.txt");
                Reader rd = new InputStreamReader(in, "cp1251");) {
            char[] char5 = new char[5];
            int n;
            while ((n = rd.read(char5, 0, 5)) != -1) {
                for (int i = 0; i < n; i++) {
                    System.out.print((char) char5[i]);
                }
            }
        }
    }

    public void charOutInWriteRead() throws UnsupportedEncodingException, IOException, Exception {
        Path p = Paths.get("C:\\z_n\\new_test_folder\\1\\2\\character1.txt");
        try (OutputStream out = new FileOutputStream(p.toString());
                Writer wr = new OutputStreamWriter(out, "cp1251");
                InputStream in = new FileInputStream(p.toString());
                Reader rd = new InputStreamReader(in, "cp1251");
                AutoCloseable close = new clsImplCloseChar(wr, rd);) {
            char[] charArr = "a little; a bit".toCharArray();
            wr.write(charArr);
            wr.close(); // если закоменить, то rd.read() непрочитает

            int c;
            while ((c = rd.read()) != -1) {
                System.out.print((char) c);
            }

            // Повторное чтение не работает
//            System.out.println("\nzzz");
//            char[] charArr6 = new char[6];
//            int n;
//            while ((n = rd.read(charArr6, 0, 5)) != -1) {
//                for (int i = 0; i < n; i++) {
//                    System.out.print((char) charArr6[i]);
//                }
//            }
        }
    }

    public void charInRead() throws FileNotFoundException, IOException {
        try (InputStream in = new FileInputStream(
                "C:\\z_n\\new_test_folder\\1\\2\\character.txt");
                Reader rdIn = new InputStreamReader(in, "cp1251");) {
            int c;
            while ((c = rdIn.read()) != -1) {
                System.out.print((char) c + "");
            }
        }
    }

    public void charOutWrite() throws FileNotFoundException, IOException {
        try (OutputStream out = new FileOutputStream(
                "C:\\z_n\\new_test_folder\\1\\2\\character.txt");
                Writer wrOut = new OutputStreamWriter(out, "cp1251"); // Writer wrOut = new OutputStreamWriter(out, Charset.forName("cp1251"));
                ) {
            // всё это будет записано
            char[] arrCh = " word1 ddd".toCharArray();
            wrOut.write(arrCh, 0, 5); // запись по индексу с 0 до 5
            wrOut.write(" word2 fff", 0, 6);
            wrOut.append(" words is here", 0, 13);
            wrOut.append(' ');

            // Не синхронизирован т.е. не для многопоточных приложений
            StringBuilder sb = new StringBuilder();

            sb.append(" word3 zzz", 0, 6);
            sb.append(" word4");
            wrOut.append(sb);
        } catch (UnsupportedEncodingException e) {
            System.err.println("Проблемы с кодировкой");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Не удалаось записать в фал");
            System.exit(1);
        }
        System.out.println("Данные успешно записаны");
    }
}
