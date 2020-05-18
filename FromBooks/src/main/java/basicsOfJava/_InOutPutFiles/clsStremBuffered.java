/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._InOutPutFiles;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author MartyMcAir
 */
public class clsStremBuffered {

    public void readRepeatMarkAutoCl() {
        File f = new File("C:\\z_n\\new_test_folder\\1\\2\\", "repeatMark.txt");
        byte[] bt = "repeat count".getBytes();

        try (OutputStream out = new FileOutputStream(f);
                InputStream in = new FileInputStream(f);
                BufferedInputStream bufIn = new BufferedInputStream(in);
                BufferedOutputStream bufOut = new BufferedOutputStream(out);
                AutoCloseable close = new clsImplCloseFull6(out, bufOut, in, bufIn);) {
            bufOut.write(bt);
            bufOut.flush();

            int numMark = 6, numMark2 = 3;
            bufIn.mark(numMark);
            char[] strRepeat = new char[numMark];
            for (int i = 0; i < numMark; i++) {
                // при повторном вызове in.read() будет не тот результат что необходим
//                strRepeat[i]= Character.toString((char)in.read());
//                System.out.print( strRepeat[i]);   // repeat
                strRepeat[i] = (char) bufIn.read();
                System.out.print(strRepeat[i]);   // repeat
            }
            String str3 = new String(strRepeat);
            System.out.println("\nnew String(strRepeat): " + str3); // repeat
//            System.out.print("\nArrays.toString(strRepeat): "
//                    +Arrays.toString(strRepeat)); // [r, e, p, e, a, t]     

            bufIn.mark(numMark2);
            System.out.print("numMark2 Vv_ Next text: ");
            for (int i = 0; i < numMark2; i++) {
                System.out.print((char) bufIn.read());   // co
            }
            bufIn.reset(); // повторный вызов сброса ничего не изменит
            System.out.print("\nbufIn.reset() -сбрасывает до предыдущей метки "
                    + "_Next text: ");
            for (int i = 0; i < numMark2; i++) {
                System.out.print((char) bufIn.read());   // co
            }
            // bufIn.reset(); // если раскоментировать будет co а не unt
            System.out.print("\nNext text: ");
            for (int i = 0; i < numMark2; i++) {
                System.out.print((char) bufIn.read());   // unt
            }

            // Циклы что ниже, годятся только для дочитать до конца,
            // если необходимо частично, прочестсть следующие numberMark2 байт
            // то использовать только for(int i=0;i<numberMark2;i++){
//            for (byte str : in.readAllBytes()) { // 7й рабочий вариант
//                System.out.print((char) str + "");   // count а должно быть co
//            }
//            int c;   // 0) // original
//            while((c=in.read())!=-1){
//                System.out.print((char)c);   // count а должно быть co 
//            }
//            byte[] newBt = new byte[in.available()]; // 6) 
//            for (int i = 0; i < newBt.length; i++) {
//                System.out.print((char) in.read());   // count а должно быть co 
//            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void bufferedInMarkAutoClose() {
        //Path p = Paths.get("C:\\z_n\\new_test_folder\\1\\2\\buf_readWriteMark.txt");
        File f = new File("C:\\z_n\\new_test_folder\\1\\2\\", "buf_readWriteMark.txt");
        String str = "buffered \nread and write";
        byte[] bt = str.getBytes();

        try (OutputStream out = new FileOutputStream(f);
                InputStream in = new FileInputStream(f);
                BufferedInputStream bufIn = new BufferedInputStream(in);
                BufferedOutputStream bufOut = new BufferedOutputStream(out);
                AutoCloseable close = new clsImplCloseFull6(out, bufOut, in, bufIn);) {
            bufOut.write(bt); // записываем в файл
            bufOut.flush(); // сбрасывем буфер обмена, для сохранения данных в файле

            // объявляем переменную обозначающую кол-во байт для метки
            int numberForMark = 8;
            bufIn.mark(numberForMark);

            // варианты, которые не работают с меткой 
            // 1) System.out.println(bufIn.available()); // 24
            // 2) System.out.println(bufIn.readAllBytes().length); // 24
            // 3) System.out.println(((byte[])bufIn.readAllBytes()).length); // 24
            // 4) byte[] btLegth = bufIn.readAllBytes();
            // System.out.println(btLegth.length); // 24
            // 5) byte[] newBt = new byte[bufIn.available()];
            // System.out.println(newBt.length); //24
            // 1) b _ u _ f _ f _ e _ r _ e _ d _   _ \n _ r _ e _
//            for(int i=0; i<bufIn.available();i++){ // при любом значении в bufIn.mark(8)
            // bufIn.readAllBytes().length // 2) ? _ ничего не возвращает
            // ((byte[])bufIn.readAllBytes()).length // 3)? _ ничего не возвращает
            // 4) ? _ ? _ ? _ ? _ ? _ ? _ ? _ ? _ ? _ ? _ ? _ ? _ ? .. 
            // byte[] btLegth = bufIn.readAllBytes(); i< btLegth.length;
            // 5) читает полностью весь поток без метки
//             byte[] newBt = new byte[bufIn.available()];
//            bufIn.read(newBt);
//            for(int i=0; i< newBt.length; i++){
//                System.out.print((char) newBt[i]+" _ ");
            // 6 вариант)работает
//            byte[] newBt = new byte[bufIn.available()];
//            for (int j = 0; j < newBt.length; j++) {
//                System.out.print((char)bufIn.read());
//            }
            for (int i = 0; i < numberForMark; i++) {
                System.out.print((char) bufIn.read() + " _ ");
            }   // b _ u _ f _ f _ e _ r _ e _ d _ 

            System.out.println("next line: \n");
            // если сброситьт метку, поток будет начинаться с самого начала
            // bufIn.reset(); 
//            int c; // Оригинальный вариант  - работает
//            while ((c = bufIn.read()) != -1) {
//                System.out.print((char) c + " _ ");
//            } //  _ r _ e _ a _ d _   _ a _ n _ d _   _ w _ r _ i _ t _ e _
            // 7ой вариант работает
//            for (byte str2 : bufIn.readAllBytes()) {
//                System.out.print((char) str2 + "-");
//            } //  - \n-r-e-a-d- -a-n-d- -w-r-i-t-e-

//            System.out.println(bufIn.available()); // 16 вернет _ read a
//            System.out.println(bufIn.readAllBytes().length); // 16 вернет _ ? 
//            System.out.println(((byte[])bufIn.readAllBytes()).length); // 16 _?
//            byte[] btLegth = bufIn.readAllBytes();
//            System.out.println(btLegth.length); // 16 вернет _ ?
//            byte[] newBt = new byte[bufIn.available()];
//            System.out.println(newBt.length); //16 _ Работает
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void bufferedInMark() throws IOException {
        InputStream in = null;
        BufferedInputStream bufIn = null;
        try {
            Path p = Paths.get("C:\\z_n\\new_test_folder\\1\\2\\buf_inMark.txt");
            byte[] bt = "string1\nstring2".getBytes();
            Files.write(p, bt);

            in = new FileInputStream(p.toString());
            bufIn = new BufferedInputStream(in);

            bufIn.mark(10); // устанавливаем маркер на 10ый байт

            for (int i = 0; i < 7; i++) {
                System.out.print((char) bufIn.read() + " ");
            } // s t r i n g 1

            bufIn.reset(); // возвращаемся к позиции маркера
            for (int j = 0; j < 7; j++) {
                System.out.print((char) bufIn.read() + " ");
            } // s t r i n g 1

            // без возврата к позиции маркера
            for (int k = 0; k < 7; k++) {
                System.out.print((char) bufIn.read() + "_");
            } // _s_t_r_i_n_g_

            bufIn.reset(); // возвращаемся к позиции маркера
            for (int j = 0; j < 7; j++) {
                System.out.print((char) bufIn.read() + "; ");
            } // ; s; t; r; i; n; g; 1; 

        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
            }
            if (bufIn != null) {
                bufIn.close();
            }
        }
    }

    public void readInAutoCl() {
        File f = new File("C:\\z_n\\new_test_folder\\1\\2\\", "repeatMark.txt");
        byte[] bt = "repeat count".getBytes();

        try (OutputStream out = new FileOutputStream(f);
                InputStream in = new FileInputStream(f);
                AutoCloseable close = new clsImplCloseFull6(out, in);) {
            out.write(bt);

//            in.readAllBytes(); // после вызова в цикле нечитается
//            byte[] bt2 = in.readAllBytes(); // тоже самое
//            for (byte str : in.readAllBytes()) { // 7й рабочий вариант
//                System.out.print((char) str + "");
//            }

//            in.readAllBytes(); // после вызова в следующих циклах поток нечитается
//            byte[] bt2 = in.readAllBytes(); // тоже самое
//            int c;   // 0) // original
//            while((c=in.read())!=-1){
//                System.out.print((char)c);
//            }
            byte[] newBt = new byte[in.available()]; // 6) - работает
            for (int i = 0; i < newBt.length; i++) {
                System.out.print((char) in.read()); // repeat count
//                System.out.print(newBt[i]); // 5 _ не работает _ 000
            }

            // Не работающие варианты .. 1)
//            for(int j=0;j<in.available();j++){ // repeat
//                System.out.print((char)in.read()); }
//            2) for(int j=0;j<in.readAllBytes().length;j++){ // ?
//                System.out.print((char)in.read()); }
//            3) byte[] bt2 = in.readAllBytes();  // nothing
//            for(int j=0;j<((byte[])in.readAllBytes()).length;j++){
//                System.out.print((char)in.read()); }          
//            4) byte[] bt2 = in.readAllBytes();
//            for(int j=0;j<bt2.length;j++){  // ????????????
//                System.out.print((char)in.read()); }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void bufferedInAutoClose() {
        try (InputStream in = new FileInputStream(
                "C:\\z_n\\new_test_folder\\1\\2\\buf_inout.txt");
                BufferedInputStream bufIn = new BufferedInputStream(in);
                AutoCloseable close = new clsImplCloseFull6(in, bufIn);) {
            int c;
            while ((c = bufIn.read()) != -1) {
                System.out.print((char) c + " ");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void bufferedOutAutoClose() {
        try (OutputStream out = new FileOutputStream(
                "C:\\z_n\\new_test_folder\\1\\2\\buf_inout.txt");
                // 5 - это размер буфера в 5 байт, 
                // при достижении, которого данные будут записан в выходной поток
                // а после чтение следующих байт до 5ти и снова запись
                BufferedOutputStream bfOut = new BufferedOutputStream(out, 5);
                AutoCloseable close = new clsImplCloseFull6(out, bfOut);) {
            byte[] bt = "buffered string out".getBytes();
            bfOut.write(bt);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void bufferedOut() throws IOException {
        BufferedOutputStream bfOut = null;
        OutputStream out = null;
        try {
            out = new FileOutputStream("C:\\z_n\\new_test_folder\\1\\2\\buf_out.txt");
            bfOut = new BufferedOutputStream(out);
            byte[] bt = "buffered string out".getBytes();
            bfOut.write(bt);
            bfOut.flush(); // сбрасываем содержимое буфера _ если не сбросить,
            // то данные в файл не запишутся, и будет выброс исключения
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
            if (bfOut != null) {
                bfOut.close();
            }
        }
    }

    public void tryWithResLoop() {
        Path p = Paths.get("C:\\z_n\\new_test_folder\\1\\2\\out_in.txt");
        String str = " test line in ";
        byte[] bt = str.getBytes();
        // AutoCloseable - после завершения программы 
        // автоматич будет вызван его close метод 
        try ( // для записи
                OutputStream out = new FileOutputStream(p.toString());
                // для чтения
                InputStream in = new FileInputStream(p.toString());
                AutoCloseable autoClose = new clsImplCloseFull6(out, in);) {
            out.write(bt); // записываем в файл
            //in.read(bt);

//            int c;
//            while((c=in.read()) !=-1){
//                System.out.println((char)c+"");
//                }
            String spaceStr = " ";
            byte[] spaceBt = spaceStr.getBytes();
//            for (byte str2 : in.readAllBytes()) {
//                // если байт читается как пробел то
//                if (Byte.compare(spaceBt[0], str2) == 0) {
//                    System.out.print(", ");
//                } else {
//                    System.out.print((char) str2);
//                }
//            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("\n финальная команда. \n");
        }
    }

    public void tryWithResources() {
        Path p = Paths.get("C:\\z_n\\new_test_folder\\1\\2\\out_in.txt");
        String str = " test line in ";
        byte[] bt = str.getBytes();

        try (AutoCloseable autoClose = new clsImplCloseFull6();
                // для записи
                OutputStream out = new FileOutputStream(p.toString());
                // для чтения
                InputStream in = new FileInputStream(p.toString());) {
            out.write(bt); // записываем в файл
            // преобразуем в строку прочтенный файл
//            String stRead = new String(in.readAllBytes(), Charset.forName("cp1251"));
//            System.out.println("stRead: " + stRead);   // выводим в консоль прочтенный текст
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("\n финальная команда. \n");
        }
    }
}
