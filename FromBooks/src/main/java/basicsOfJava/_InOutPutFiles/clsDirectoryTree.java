/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._InOutPutFiles;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collections;
import java.util.stream.Stream;

/**
 *
 * @author MartyMcAir
 */
public class clsDirectoryTree {
    public void walkDirectoryTree() throws IOException{
        Path p = Paths.get("C:\\z_n\\new_test_folder\\1\\");
        System.out.println("Stream<Path> stream = Files.walk(p, 2) _ \n "+
                "Просмотр содержимого каталого до 2 уровня вложенности");
        Stream<Path> stream = Files.walk(p, 2);
        stream.forEachOrdered((obj)->System.out.println(obj.toString()));
        
        System.out.println("\nПросмотр содержимого каталога"
                + " в обратном Reverse отсортированном порядке\n");
        Stream <Path> stream2 = Files.walk(p, 2);
        stream2.sorted(Collections.reverseOrder()).forEachOrdered(
                (obj-> System.out.println(obj.toString())));
    }
    
    public void delDirectoryTree() throws IOException {
        Path p = Paths.get("C:\\z_n\\new_test_folder\\1\\2\\del\\");
        if (Files.isDirectory(p) && Files.exists(p)) {
            Files.walkFileTree(p, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                        throws IOException {
                    Files.deleteIfExists(file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException e)
                        throws IOException {
                    Files.deleteIfExists(dir);
                    return FileVisitResult.CONTINUE;
                }

            });
            System.out.println("Каталог и всё его содержимое успешно удалено.");
        } else {
            System.out.println("Неверно указан путь или данный каталог не существует");
        }
    }

    public void showDirectoryTreeReverse() throws IOException {
        Path p = Paths.get("C:\\z_n\\new_test_folder\\1\\2");
        Files.walkFileTree(p, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                    throws IOException {
                System.out.println("file: " + file.toString());
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException e)
                    throws IOException {
                System.out.println("dir: " + dir.toString());
                return FileVisitResult.CONTINUE;
            }

        });
    }

    public void showDirectoryTree() throws IOException {
        Path p = Paths.get("C:\\z_n\\new_test_folder\\1\\2");
        // walkFileTree - собственно сам метод обхода директории
        Files.walkFileTree(p, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
                    throws IOException {
                System.out.println("dir: " + dir.toString());
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                    throws IOException {
                System.out.println("file: " + file.toString());
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
