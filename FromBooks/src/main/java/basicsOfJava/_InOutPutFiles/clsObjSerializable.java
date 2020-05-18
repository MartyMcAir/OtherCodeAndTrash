/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._InOutPutFiles;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author MartyMcAir
 */
public class clsObjSerializable {

    public void rndAccessOrigin() throws IOException {
        try (RandomAccessFile rnd = new RandomAccessFile(
                "C:\\z_n\\new_test_folder\\1\\2\\rnd.txt", "rw");) {

            rnd.setLength(0); // очищаем файл
            byte[] bt = "byte for RandomAccessFile".getBytes();
            rnd.write(bt);
            rnd.seek(0); // возвращаемся в начало файла
            int c;
            // читаем по одному байту
            while ((c = rnd.read()) != -1) {
                System.out.print((char) c + " ");
            }

            System.out.println("\nЧитаем по 5 байт");
            rnd.seek(0); // возвращаемся в начало файла
            byte[] bt5 = new byte[5];
            int z;
            while ((z = rnd.read(bt5, 0, 5)) != -1) {
                // System.out.print(z+" _"); // 5 5 5 5 5 
                for (int i = 0; i < z; i++) {
                    System.out.print((char) bt5[i] + ",");
                } // b,y,t,e, ,f,o,r, ,R,a,n,d,o,m,A,c,c,e,s,s,F,i,l,e,
            }

            System.out.println("\nЧитаем из потока кол-во "
                    + "байт равное или меньшее массиву btt");
            rnd.seek(0); // возвращаемся в начало файла
            // byte[] btt = new byte[(int)rnd.length()];
            byte[] btt = new byte[8];
            rnd.read(btt);
            for (int i = 0; i < btt.length; i++) {
                System.out.print((char) btt[i] + " ");
            }   // b y t e   f o r

            rnd.close();
        }
    }

    public void outInGetSetSerializable() throws IOException, Exception {
        Path p = Paths.get("C:\\z_n\\new_test_folder\\1\\2\\objOutIn");
        try (OutputStream out = new FileOutputStream(p.toFile());
                BufferedOutputStream bufOut = new BufferedOutputStream(out);
                ObjectOutputStream objOut = new ObjectOutputStream(bufOut);
                AutoCloseable close = new clsImplObjOut3(out, bufOut, objOut);) {

            cls2ImplSerializable impl1 = new cls2ImplSerializable(333);
            cls2ImplSerializable impl2 = new cls2ImplSerializable();
            impl2.setNumber(666);
            objOut.writeObject(impl1);
            objOut.writeObject(impl2);
        }
        try (InputStream in = new FileInputStream(p.toFile());
                BufferedInputStream bufIn = new BufferedInputStream(in);
                ObjectInputStream objIn = new ObjectInputStream(bufIn);
                AutoCloseable close = new clsImplObjIn3(in, bufIn, objIn);) {

            cls2ImplSerializable impl3
                    = (cls2ImplSerializable) objIn.readObject();
            cls2ImplSerializable impl4
                    = (cls2ImplSerializable) objIn.readObject();
            System.out.println("impl3.getNumber(): " + impl3.getNumber());
            System.out.println("impl4.getNumber(): " + impl4.getNumber());

            System.out.println("\nПроверяем защищенность static"
                    + " и transient данных");

            System.out.println("impl3.getTransient(): " + impl3.getTransient());
            // Выдает статическую переменную только через метод
            System.out.println("доступна только через getМетод impl3.getStrStatic(): " + impl3.getStrStatic());

            System.out.print("\nСтатический метод в IDE показывается,"
                    + " что не доступенно, \nно если написать так руками то работает,"
                    + "хотя и не должен impl3.showFromSticMethod(): ");
            impl3.showFromSticMethod();
        }
    }

    public void showObjOutInOriginal() throws FileNotFoundException, IOException, ClassNotFoundException {
        Path p = Paths.get("C:\\z_n\\new_test_folder\\1\\2\\OutInObjOrigin");
        try (OutputStream out = new FileOutputStream(p.toFile());
                ObjectOutputStream objOut = new ObjectOutputStream(out);) {
            cls1ImplSerializable impl1 = new cls1ImplSerializable(333);
            cls1ImplSerializable impl2 = new cls1ImplSerializable(666);
            cls1ImplSerializable impl3 = new cls1ImplSerializable();
            impl3.setX(888);

            objOut.writeObject(impl1);
            objOut.writeObject(impl2);
            objOut.writeObject(impl3);
        }

        try (InputStream in = new FileInputStream(p.toFile());
                ObjectInputStream objIn = new ObjectInputStream(in);) {
            cls1ImplSerializable impl4
                    = (cls1ImplSerializable) objIn.readObject();
            cls1ImplSerializable impl5
                    = (cls1ImplSerializable) objIn.readObject();
            cls1ImplSerializable impl6
                    = (cls1ImplSerializable) objIn.readObject();
            System.out.println(impl4.getX());
            System.out.println(impl5.getX());
            System.out.println(impl6.getX());

            System.out.println(impl6.get13());
        }
    }
}
