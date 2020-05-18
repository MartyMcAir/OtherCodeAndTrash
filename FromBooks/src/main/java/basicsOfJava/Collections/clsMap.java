/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava.Collections;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

/**
 *
 * @author MartyMcAir
 */
public class clsMap {

    public void listTreeMap() {
        // словарь, в котором ключи хранятся в отсортированном порядке 
        // в соответствии с алгоритмом «красно-черное дерево».
        // словарь со способом сравнения ключей по умолчанию 
        TreeMap<String, Integer> arrMap1 = new TreeMap<String, Integer>();
        arrMap1.put("a", 3);
        arrMap1.put("c", 9);
        arrMap1.put("b", 6);
        System.out.println("arrMap1: " + arrMap1); // {a=3, b=6, c=9}

        // сортировка в обратном порядке
        TreeMap<String, Integer> arrMap2
                = new TreeMap<String, Integer>(Collections.reverseOrder());
        arrMap2.put("d", 13);
        arrMap2.put("f", 18);
        arrMap2.put("e", 16);   // {f=18, e=16, d=13}
        System.out.println("Collections.reverseOrder() _ arrMap2: " + arrMap2);

        // создает объект на основе другого словаря, 
        // используя способ сравнения по умолчанию: 
        TreeMap<String, Integer> arrMap3 = new TreeMap<String, Integer>(arrMap1);
        System.out.println("arrMap3: " + arrMap3); // {a=3, b=6, c=9}
        arrMap3.putAll(arrMap2); // добавляем из другого словаря
        // {a=3, b=6, c=9, d=13, e=16, f=18}
        System.out.println(" arrMap3.putAll(arrMap2) _ arrMap3: " + arrMap3);

// возвращает объект сравнения или значение null, если используется сравнение по умолчанию. 
        System.out.println("arrMap3.comparator(): " + arrMap3.comparator()); // null
        // возвращает первый ключ.
        System.out.println("arrMap3.firstKey(): " + arrMap3.firstKey()); // a
        System.out.println("arrMap3.lastKey(): " + arrMap3.lastKey()); // c

        // возвращает срез от указанного ключа (не включая элемент с этим 
        // ключом) до начала набора. Обратите внимание на то, что все действия
        // с этим набором повлияют на исходный словарь.  
        // но только после smap.clear();
        SortedMap<String, Integer> smap = arrMap3.headMap("d");
        System.out.println("arrMap3.headMap(\"d\"): " + smap); // 
        // возвращает срез от указанного ключа, включая элемент с этим ключом 
        // (inclusive = true) или не включая его (inclusive = false), до конца набора.
        SortedMap<String, Integer> smap3 = arrMap3.tailMap("d", true);
        System.out.println("arrMap3.tailMap(\"d\"): " + smap3); // 
        // возвращает срез от ключа fromKey (включая элемент с этим ключом)
        // до значения toKey
        SortedMap<String, Integer> smap2 = arrMap3.subMap("b", "e");
        System.out.println("arrMap3.subMap(\"b\", \"e\"): " + smap2); // 

        // возвращает первый элемент
        System.out.println("arrMap3.firstEntry(): " + arrMap3.firstEntry()); // a=3
        System.out.println("arrMap3.lastEntry(): " + arrMap3.lastEntry()); // f=18
        // удаляет первый элемент и возвращает его.
        System.out.println("arrMap3.pollFirstEntry(): " + arrMap3.pollFirstEntry()); // a=3
        System.out.println("arrMap3.pollLastEntry(): " + arrMap3.pollLastEntry()); // f=18

        System.out.println("arrMap3: " + arrMap3); // {b=6, c=9, d=13, e=16}

        //  возвращает ключ с бо?льшим значением, чем указано (если 
        // сортировка в обратном порядке, то, наоборот, с меньшим значением). 
        System.out.println("arrMap3.higherKey(\"d\"): " + arrMap3.higherKey("d")); // e
        //  возвращает ключ с меньшим значением, чем указано 
        System.out.println("arrMap3.lowerKey(\"d\"): " + arrMap3.lowerKey("d")); // c
        // возвращает ключ с меньшим или равным значением, чем указано
        System.out.println("arrMap3.floorKey(\"d\"): " + arrMap3.floorKey("d")); // d
        // возвращает элемент с меньшим или равным значением ключа, чем указано
        System.out.println("arrMap3.floorEntry(\"d\"): " + arrMap3.floorEntry("d")); // d=13
        // возвращает элемент с меньшим значением ключа, чем указано 
        System.out.println("arrMap3.lowerEntry(\"d\"): " + arrMap3.lowerEntry("d")); // c=9

        // Возвращает ключ с бо?льшим или равным значением, чем указано
        System.out.println("arrMap3.ceilingKey(\"c\"): " + arrMap3.ceilingKey("c")); // c
        //  возвращает элемент с бо?льшим или равным значением ключа, чем указано 
        System.out.println("arrMap3.ceilingKey(\"c\"): " + arrMap3.ceilingKey("c")); // c

        // возвращает набор ключей, отсортированный в прямом по рядке
        NavigableSet<String> keys = arrMap3.navigableKeySet();
        System.out.println("arrMap3.navigableKeySet(): " + keys); // [b, c, d, e]
        // возвращает набор ключей, отсортированный в обратном порядке. 
        NavigableSet<String> keys2 = arrMap3.descendingKeySet();
        System.out.println("arrMap3.descendingKeySet(): " + keys2); // [e, d, c, b]
        // возвращает словарь с ключами, отсортированными в обрат ном порядке.  
        NavigableMap<String, Integer> keys3 = arrMap3.descendingMap();
        System.out.println("arrMap3.descendingMap(): " + keys3); // {e=16, d=13, c=9, b=6}
    }

    public void listProperties() {
        //  реализует словарь, состоящий из конфигурационных данных.
        //  содержит все методы из интерфейса Map<K, V>
        Properties pr = new Properties();
        // создает элемент или или изменяет значение существующего
        pr.setProperty("a", "3");
        pr.setProperty("b", "6");
        pr.setProperty("c", "9");
        pr.setProperty("d", "13");
        System.out.println("pr: " + pr);
        System.out.println("pr.get(\"a\"): " + pr.get("a"));
        System.out.println("pr.getProperty(\"b\"): " + pr.getProperty("b"));

        System.out.println("\nМетоды записи в конфиг файл: ");
        System.out.println("FileOutputStream _ prMap.store(fout, \"comments\"): ");
        OutputStream fout = null; // тоже работает он абстракт
        //FileOutputStream fout = null;
        try {
            fout = new FileOutputStream("C:\\z_n\\config.ini");
            Properties prMap = new Properties();
            prMap.setProperty("a", "13");
            prMap.setProperty("b", "9");
            prMap.setProperty("c", "6");
            prMap.setProperty("d", "3");
            prMap.store(fout, "comments");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("FileOutputStream _  prMap.storeToXML(fout2, \"comment\", \"UTF-8\"): ");
        FileOutputStream fout2 = null;
        try {
            fout2 = new FileOutputStream("C:\\z_n\\config.xml");
            Properties prMap2 = new Properties();
            prMap2.setProperty("a", "13");
            prMap2.setProperty("b", "9");
            prMap2.setProperty("c", "6");
            prMap2.setProperty("d", "3");
            prMap2.storeToXML(fout2, "comment", "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\nМетоды чтения из конфиг файла: ");
        System.out.println("FileInputStream _ prMap3.load(fin) _ file ini: ");
        InputStream fin = null;  // тоже работает он абстракт
        //FileInputStream fin = null;
        try {
            fin = new FileInputStream("C:\\z_n\\config.ini");
            Properties prMap3 = new Properties();
            prMap3.load(fin);
            System.out.println("prMap3: " + prMap3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\nFileInputStream _ prMap3.load(fin) _ file xml: ");
        FileInputStream fin2 = null;
        try {
            fin2 = new FileInputStream("C:\\z_n\\config.xml");
            Properties prMap4 = new Properties();
            prMap4.loadFromXML(fin2);
            System.out.println("prMap3: " + prMap4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listLinkedHashMap() {
        //  запоминает порядок вставки элементов или порядок доступа к элементам
        //  позволяет указать начальную емкость словаря, 
        // а третий — дополнительно коэффициент заполнения 
        Map<String, Integer> lhArr1 = new LinkedHashMap<>(16, 0.75f);
        lhArr1.put("a", 33);
        lhArr1.put("b", 36);
        lhArr1.put("c", 38);
        lhArr1.put("d", 39);
        System.out.println("lhArr1: " + lhArr1);

        // помимо емкости словаря и коэффициента заполнения, по зволяет указать
        // порядок доступа. Если параметр accessOrder имеет значение false 
        // (значение по умолчанию в других конструкторах), то запоминается 
        // порядок вставки элементов: 
        Map<String, Integer> lhArr2 = new LinkedHashMap<>(16, 0.75f, false);
        lhArr2.put("c", 38);
        lhArr2.put("d", 33);
        lhArr2.put("b", 36);
        System.out.println("lhArr2: " + lhArr2);

        // создает словарь на основе другого объекта, реализующего интерфейс Map<K, V>
        Map<String, Integer> lhArr3 = new LinkedHashMap<>(lhArr1);
        System.out.println("lhArr3: " + lhArr3);

    }

    public void listHashMap() {
        //  не гарантирует никакого порядка получения элементов

        //  позволяет указать начальную емкость словаря, 
        // а третий — дополнительно коэффициент заполнения 
        Map mapArr1 = new HashMap<String, Integer>(16, 0.75f);
        mapArr1.put("a", 3); // добавляет один элемент или изменяет значение существ
        mapArr1.put("b", 6);
        mapArr1.put("c", 9);
        mapArr1.put("d", 13);
        System.out.println("Методы которые добавляют, заменяют, удаляют\nmapArr1.size(): " + mapArr1.size()
                + " _ mapArr1: " + mapArr1);

        // создает словарь на основе другого объекта, реализующего интерфейс Map<K, V>
        Map<String, Integer> mapArr2 = new HashMap<String, Integer>(mapArr1);
        System.out.println(" mapArr2.size(): " + mapArr2.size()
                + " _ mapArr2: " + mapArr2);
        // добавляет один элемент, не изменяя значение существующего элемента.
        // Метод возвращает значение null, если ключа не было в словаре, 
        // и старое значение, если ключ существует в словаре
        System.out.println("mapArr1.putIfAbsent(\"e\", 16): " + mapArr1.putIfAbsent("e", 16));
        System.out.println("mapArr1.putIfAbsent(\"e\", 16): " + mapArr1.putIfAbsent("e", 16));

        // добавляет несколько элеми же ключами существуют в слова ре, 
        // то их значения будут заменены новыми
        Map<String, Integer> mapArr3 = new HashMap<String, Integer>();
        mapArr3.put("a", 16);
        mapArr3.put("b", 19);
        mapArr3.put("c", 23);
        mapArr2.putAll(mapArr3);
        System.out.println("mapArr2.putAll(mapArr3) _ mapArr2" + mapArr2);

        mapArr2.replace("a", 33);
        System.out.println("mapArr2.replace(\"a\", 33) _ mapArr2" + mapArr2);
        System.out.println("mapArr3: " + mapArr3);

        // применяет function ко всем элементам словаря. function принимает 
        // два параметра (ключ и значение) и возвращает новое значение. 
        // Не работает если пр объявлении интерфейса не указаны <> скобки
        mapArr3.replaceAll((k, v) -> mapArr3.get(k) * 2);
        System.out.println("mapArr3.replaceAll((k, v) -> mapArr3.get(k) * 2) "
                + "_ mapArr3: " + mapArr3);

        mapArr3.clear();   // удаляет все элементы из словаря. 
        System.out.println("mapArr3.clear() _ mapArr3: " + mapArr3);

        mapArr2.remove("a");
        System.out.println("mapArr2.remove(\"a\") _ mapArr2: " + mapArr2);

        // возвращает значение элемента с указанным ключом. 
        // Если ключ не существует, то метод возвращает значение null
        System.out.println("\nМетоды которые возвращают:\nmapArr2.get(\"c\"): " + mapArr2.get("c"));
        // возвращает значение true, если ключ существует в словаре, и false — в противном случае. 
        System.out.println("mapArr2.containsKey(\"b\"): " + mapArr2.containsKey("b"));
        // возвращает значение true, если указанное значение существует в словаре, и false — в противном случае. \
        System.out.println("mapArr2.containsValue(19): " + mapArr2.containsValue(19));

        // возвращает значение элемента с указанным ключом. Если ключ 
        // не существует, то метод возвращает значение, указанное во втором параметре.
        System.out.println("mapArr2.getOrDefault(\"c\", 0): " + mapArr2.getOrDefault("c", 0));
        System.out.println("mapArr2.getOrDefault(\"a\", 0): " + mapArr2.getOrDefault("a", 0));

        // возвращает множество с ключами.
        Set<String> sKeyArr = mapArr2.keySet();
        System.out.println("sKeyArr: " + sKeyArr);   // [b, c, d]
        // возвращает коллекцию со значениями
        Collection<Integer> cArr1 = mapArr2.values();   // [19, 23, 13]
        System.out.println("cArr1: " + cArr1);

        System.out.println("\nПеребор элементов словаря "
                + "Set<Map.Entry<String, Integer>>:");
        // возвращает множество, состоящее из объектов, реализующих интерфейс Map.
        // Entry<K, V>. Эти объекты содержат метод getKey() для получения ключа 
        // и метод getValue() для получения значения.
        Set<Map.Entry<String, Integer>> entryArr1 = mapArr2.entrySet();
        System.out.println("entryArr1: " + entryArr1);
        for (Map.Entry<String, Integer> item : entryArr1) {
            System.out.print("item.getKey(): " + item.getKey()
                    + " _ item.getValue(): " + item.getValue() + "\n");
        }

        System.out.println("Перебор словаря for(String item : mapArr2.keySet()):");
        for (String item : mapArr2.keySet()) {
            System.out.print("item: " + item + " mapArr2.get(item) "
                    + mapArr2.get(item) + " ; \n");
        }
        System.out.println("Перебор словаря for(Map.Entry<String, Integer> item : mapArr2.entrySet()):");
        for (Map.Entry<String, Integer> item : mapArr2.entrySet()) {
            System.out.print("item.getKey(): " + item.getKey()
                    + " item.getValue(): " + item.getValue() + " _ \n");
        }
        System.out.println("Перебор словаря и умножение всех его значений на2:");
        for (String item : mapArr2.keySet()) {
            mapArr2.put(item, mapArr2.get(item) * 2);
        }
        System.out.print("mapArr2: " + mapArr2);

        System.out.println("\nПеребор элементов словаря "
                + "mapArr2.forEach((k, v)->System.out.print(k+\":\"+v))");
        mapArr2.forEach((k, v) -> System.out.print(k + ":" + v + ", "));
        System.out.println("\nПеребор элементов словаря и деление их на3 "
                + "mapArr2.forEach((k, v)->mapArr2.put(k, mapArr2.get(k)/2))");
        mapArr2.forEach((k, v) -> mapArr2.put(k, mapArr2.get(k) / 3));
        System.out.println("mapArr2: " + mapArr2);
    }
}
