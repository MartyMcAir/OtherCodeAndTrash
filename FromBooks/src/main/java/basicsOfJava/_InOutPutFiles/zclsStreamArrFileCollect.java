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
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author MartyMcAir
 */
public class zclsStreamArrFileCollect {

    public void createStreamFromDirectory() throws IOException {
        System.out.println("Чтение содержимого каталога через поток: ");
        Path p = Paths.get("C:\\z_n\\new_test_folder\\1\\2\\del\\");
        try (Stream<Path> stream = Files.list(p);) {
            stream.forEachOrdered((obj) -> System.out.println(obj.toString()));
        }

        System.out.println("\nВыборка из каталога только txt файлов"
                + " через stream.filter: ");
        try (Stream<Path> stream = Files.list(p);) {
            stream.filter((path) -> path.toString().endsWith(".txt"))
                    .forEachOrdered((obj) -> System.out.println(obj.toString()));
        }

        System.out.println("\nВыборка из каталога и под каталогов "
                + "только txt файлов через Files.find(..): ");
        // 4 глубина выборки каталагов
        try (Stream<Path> stream = Files.find(p, 4, (f, attrs) -> {
            return f.toString().endsWith(".txt");
        })) {
            stream.forEachOrdered((path) -> System.out.println(path.toString()));
        }
    }

    public void createStreamFromFile() throws IOException {
        System.out.println("Построчное чтение всего файла "
                + "через поток c использованием Files.lines()");
        Path p = Paths.get("C:\\z_n\\new_test_folder\\1\\2\\charBufWr2.txt");
        try (Stream<String> stream = Files.lines(p, Charset.forName("cp1251"));) {
            stream.forEachOrdered((s) -> System.out.println(s));
        }

        System.out.println("\nС использованием метода lines() "
                + "из класса BufferedReader ");
        try (InputStream in = new FileInputStream(p.toFile());
                Reader reader = new InputStreamReader(in, "cp1251");
                BufferedReader buf = new BufferedReader(reader);) {
            Stream<String> stream = buf.lines();
            stream.forEachOrdered((x) -> System.out.println(x));
        }
    }

    public void createAndRecursiveSplitString() {
        // разделяем строку используя регулярное выражение
        Pattern p = Pattern.compile("\\s+");
        // каждое отдельное слово цифра на отдельной строке
        String str = "1 2 3 word as words";
        Stream<String> stream = p.splitAsStream(str);
        stream.forEachOrdered((s) -> System.out.println(s));
    }

    public void createStreamFromString() {
        System.out.println("Поток из строки "
                + "_ IntStream stream = \"Line\".chars(): ");
        IntStream stream = "Line".chars();
        stream.forEachOrdered((x) -> System.out.print((char) x + "/ "));

        System.out.println("Поток из строки "
                + "_ StringBuilder sb =: ");
        StringBuilder sb = new StringBuilder();

    }

    public void createStreamFromArr() {
        int[] arrInt = {1, 2, 3, 4, 5, 6};
        IntStream intSt = Arrays.stream(arrInt).parallel();
        // работает одельно от кода ниже если раскоментить будет исключение
//        System.out.print("цифры больше 3х: ");
//        intSt.filter((x)->x>3).forEachOrdered((x)->System.out.print(x+"; "));

        System.out.println("Поток из массива Arrays.stream(arr).parallel(): ");
        int[] arr2 = intSt.unordered().map((x) -> x * 2).toArray();
        System.out.println("arrInt: " + Arrays.toString(arrInt));
        System.out.println("arr2: " + Arrays.toString(arr2));

        System.out.println("\nIntStream.of(arrInt).parallel(): ");
        IntStream intSt2 = IntStream.of(arrInt).parallel();
        intSt2.unordered()
                .filter((x) -> (x % 2) == 0)
                .forEachOrdered((x) -> System.out.print(x + "_"));

        System.out.println("\nСоздание потока на основе отдельных значений "
                + "_ IntStream.builder(): ");
        IntStream intSt3
                = IntStream.builder().add(3).add(6).add(8).add(13).build();
        intSt3.forEachOrdered((x) -> System.out.print(x + ": "));

        System.out.println("\nСоздание потока на основе отдельных значений "
                + "_ Stream.builder(): ");
        Stream.builder().add(13).add(66).add(88).build()
                .forEachOrdered((x) -> System.out.print(x + "; "));
    }

    public void threadPoolUnsordered() {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Collections.addAll(arr, 1, 2, 3, 4, 5);
        // при arr.stream() - данные будут упорядочены: 1,2,3,4,5
//        Stream<Integer> stream = arr.stream(); 
        Stream<Integer> stream = arr.parallelStream(); // паралельные потоки
        // ForkJoinPool pool = ForkJoinPool.commonPool();
        // System.out.print("pool.getParallelism(): " + pool.getParallelism()); // 3

        // разупорядочивание unordered() данных для избежания 
        // конфликтов при распаралеливании их обработки
        List<Integer> arr2 = stream.unordered().map(
                (x) -> {
                    System.out.println(Thread.currentThread().
                            getName() + " x= " + x);
                    return x * 2;
                }).collect(Collectors.toList());
    }

    public void collectStrFiler() {
        // заполняем коллекцию полученными данными и делаем из них выборку
        List<Integer> arr = new ArrayList();
        Scanner sc = new Scanner(System.in);
        int x = 0, result = 0;
        while (true) {
            System.out.print("Введите цифру или 0 для итогового результата: ");
            if (sc.hasNextInt()) {
                x = sc.nextInt();
                arr.add(x);
            } else if (sc.hasNextLine()) {
                System.out.println("Надо ввести цифру");
                sc.nextLine(); // пропуск строки
                continue;  // переход к следующей интерации
            }
            if (x == 0) {
                break;
            }
        }

        System.out.println("arr.toString(): " + arr.toString());
        System.out.print("Введенные вами цифры больше 3х: ");
        // parallel() - преобразование последовательного потока в паралельный
        Stream<Integer> stream = arr.stream().parallel();
        stream.filter((y) -> y > 3).forEachOrdered((y) -> System.out.print(y + " "));

        // getParallelism() почему-то, показывает 3 потока
        // независимо от parallel() или нет
        ForkJoinPool pool = ForkJoinPool.commonPool(); // текущий instatnce
        System.out.println("pool.getParallelism(): " + pool.getParallelism());
        // Создаем пул из 6ти потоков, вернет 6
        ForkJoinPool pool2 = new ForkJoinPool(6);
        System.out.println("pool2.getParallelism(): " + pool2.getParallelism());
    }
}
