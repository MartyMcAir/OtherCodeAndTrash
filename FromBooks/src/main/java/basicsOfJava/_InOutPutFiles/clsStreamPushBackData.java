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
import java.nio.file.StandardOpenOption;

/**
 *
 * @author MartyMcAir
 */
public class clsStreamPushBackData {

    public void dataOutIn() throws FileNotFoundException, IOException, Exception {
        Path p = Paths.get("C:\\z_n\\new_test_folder\\1\\2\\dataInOut.txt");
        // Записываем данные
        try (OutputStream out = new FileOutputStream(p.toFile());
                BufferedOutputStream bufOut = new BufferedOutputStream(out);
                DataOutputStream dataOut = new DataOutputStream(bufOut);
                AutoCloseable close = new clsImplCloseFull6(out, bufOut, dataOut);) {
            dataOut.writeUTF("Строка1\nString2");
            System.out.println("dataOut.size(): " + dataOut.size());
        }
        // Читаем данные
        try (InputStream in = new FileInputStream(p.toFile());
                BufferedInputStream bufIn = new BufferedInputStream(in);
                DataInputStream dataIn = new DataInputStream(bufIn);
                AutoCloseable close = new clsImplCloseFull6(in, bufIn, dataIn);) {
            System.out.println(dataIn.readUTF(dataIn));
        }
    }

    public void dataStreamIn() throws IOException, Exception {
        try (InputStream in = new FileInputStream(
                "C:\\z_n\\new_test_folder\\1\\2\\dataOut1.txt");
                BufferedInputStream bufIn = new BufferedInputStream(in);
                DataInputStream dataIn = new DataInputStream(bufIn);
                AutoCloseable close = new clsImplCloseFull6(in, bufIn, dataIn);) {
            System.out.println("dataIn.readBoolean(): " + dataIn.readBoolean()); // false 
            System.out.println("dataIn.readByte(): " + dataIn.readByte()); // 100
            System.out.println("dataIn.readShort(): " + dataIn.readShort()); // 45
            System.out.println("dataIn.readInt(): " + dataIn.readInt()); // 1254
            System.out.println("dataIn.readLong(): " + dataIn.readLong()); // 454
            System.out.println("dataIn.readFloat(): " + dataIn.readFloat()); // 42.2
            System.out.println("dataIn.readDouble(): " + dataIn.readDouble()); // 45.4
            System.out.println("dataIn.readChar(): " + dataIn.readChar()); // Ю
        }
    }

    public void dataStreamOut() throws FileNotFoundException, IOException, Exception {
        try (OutputStream out = new FileOutputStream(
                "C:\\z_n\\new_test_folder\\1\\2\\dataOut1.txt");
                BufferedOutputStream bufOut = new BufferedOutputStream(out);
                DataOutputStream dataOut = new DataOutputStream(bufOut);
                AutoCloseable close = new clsImplCloseFull6(out, bufOut, dataOut);) {
            dataOut.writeBoolean(false);
            dataOut.writeByte(100);
            dataOut.writeShort(45);
            dataOut.writeInt(1254);
            dataOut.writeLong(454L);
            dataOut.writeFloat(42.2f);
            dataOut.writeDouble(45.4);
            dataOut.writeChar('Ю');
            System.out.println("dataOut.size(): " + dataOut.size());
        }
    }

    public void pushBackBufInputSt() throws IOException, Exception {
        Path p = Paths.get("C:\\z_n\\new_test_folder\\1\\2\\pushBack.txt");
        byte[] bt = "push and back".getBytes();
        Files.write(p, bt, StandardOpenOption.TRUNCATE_EXISTING);
        byte[] btPush = new byte[5];
        byte[] btPush2 = new byte[9];
        byte[] btPush3 = new byte[13];

        try (InputStream in = new FileInputStream(p.toFile());
                BufferedInputStream bufIn = new BufferedInputStream(in);
                PushbackInputStream push = new PushbackInputStream(bufIn, 10);
                AutoCloseable close = new clsImplCloseFull6(in, bufIn);) {
            System.out.print("push.read(btPush) _5: ");
            push.read(btPush);
            for (int i = 0; i < btPush.length; i++) {
                System.out.print((char) btPush[i]);
            } // push
            System.out.print("\nповтор push.read(btPush) _5: ");
            for (int i = 0; i < btPush.length; i++) {
                System.out.print((char) btPush[i]);
            } // push

            System.out.print("\npush.read(btPush2) _9 "
                    + "(при этом байты в поток не вернули): ");
            push.read(btPush2);
            for (int i = 0; i < btPush2.length; i++) {
                System.out.print((char) btPush2[i]);
            } // and back 

            System.out.print("\npush.unread(btPush): ");
            push.unread(btPush);
            push.read(btPush);
            for (int i = 0; i < btPush.length; i++) {
                System.out.print((char) btPush[i]);
            } // push

            System.out.print("\npush.unread(btPush2): ");
            push.unread(btPush2);
            push.read(btPush2);
            for (int i = 0; i < btPush2.length; i++) {
                System.out.print((char) btPush2[i]);
            } // and back 
            System.out.print("\npush.read(btPush3) 13: ");
            push.read(btPush3);
            for (int i = 0; i < btPush2.length; i++) {
                System.out.print((char) btPush2[i]);
            } // and back 
        }
    }

    public void pushBackInStOriginal() throws FileNotFoundException, IOException, Exception {
        try (InputStream in = new FileInputStream(
                "C:\\z_n\\new_test_folder\\1\\2\\pushBack1.txt");
                BufferedInputStream bufIn = new BufferedInputStream(in);
                // указываем 2ым аргументом размер буфера (по умолчанию 1байт)
                PushbackInputStream push = new PushbackInputStream(bufIn, 10);
                AutoCloseable close = new clsImplCloseFull6(in, bufIn);) {
            byte[] bt = new byte[5];
            push.read(bt);
            for (int i = 0; i < bt.length; i++) {
                System.out.print((char) bt[i] + " ");
            } // s t r i n
            System.out.println();

            push.unread(bt); // Возвращаем байты в поток
            push.read(bt);
            for (int i = 0; i < bt.length; i++) {
                System.out.print((char) bt[i] + " ");
            }
        }
    }
}
