/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._InOutPutFiles;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.*;

/**
 *
 * @author MartyMcAir
 */
public class Main {

    public static void main(String[] args) throws IOException, Exception {
        clsFile file_var = new clsFile();
//        file_var.accessFiles();
//        file_var.delExistsDirectory();
//        file_var.filePath();
//        file_var.filesCRUD();
//        file_var.isDelExistsHiddenChange();
//        file_var.listDirectoryFiles();
//        file_var.showDirectory();
//        file_var.showHardDisk();

        clsPath path_var = new clsPath();
        // path_var.showPath();
        // path_var.showLoopPaths();
        // path_var.pathChange();
        // path_var.showHardDisk();
        // path_var.showDirectory();
        // path_var.streamFullDirectory();
        // path_var.loopsDirectory();
        // path_var.directoryCRUDExists();

        clsDirectoryTree path_tree = new clsDirectoryTree();
        // path_tree.showDirectoryTree();
        // path_tree.showDirectoryTreeReverse();
        // path_tree.delDirectoryTree();
        // path_tree.walkDirectoryTree();

        clsFiles files_var = new clsFiles();
        // files_var.showAttributes();
        // files_var.fileFolderCopyMove();
        // files_var.byteWrite();
        // files_var.streamWrite();
        // files_var.byteRead();
        // files_var.streamRead();

        clsCurrentOs os_var = new clsCurrentOs();
        // os_var.showOsAttr();

        clsByteInOutStream btWrite = new clsByteInOutStream();
        // btWrite.writeOut();
        // btWrite.writeFileOutPutStream();
        // btWrite.readIn();

        clsStremBuffered stBuff = new clsStremBuffered();
        // stBuff.tryWithResources();
        // stBuff.tryWithResLoop();
        // Запись
        // stBuff.bufferedOut();
        // stBuff.bufferedOutAutoClose();

        // Чтение
        // stBuff.readInAutoCl
        // stBuff.bufferedInAutoClose();
        // mark() - установка метки работает только с буфферезированным потоком
        // и методами read() и reset()
        // stBuff.bufferedInMark();   // original
        // stBuff.bufferedInMarkAutoClose(); // с примерами раб и нераб вариантов
        // чтения из потока до метки и получение
        // этой метки в виде отдельной строки, не нарушая сам поток
        // stBuff.readRepeatMarkAutoCl();
        clsStreamPushBackData st_pBackData = new clsStreamPushBackData();
        // st_pBackData.pushBackBufInputSt();
        // st_pBackData.pushBackInStOriginal();
        // st_pBackData.dataStreamOut(); // записываем данные _ при этом открыв файл там кракозябры
        // st_pBackData.dataStreamIn(); // читаем предыдущий файл всё читается
        // st_pBackData.dataOutIn();

        // сериализация и десериализация объектов в и из файлов
        clsObjSerializable obj_serial = new clsObjSerializable();
        // obj_serial.showObjOutInOriginal();
        // obj_serial.outInGetSetSerializable(); // пример с проверкой transient
        // obj_serial.rndAccessOrigin(); // рандомный доступ (rw ReadWrite) к файлам

        zclsCharacterStream var_char = new zclsCharacterStream();
        // var_char.charOutWrite();
        // var_char.charInRead();
        // var_char.charOutInWriteRead();
        // var_char.readInChar5();
        // var_char.readInCharAvg();

        // var_char.charMarkOrigin();
        // var_char.charMark();
        // var_char.charBufWriter();
        // var_char.charBufReader();
        // var_char.charBack();
        clsSEAdditionally cls_add = new clsSEAdditionally();
        // cls_add.printStreamIs(); // запись в файл так себе
        // cls_add.printWriterIs(); // запись в файл
        // cls_add.scannerFileIs();  // Экземпляры класса Scanner
        // cls_add.scanShowNextFromFile(); // построчное чтение из файла
        // cls_add.showOnlyWithNum(); // выводим только цифры или с фифрами через Pattern
        // cls_add.showWithSeparator(); // Разделитель в конце каждой строки
        // cls_add.scFindAndGetTegsBody(); // Основы Java 580 стр. не работает
        // cls_add.scFindAndGetTegsBody(); // Основы Java 580 стр. не работает
        // cls_add.scFindAndGetTegsBody2(); // Рабочий пример поиска текста в HTML тегах
        // cls_add.sumVariableInt();
        // cls_add.sumVarMy();
        // cls_add.runConsole(); // Примеры из книги Основы Java 583-586стр не работают

        zclsStreamArrFileCollect stream_arr = new zclsStreamArrFileCollect();
        // stream_arr.collectStrFiler(); // заполняем коллекцию полученными данными и делаем из них выборку
        // разупорядочивание unordered() данных для избежания
        // конфликтов при распаралеливании их обработки
        // stream_arr.threadPoolUnsordered();
        // stream_arr.createStreamFromArr(); // создание потока из массива
        // stream_arr.createStreamFromString(); // создание потока из строки
        // stream_arr.createAndRecursiveSplitString(); // разделяем строку используя регулярное выражение
        // stream_arr.createStreamFromFile();
        // stream_arr.createStreamFromDirectory();

        // streamFromIterateAndGenerate();
        // streamRandomInt();
        // intermediateMethods(); // Промежуточные Stream операции
        // intStreamTooLongAndOth(); // Операции преобразования Stream потоков
        // unifyingForStream(); // объединение Stream потоков и др преобразования
        // terminalOperationsForStream(); // основные промежуточные операции
        // terminalOperationsForStream2(); // промежуточные min max sum
        // terminalOptionalTForStream3(); // промежуточная orElse() 
        streamToArrayCollect(); // преобразование потоков
    }

    public static void streamToArrayCollect(){
        Integer[] arrIntObj = {13,18,23};
        
        int[] arr = IntStream.rangeClosed(0, 10).map((x)->x*2).toArray();
        System.out.println("IntStream toArray(): "+Arrays.toString(arr));
        
        Integer[] obj = Stream.of(1,2,3).toArray(Integer[]::new);
        System.out.println("Integer[] obj _ toArray(Integer[]::new): "
                +Arrays.toString(obj));
        
        // .distinct() оставит только уникальные элементы
        List<Integer> obj2 = Stream.of(3,3,6,6,9,9).distinct()
                .collect(Collectors.toList());
        System.out.println("Stream to List<> _ .collect(Collectors.toList()): "
                +obj2.toString());
        
        System.out.println("\nStream to oth object _ Integer[] arrIntObj: "
                +Arrays.toString(arrIntObj));
        String s = Stream.of(arrIntObj).collect(StringBuilder::new, 
                StringBuilder::append, StringBuilder::append).toString();
        System.out.println("arrIntObj _ .collect(StringBuilder::new,.. "+s);
        
        Set<Integer> obj3 = Stream.of(arrIntObj).collect(Collectors.toSet());
        System.out.println("в множество _ .collect(Collectors.toSet()): "+obj3.toString());
        
        String strObj = Stream.of("1","2","3").collect(Collectors.joining());
        System.out.print("\nОбъединяет через заданные разделители"
                + "\n.collect(Collectors.joining()): "+strObj.toString());

        String strObj2 = Stream.of("1","2","3")
                .collect(Collectors.joining("-","-> "," <-")); 
        // Разделитель а затем preffix и suffix
        System.out.println("\n.collect(Collectors.joining(\"-\",\"-> \",\" <-\")): "
                +strObj2.toString());
    }
    
    public static void terminalOptionalTForStream3() {
        System.out.println("IntStream.of().max().orElse(6): "
                +IntStream.of().max().orElse(6));
        // Находит max число если его нет, то вернет значение из .orElse(8) 
        System.out.println("IntStream.of(1,2,3).max().orElse(8): "
                +IntStream.of(1,2,3).max().orElse(8));
        
        Optional<Integer> obj = Stream.of(1,2,3).findFirst();
        System.out.println("\n1) если значения нет, то вызывается метод указанный в "
                + "orElseGet(()->0) _ и возвращает результат: "
                +obj.orElseGet(()->0));
        
        Optional<Integer> obj2 = Stream.of(1,2,3).findFirst();
        System.out.println("\n2) если значения нет, то вызывается метод "
                + " и генерируется исключение  "
                + "\norElseThrow(NoSuchElementException::new): "
                +obj2.orElseThrow(NoSuchElementException::new));
        
        System.out.println("\n3) если значение есть то вызывается метод"
                + " указанный в ifPresent((x)->System.out.print(x)): ");
        IntStream.of(1,2,3,13).max()
                .ifPresent((x)->System.out.print(x));
        
        System.out.print("\n4) Вернет true если значение есть:  ");
        Optional<Integer> obj3 = Stream.of(1,2,3,8).findFirst();
        if(obj3.isPresent()){
            System.out.println("obj3.isPresent() вернул: "+obj3.isPresent());
            System.out.println("obj3.get(): "+obj3.get());
        }
    }
    
    public static void terminalOperationsForStream2() {
        long[] arr3 = {3, 6, 8, 9};
        Integer[] arr4 = {3, 6, 8, 9};

        int[] arr = {3, 6, 8, 9};
        int[] arr2 = {6, 8, 9, 13};

        System.out.println("LongStream.of _ min: "
                + LongStream.of(arr3).min().getAsLong());
        Optional<Integer> obj = Stream.of(arr4).min((a, b) -> a.compareTo(b));
        System.out.println("Optional<Integer> _ min: " + obj.get());

        System.out.println("IntStream.of _ max: " + IntStream.of(arr).max().getAsInt());
        Optional<Integer> obj2 = Stream.of(arr4).max((a, b) -> a.compareTo(b));
        System.out.println("Optional<Integer> _ max: " + obj2.get());

        System.out.println(".average(): " + IntStream.of(arr2).average()
                .getAsDouble()); // без метода getAsDouble() будет: .average(): OptionalDouble[9.0]
        System.out.println(".sum(): " + IntStream.of(arr2).sum());

        System.out.println("Сумма всех чисел через "
                + "_ .reduce(0, (sum,b)->sum+b)..: "
                + IntStream.of(arr2).reduce(0, (sum, b) -> sum + b));

        Optional<Integer> obj3 = Stream.of(arr4).reduce((sum, b) -> sum + b);
        System.out.println("возвращает объект Optional<Integer> _ sum: " + obj3.get());

        System.out.println("применяет указанный метод к элементам и накапливает результат: ");
        Integer obj4 = Stream.of(arr4).parallel().reduce(0,
                (a, b) -> {
                    System.out.println("accumulator: a=" + a + " b=" + b);
                    return a + b;
                },
                (a, b) -> {
                    System.out.println("combiner: a=" + a + " b=" + b);
                    return a + b;
                });
        System.out.println(" obj4: "+obj4);
        
        Optional<Integer> obj5 = Stream.of(arr4).reduce((sum, b)->sum+b);
        System.out.println(".reduce((sum, b)->sum+b _ obj5: "+obj5.get());
    }

    public static void terminalOperationsForStream() {
        int[] arr = {1, 2, 3, 6, 8, 9};
        int[] arr2 = {3, 7, 9};
        IntStream intSt1 = IntStream.of(arr);
        IntStream intSt2 = IntStream.of(arr);
        IntStream intSt3 = IntStream.of(arr);
        IntStream intSt4 = IntStream.of(arr2);
        IntStream intSt5 = IntStream.of(arr2);
        IntStream intSt6 = IntStream.of(arr2);
        IntStream intSt7 = IntStream.of(arr2);

        System.out.println("случайный порядок forEach() IntSt1: ");
        intSt1.parallel().forEach((x) -> System.out.print(x + " "));
        // если повторно использовать intSt.count() вместо intSt2.count()
        // то будет вызванно исключение (stream has already been operated upon or closed)
        System.out.println("\nintSt2.count(): " + intSt2.count());

        System.out.println("Условие выполнено хотя бы для одного элемента? "
                + ".anyMatch(..) _ есть четные?\n: "
                + intSt3.anyMatch((x) -> (x % 2) == 0));
        System.out.println("Условие выполнено хотя бы для одного элемента? "
                + ".anyMatch(..)\n: " + intSt4.anyMatch((x) -> (x % 2) == 0));
        System.out.println("Условие невыполнено ни для одного элемента? "
                + ".noneMatch(..)\n: " + intSt5.noneMatch((x) -> (x % 2) == 0));
        System.out.println("Условие выполнено для всех элементов? "
                + ".allMatch(..)\n: " + intSt6.allMatch((x) -> (x % 2) != 0));

        System.out.println("возвращает первый элемент потока в виде объекта "
                + "OptionalInt Long.. классов .findFirst(..): ");
        OptionalInt obg = intSt7.findFirst();
        Optional<Integer> obg2 = Stream.of(1, 2, 6, 3).findFirst();
        System.out.println("OptionalInt intSt7 _ obg.getAsInt(): "
                + obg.getAsInt());
        System.out.println("Optional<Integer> _ obg2.get(): " + obg2.get());

        System.out.println("возвращает произвольный элемент потока в виде объекта "
                + "OptionalInt Long.. классов .findAny(..): ");
        // без parallel() возвращает только 1ый элемент и все
        Optional<Integer> obg3 = Stream.of(1, 2, 6, 3).parallel().findAny();
        System.out.println("Optional<Integer> _ obg3.get(): " + obg3.get());

    }

    public static void unifyingForStream() {
        System.out.println("Объединение потоков .concat(*,*)");
        IntStream intS1 = IntStream.of(1, 2, 3);
        IntStream intS2 = IntStream.of(4, 5, 6);
        IntStream.concat(intS1, intS2)
                .forEachOrdered(x -> System.out.print(x + "; "));

        System.out.println("\nПолучение из потока строк через регулярное выражение"
                + " Pattern.compile() : ");
        Pattern p = Pattern.compile("\\s+");
        List<String> arr = new ArrayList();
        arr.add("word1 word2 word3");
        arr.add("word4 word5 word6");
        Stream<String> stream = arr.stream();
        stream.flatMap((str) -> p.splitAsStream(str))
                .forEachOrdered((x) -> System.out.print(x + " _ "));

        System.out.println("\nпреобразование объектного потока "
                + "в поток элементарных данных _ : ");
        List<String> arr2 = new ArrayList<String>();
        Collections.addAll(arr2, "3", "8", "6");
        Stream<String> stream2 = arr2.stream();
        stream2.flatMapToInt(s -> IntStream.of(Integer.parseInt(s)))
                .forEachOrdered(x -> System.out.print(x + " "));
    }

    public static void intStreamTooLongAndOth() {
        Integer[] arr2 = {18, 3, 9, 8, 13, 6};
        List<Integer> arr = new ArrayList();
        Collections.addAll(arr, arr2);
        Stream<Integer> stream = arr.stream();
        System.out.println("");
        stream.forEachOrdered((x) -> System.out.print(x + "; "));

        System.out.println("преобразуем IntStrean в .asDoubleStream()");
        IntStream.of(1, 2, 3, 4, 5, 6).asDoubleStream()
                .forEachOrdered((n) -> System.out.print(n + " "));

        System.out.println("\nпреобразуем поток элементарных данных"
                + " в поток объектных данных: ");
        int[] arr3 = {18, 3, 9, 8, 13, 6};
        List<Integer> arr4 = IntStream.of(arr3)
                .boxed().collect(Collectors.toList());

        System.out.println("\nпреобразуем поток элементарных данных"
                + " в объектный поток _ .mapToObj(..): ");
        List<Integer> arrObj = IntStream.of(arr3)
                .mapToObj(x -> new Integer(x))
                .collect(Collectors.toList());
        System.out.print(arrObj);

        System.out.println("\nпреобразуем поток в IntStream _ .mapToInt(..) : ");
        IntStream intSt = DoubleStream.of(1.2, 5.0, 4.3)
                .mapToInt((x) -> (int) x);
        intSt.forEachOrdered((x) -> System.out.print(x + " "));

        System.out.println("\nпреобразуем поток Stream.of в LongStream _ "
                + ".mapToLong(..) : ");
        Stream.of(1.2, 5.0, 4.3).mapToLong(x -> x.longValue())
                .forEachOrdered((n) -> System.out.print(n + ", "));

        System.out.println("\nпреобразуем поток Stream.of в DoubleStream _ "
                + ".mapToDouble() : ");
        Stream.of(1, 5, 4).mapToDouble((x) -> x.doubleValue())
                .forEachOrdered((x) -> System.out.print(x + " "));
    }

    public static void intermediateMethods() {
        // получение нечетных цифр
        System.out.println("\n.filter((x)->(x%2)!=0): ");
        IntStream.rangeClosed(0, 10).filter((x) -> (x % 2) != 0)
                .forEachOrdered((n) -> System.out.print(n + " "));

        System.out.println("\n.map((x)->x*2): ");
        IntStream.rangeClosed(0, 10).map((x) -> x * 2)
                .forEachOrdered((n) -> System.out.print(n + " "));

        System.out.println("\n.limit(3): ");
        IntStream.rangeClosed(0, 10).limit(3)
                .forEachOrdered((n) -> System.out.print(n + " "));

        System.out.println("\n.skip(5) "
                + "_ пропускаем указанное кол-во первых элементов: ");
        IntStream.rangeClosed(0, 10).skip(5)
                .forEachOrdered((n) -> System.out.print(n + " "));

        System.out.println("\n.of(1,1,2,2,3,3,4,4).distinct() "
                + "_ только уникальные элементы: ");
        IntStream.of(1, 1, 2, 2, 3, 3, 4, 4).distinct()
                .forEachOrdered((n) -> System.out.print(n + " "));

        // peek() — применяет метод action к каждому элементу,
        // при этом не изменяя элементы. Этот метод удобно использовать для отладки.
        System.out.println("\nОтладочная Информация из потока без изменений: ");
        List<Integer> arr = Stream.of(1, 1, 1, 2, 3, 3, 4)
                .peek((n) -> System.out.print(n + " "))
                .distinct()
                .collect(Collectors.toList());
        System.out.println("\nна выходе из потока arr.toString(): " + arr.toString());

        System.out.println("\n.sorted(): ");
        IntStream.of(1, 1, 2, 3, 9, 7, 6, 4, 2, 5).sorted()
                .forEachOrdered((n) -> System.out.print(n + " "));
        System.out.println("\n .parallel().sorted(Collections.reverseOrder()): ");
        Stream.of(1, 8, 5, 2, 7, 8, 2, 3).parallel()
                .sorted(Collections.reverseOrder())
                .forEachOrdered((x) -> System.out.print(x + " "));

        System.out.println("\n .parallelStream().unordered(): ");
        List<Integer> arrLst = new ArrayList();
        Collections.addAll(arrLst, 9, 1, 3, 2, 5, 7, 6);
        arrLst.parallelStream()
                .unordered()
                .map((x) -> x * 2)
                .sorted()
                .forEachOrdered((n) -> System.out.print(n + " _ "));
    }

    public static void streamRandomInt() {
        Random r = new Random();
        // бессконечный поток случайных чисел
        //IntStream stream = r.ints();
        System.out.println("Генерация 10 чисел от 0 до 100: ");
        IntStream stream = r.ints(10L, 0, 100);
        stream.forEachOrdered((x) -> System.out.print(x + " "));

        System.out.println("\n\nГенерация случайных зх long чисел: ");
        LongStream stream2 = r.longs(3L);
        stream2.forEachOrdered((x) -> System.out.println(x + " "));

        System.out.println("\nГенерация случайных зх double чисел "
                + "_ r.doubles(3L, 0.3, 13.3): ");
        DoubleStream stream3 = r.doubles(3L, 0.3, 13.3);
        stream3.forEachOrdered((x) -> System.out.println(x + ", "));
    }

    public static void streamFromIterateAndGenerate() {
        System.out.println("Генерация 3х четных чисел через поток"
                + " IntStream.iterate(..): ");
        // приращение на (n)->n+2 _ ограничение в 3 цифры limit(3)
        IntStream stream = IntStream.iterate(2, (n) -> n + 2).limit(3);
        stream.forEachOrdered((x) -> System.out.print(x + "; "));

        System.out.println("\ngenerate() 3х cлучайных чисел через поток:");
        IntStream.generate(() -> (int) (Math.random() * 100)).limit(3)
                .forEachOrdered((x) -> System.out.print(x + " _ "));

        System.out.println("\nГенерация 3х cлучайных чисел через поток"
                + " IntStream.range(0,3 ): ");
        // Работае только с целочисленными потоками (у DoubleStream нет такого метода)
        // _ range(0, 3) от 0 до 3 (не включая его)
        IntStream stream2 = IntStream.range(0, 3);
        stream2.forEachOrdered((x) -> System.out.print(x + ": "));
        System.out.println("\nIntStream.rangeClosed(0, 3): ");
        // _ range(0, 3) от 0 до 3 (включая его)
        IntStream stream3 = IntStream.rangeClosed(0, 3);
        stream3.forEachOrdered((x) -> System.out.print(x + ": "));
    }

}
