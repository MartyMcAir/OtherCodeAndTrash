/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._InOutPutFiles;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 *
 * @author MartyMcAir
 */
public class clsFiles {

    public void streamRead() throws IOException {
        Path p = Paths.get("C:\\z_n\\new_test_folder\\1\\2\\write_stream.txt");
        Path p2 = Paths.get("C:\\z_n\\new_test_folder\\1\\2\\write_inPutstream.txt");

        System.out.println("InputStream in = Files.newInputStream ..: ");
        InputStream in = null;
        try {
            in = Files.newInputStream(p);
            byte[] bt = new byte[in.available()];
            in.read(bt); // читаем данные
            String str = new String(bt, "cp1251");
            System.out.println(str);
        } finally {
            if (in != null) {
                in.close(); // закрывем поток
            }
        }

        System.out.println("\nstream = Files.lines ..: ");
        Stream<String> stream = null;
        try {
            stream = Files.lines(p2, Charset.forName("cp1251"));
            stream.forEachOrdered((str) -> System.out.println(str));
        } finally {
            if (stream != null) {
                stream.close();
            }
        }

        System.out.println("\nКопируем все байты из файла в поток ");
        System.out.println("out = new ByteArrayOutputStream() ..: ");
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            Files.copy(p2, out);
            String str = new String(out.toByteArray(), "cp1251");
            System.out.println(str);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    public void byteRead() throws IOException {
        Path p = Paths.get("C:\\z_n\\new_test_folder\\1\\2\\write_stream.txt");
        Path p2 = Paths.get("C:\\z_n\\new_test_folder\\1\\2\\write_inPutstream.txt");
        if (Files.exists(p)) {
            byte[] btArr = Files.readAllBytes(p);
            String str = new String(btArr, "cp1251");
            //System.out.println(Arrays.toString(btArr));
            System.out.println("Files.readAllBytes(p): " + str);
        }

        System.out.println("\nList<String> lst = Files.readAllLines ..:");
        if (Files.exists(p2)) {
            List<String> lst = Files.readAllLines(p2, Charset.forName("cp1251"));
            for (String item : lst) {
                System.out.print(item + ", ");
            }
        }
    }

    public void streamWrite() throws IOException {
        Path p = Paths.get("C:\\z_n\\new_test_folder\\1\\2\\write_stream.txt");
        OutputStream out = null;
        try {
            out = Files.newOutputStream(p);
            String str = "tree \n window \n floor \n bathroom";
            byte[] bt = str.getBytes();
            out.write(bt);
        } finally {
            if (out != null) {
                out.close();
            }
            System.out.println("Данные успешно записанны из потока в файл:"
                    + "файл создается автоматически _"
                    + " а существующий перезаписывается \n" + p);
        }

        Path p2
                = Paths.get("C:\\z_n\\new_test_folder\\1\\2\\write_inPutstream.txt");
        String str2 = "winter \n cold water";
        byte[] bt2 = str2.getBytes("cp1251");
        InputStream in = null;
        if (Files.notExists(p2)) {
            try {
                in = new ByteArrayInputStream(bt2);
                System.out.println(Files.copy(in, p2));
            } finally {
                if (in != null) {
                    in.close();
                }
            }
        } else {
            System.out.println("файл уже создан и записан: " + p2);
        }

    }

    public void byteWrite() throws UnsupportedEncodingException, IOException {
        Path p = Paths.get("C:\\z_n\\new_test_folder\\1\\2\\write_file.txt");
        String str = " _ line one \n line two \n line tree";
        byte[] bt = str.getBytes("cp1251"); // винд кодировка cp1251
        System.out.println("Запись в файл _ файл создается автоматически "
                + "_ а существующий перезаписывается\n " + Files.write(p, bt));

        System.out.println("ДО-Запись в уже существующий файл"
                + Files.write(p, bt, StandardOpenOption.APPEND));

        Path p2 = Paths.get("C:\\z_n\\new_test_folder\\1\\2\\write_file2.txt");
        List<String> lst = new ArrayList<String>();
        lst.add("zero");
        lst.add("demon");
        lst.add("thousand");
        System.out.println("Запись в файл из коллекции: "
                + "(файл создается автоматически а существующий перезаписывается)\n"
                + Files.write(p2, lst, Charset.forName("cp1251")));

    }

    public void fileFolderCopyMove() throws IOException {
        Path p = Paths.get("C:\\z_n\\new_test_folder\\1\\2\\move.txt");
        Path p2 = Paths.get("C:\\z_n\\new_test_folder\\1\\2\\move3.txt");
        // REPLACE_EXISTING - если файл сущ его заменяют
        // ATOMIC_MOVE - пермещение выполняется как единая операция
        if (Files.notExists(p2)) {
            System.out.println("Копия создана: "
                    + Files.copy(p, p2, StandardCopyOption.REPLACE_EXISTING));
        } else {
            System.out.println("копия уже создана в: " + p2);
        }
        // цикл создающий i кол-во копий файла
//        for(int i=0;i<5;i++){
//            Path p3 = Paths.get("C:\\z_n\\new_test_folder\\1\\2\\move3"+i+".txt");
//            Files.copy(p, p3, StandardCopyOption.COPY_ATTRIBUTES);
//            //Files.deleteIfExists(p3);
//        }
        Path p3 = Paths.get("C:\\z_n\\new_test_folder\\1\\2\\333\\moves.txt");
        Path p4 = Paths.get("C:\\z_n\\new_test_folder\\1\\2\\moves.txt");
        if (Files.exists(p4)) {
            System.out.println("Перемещение успешно: " + Files.move(p4, p3));
        } else {
            System.out.println("В указанном пути файл отсутствует.: " + p4);
        }
    }

    public void showAttributes() throws IOException {
        Path p = Paths.get("C:\\z_n\\new_test_folder\\1\\2\\file_size.txt");

        FileTime ft = (FileTime) Files.getAttribute(p, "lastModifiedTime");
        System.out.println("последний раз изменяли файл: " + ft.toString());

        ft = (FileTime) Files.getAttribute(p, "creationTime");
        System.out.println("создали файл: " + ft.toString());

        long size = (long) Files.getAttribute(p, "size");
        System.out.println("размер файла: " + size);

        Map<String, Object> attrMap = Files.readAttributes(p, "*");
        System.out.println("\nсписок всех доступных атрибутов:\n "
                + attrMap.keySet());

        BasicFileAttributes baseAttr
                = Files.readAttributes(p, BasicFileAttributes.class);
        System.out.println("baseAttr.lastAccessTime(): " + baseAttr.lastAccessTime());

        DosFileAttributes dosAttr = Files.readAttributes(p, DosFileAttributes.class);
        System.out.println("dosAttr.isHidden()?: " + dosAttr.isHidden());

        BasicFileAttributeView baseAttr2
                = Files.getFileAttributeView(p, BasicFileAttributeView.class);
        FileTime ft2 = FileTime.fromMillis(new Date().getTime() * 3);
        // last modified, lastAccess, createTime
        baseAttr2.setTimes(ft2, ft2, null);
        System.out.println("измененный атрибут последних изменений файла\n: "
                + ft.toString());
    }
}
