/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._InOutPutFiles;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.Iterator;
import java.util.stream.Stream;

/**
 *
 * @author MartyMcAir
 */
public class clsPath {

    public void delFilesInParentDirectory() {
        Path p = Paths.get("C:\\z_n\\new_test_folder\\1\\2\\del\\");     

        // если путь ведет к каталогу и он существует
        if (Files.isDirectory(p) && Files.exists(p)) {
            try {
                DirectoryStream<Path> stream = Files.newDirectoryStream(p);
                // удаляем фалы в каталоге
                for (Path obj : stream) {
                    if (Files.isRegularFile(obj)) {
                        System.out.println(Files.deleteIfExists(obj));
                    }
                }
                System.out.println("Все файлы в корне каталога удалены.");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Указанный вами путь не ведет к существующему каталогу.");
        }
    }

    public static void directoryCRUDExists() throws IOException {
        Path p = Paths.get("C:\\z_n\\new_test_folder\\1\\2\\888\\999");
        // Files.delete(p); // Удаляем каталог при этом он должен быть пустой   
        if (Files.exists(p)) { // если католог есть то удаляем
            // Files.notExists(p); // вернет true если каталог не существует
            System.out.println("каталог удален? Files.deleteIfExists(p): "
                    + Files.deleteIfExists(p));
        } else {
            System.out.println(p.getFileName()
                    + " _ Каталога нет и ли был удален ранее..");
        }

    }

    public static void loopsDirectory() {
        Path p = Paths.get("C:\\z_n\\new_test_folder\\1\\2");
        System.out.println("получаем из каталога список только *.txt : ");
        try {
            DirectoryStream<Path> stream
                    = Files.newDirectoryStream(p, "*.txt");
            for (Path obj : stream) {
                System.out.print(obj.toString());
                System.out.print("  _  Directory?: " + Files.isDirectory(obj) + " ");
                System.out.print("File?: " + Files.isRegularFile(obj) + " \n");
            }
        } catch (Exception e) {
            System.out.println("e.getMessage(): " + e.getMessage());
        }

        System.out.println("\nполучаем из каталога список только *.tmp "
                + "с помощью лямбда-выражения: ");
        try {
            DirectoryStream<Path> stream = Files.newDirectoryStream(p,
                    (path) -> path.toString().toLowerCase().endsWith(".tmp"));
            for (Path obj : stream) {
                System.out.print(obj.toString());
                System.out.print("  _  Directory?: " + Files.isDirectory(obj) + " ");
                System.out.print("File?: " + Files.isRegularFile(obj) + " \n");
            }
        } catch (Exception e) {
            System.out.println("e.getMessage(): " + e.getMessage());
        }

        System.out.println("\nПеребираем в каталоге файлы только *.myExtends"
                + "с помощью Stream и Files.list(p) и лямбда-выражения: ");
        try {
            Stream<Path> stream2 = Files.list(p);
            // stream2.forEachOrdered((obj)-> System.out.println(obj.toString()));
            stream2.filter((path) -> path.toString().endsWith(".myExtends")
            ).forEachOrdered((obj) -> System.out.println(obj.toString()));
        } catch (Exception e) {
            System.out.println("e.getMessage(): " + e.getMessage());
        }

    }

    public static void streamFullDirectory() {
        Path p = Paths.get("C:\\z_n\\new_test_folder\\1\\2");
        System.out.println("получаем поток для чтения содержимого каталога: ");
        try {
            DirectoryStream<Path> stream = Files.newDirectoryStream(p);
            for (Path obj : stream) {
                System.out.print(obj.toString());
                System.out.print("  _  Directory?: " + Files.isDirectory(obj) + " ");
                System.out.print("File?: " + Files.isRegularFile(obj) + " \n");
            }
        } catch (Exception e) {
            System.out.println("e.getMessage(): " + e.getMessage());
        }
    }

    public static void showDirectory() throws IOException {
        Path p = Paths.get("C:\\z_n\\new_test_folder\\1\\2");
        System.out.println("это путь к папке? Files.isDirectory(p): "
                + Files.isDirectory(p));

        // при повторном запуске генерирует исключение Err
//        Path p2 = Paths.get("C:\\z_n\\new_test_folder\\1\\2\\333");
//        System.out.println("Files.createDirectory(p2): "
//                +Files.createDirectory(p2));
        Path p3 = Paths.get("C:\\z_n\\new_test_folder\\1\\2\\888\\999");
        System.out.println("Files.createDirectories(p3): "
                + Files.createDirectories(p3));

        System.out.println("создаем временную папку Files.createTempDirectory(: "
                + Files.createTempDirectory(p, "tmp_folder"));

    }

    public void showHardDisk() throws IOException {
        Path p = Paths.get("C:\\z_n\\new_test_folder\\1\\2\\file_size.txt");

        System.out.println("получаем разделитель текущ системы fs.getSeparator()"
                + " _ и буквы всех жестких дисков");
        FileSystem fs = p.getFileSystem();
        System.out.println("fs.getSeparator(): " + fs.getSeparator());

        Iterator<Path> it2 = fs.getRootDirectories().iterator();
        while (it2.hasNext()) {
            System.out.print("hard is: " + it2.next() + ", ");
        }

        System.out.println("\nПолучаем информацию о доступных дисках (имя диска)"
                + "for(FileStore obj : fs.getFileStores()){..");
        for (FileStore obj : fs.getFileStores()) {
            System.out.print(obj.toString() + " _ ");
        }
        System.out.println("\n");

        FileStore fs2 = Files.getFileStore(p);
        System.out.println("fs2.toString(): " + fs2.toString()
                + "\n fs2.getTotalSpace(): ");
        System.out.printf("%,d\n", fs2.getTotalSpace());

        System.out.print("\nСвободного места на диске "
                + "fs2.getUnallocatedSpace(): ");
        System.out.printf("%,d\n", fs2.getUnallocatedSpace());

        System.out.print("\nСвободного места для виртуальной машины "
                + "fs2.getUsableSpace(): ");
        System.out.printf("%,d\n", fs2.getUsableSpace());

        System.out.println("тип диска C? fs2.name(): " + fs2.name());
        fs2 = Files.getFileStore(Paths.get("D:"));
        System.out.println("тип диска D? fs2.name(): " + fs2.name()); // имя диска

        System.out.println("тип файловой системы fs2.type(): " + fs2.type());

        System.out.println("диск только для чтения? _ fs2.isReadOnly(): "
                + fs2.isReadOnly());

    }

    public void pathChange() {
        Path p = Paths.get("C:\\z_n\\new_test_folder\\1\\2");
        System.out.println("p.toString(): " + p.toString());
        Path p2 = Paths.get("file_size.txt");
        System.out.println("добавляем путь к существующему _ p.resolve(p2)\n: "
                + p.resolve(p2));
        System.out.println("p.resolve(\"fileResolve.txt): "
                + p.resolve("fileResolve.txt"));

        Path p3 = Paths.get("C:\\z_n\\new_test_folder\\1\\2\\file_size.txt");
        System.out.println("\np3.toString(): " + p3.toString());
        System.out.println("получаем элементы индекса от и до _ p3.subpath(0, 3): "
                + p3.subpath(0, 3));

        System.out.println("замена последнего элемента пути на указанный "
                + "_ p3.resolveSibling(\"textSib.txt\"): \n"
                + p3.resolveSibling("textSib.txt"));
        System.out.println("p3.startsWith(\"C:\\z_n\")?: " + p3.startsWith("C:\\z_n"));
        System.out.println("p3.endsWith(\"2\\file_size.txt\")?: "
                + p3.endsWith("2\\file_size.txt"));

        URI uri_var = p3.toUri();
        System.out.println("p3.toUri() _ uri_var: " + uri_var);

        Path p4 = Paths.get("C:\\z_n\\new_test_folder\\1\\2\\file_size.txt");
        System.out.println("сравнивает пути _ p3.equals(p4)?: " + p3.equals(p4));
        System.out.println("сравнивает пути и возвращает 0 если равны "
                + "и 1 ели больше -1 если меньше _ p3.compareTo(p4)?:   "
                + p3.compareTo(p4));
    }

    public void showLoopPaths() {
        Path p = Paths.get("C:\\z_n\\new_test_folder\\1\\2\\file_size.txt");
        System.out.println("p.toString(): " + p.toString());
        System.out.println("кол-во элементов в пути _ p.getNameCount(): "
                + p.getNameCount());
        System.out.println("\nПеребор элементов путь по индексу _ p.getName(i)");
        for (int i = 0, j = p.getNameCount(); i < j; i++) {
            System.out.print(p.getName(i) + ", ");
        }

        System.out.println("\n\nПеребор с помощью Iterator");
        Iterator<Path> it = p.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + "; ");
        }
        System.out.println("\n\nПеребор с помощью спец формы for(* var : arr)");
        for (Path elem : p) {
            System.out.print(elem + " - ");
        }

        System.out.println("\n\nперебор с помощью forEach метода и лямбды");
        p.forEach((elem) -> System.out.print(elem + " : "));
    }

    public void showPath() throws IOException {
        Path p = Paths.get("C:\\z_n\\new_test_folder\\1\\2\\file_size.txt");
        System.out.println("Путь: " + p.toString());

        File f = new File("C:\\z_n\\new_test_folder\\1\\2\\file_size.txt");
        Path p2 = f.toPath();
        System.out.println("путь на основе File класса: " + p2.toString());
        // Обратная операция Path toFile
        File f2 = p2.toFile();

        Path p3 = Paths.get("C:\\z_n\\new_test_folder\\1\\2\\file_size.txt");
        Path p4 = Paths.get("../file_size.txt");
        System.out.println("абсолютный путь? p2.isAbsolute()&?:" + p2.isAbsolute());
        System.out.println("абсолютный путь? p4.isAbsolute()&?:" + p4.isAbsolute());
        // Возвращает обсалютный путь
        System.out.println("p3.toAbsolutePath():" + p4.toAbsolutePath());

        // Преобразует все спец символы в абсолютном пути и нормализует пути
        Path p5 = Paths.get("C://..//file_size.txt");
        System.out.println("p5.toString(): " + p5.toString());
        System.out.println("p5.normalize(): " + p5.normalize());

        Path p6 = Paths.get("C:/book\\../file_size.txt");
        System.out.println("p6.toString(): " + p6.toString());
        System.out.println("p6.normalize(): " + p6.normalize());

        // Возвращает нормализованный путь, при это провряет существование файла
        System.out.println("p3.toRealPath(): " + p3.toRealPath());
        System.out.println("название диска _ p3.getRoot(): " + p3.getRoot());
        System.out.println("родительский католог _ p3.getParent(): " + p3.getParent());
        System.out.println(" _ p3.getFileName(): " + p3.getFileName());
    }
}
