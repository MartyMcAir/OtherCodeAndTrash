/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepByStep.step4Four;

import java.util.*;

/**
 *
 * @author MartyMcAir
 */
public class clsMap {

    public static void main(String[] args) {
        clsMap cls = new clsMap();
//        cls.runHashMap(); // HashMap
//        cls.runLinkedMap();
//        cls.runProperiesBase();
         // SKIP TeeMap - тоже самое что и TreeSet, но для словаря получаем его срез
         
    }

    void runProperiesBase() {
        System.out.println("Properties - класс словарь спец для хранения "
                + "настроек конфиг..: ");
        Properties pMap = new Properties();
        pMap.put("login", "superMan");
        pMap.put("passw", "123");
        pMap.put("email", "mail@enail.go");
        System.out.println("pMap: " + pMap);
        System.out.println("pMap.getProperty(\"login\"): " + pMap.getProperty("login"));
    }

    void runLinkedMap() {
        System.out.println("LinkeMap ассоциатив словарь помнит порядок элементов");
        LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
        map.put("USA", 19);
        map.put("China", 10);
        map.put("GreatB", 7);
        map.put("Australiya", 5);
        System.out.println(map);

        System.out.println("методы и т.д. такие же как у HashMap");
    }

    void runHashMap() {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("java 9", 9);
        map.put("java 8", 8);
        map.put("java 7", 7);
        map.put("java 6", 6);
        System.out.println("HashMap Ассоциативный словарь ключ=значение _"
                + " произвольный порядок, не может содержать одинаковых ключей"
                + "\n нет стандартной сортировки использует Navigable: "
                + map);
        map.remove("java 7");
        System.out.println("map.remove(\"java 7\"): " + map);
        System.out.println("map.get(\"java 9\"): " + map.get("java 9"));
        System.out.println("получаем только ключи "
                + "map.keySet(): " + map.keySet());
        System.out.println("только значения map.values(): " + map.values());

        System.out.println("map.containsKey(\"java 9\")?: " + map.containsKey("java 9"));
        System.out.println("map.containsValue(9)?: " + map.containsValue(9));

        System.out.println("\nПеребор HashMap: ");
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        System.out.println("через Set<Map.Entry<String, Integer> > set: " + set);
        for (Map.Entry<String, Integer> item : set) {
            System.out.print("item.getKey(): " + item.getKey()
                    + ", value: " + item.getValue() + " _\n");
        }

        System.out.println("\nчерез for(String item : map.keySet())..: " + set);
        // в цикле получая 1 ключ из массива ключей keySet
        // делаем запрос через map.get(текущий ключ) и получаем нужное значение
        for (String item : map.keySet()) {
            System.out.print("key: " + item + ", item: " + map.get(item));
        }

        System.out.println("\n\nчерез  map.forEach((a,b)->..: " + set);
        map.forEach((a, b) -> System.out.print(a + " = " + b + " _ "));
    }
}
