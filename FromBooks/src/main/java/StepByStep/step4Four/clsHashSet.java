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
public class clsHashSet {

    public static void main(String[] args) {
        System.out.println("множества, т.е. по элементу можно понять "
                + "из какого он набора т.е. массива _ "
                + "\nдобавление элементов в произволльном порядке"
                + "\n множества не могут содержать одинаковых элементов"
                + "\n каждый элемент имеет уникальный хэш-код");

        HashSet<String> arr = new HashSet<String>();
        arr.add("java");
        arr.add("easy");
        arr.add("easy");
        arr.add("step");
        arr.add("difficult");
        arr.add("Learn");
        System.out.println("easy - только один _ arr: " + arr);

        System.out.println("\nLinkedHashSet - в отличии от HashSet запоминает "
                + "порядок добавления элементов");
        LinkedHashSet<String> arrLink = new LinkedHashSet<String>();
        arrLink.add("when");
        arrLink.add("you");
        arrLink.add("know; ");
        arrLink.add("step");
        arrLink.add("is");
        arrLink.add("easy");
        arrLink.add("easy");
        System.out.println("easy - только один _ arrLink: " + arrLink);
        arrLink.retainAll(arr);
        System.out.println("\nудаляем элементы которые не содержатся в множестве "
                + "arrLink.retainAll(arr): " + arrLink);
        System.out.println("arrLink.contains(\"step\") ?: " + arrLink.contains("step"));

        arrLink.addAll(arr);
        System.out.println("arrLink.addAll(arr): " + arrLink);
        System.out.println("arrLink.containsAll(arr) ?: "
                + arrLink.containsAll(arr));

        Object[] arrStr = arrLink.toArray();
        System.out.println("Преобразуем Множество в массив объектов"
                + Arrays.toString(arrStr));

        System.out.print("\n\nСоздаем из коллекции множесвто: ");
        ArrayList<Integer> arrArr = new ArrayList();
        Collections.addAll(arrArr, 3, 6, 8, 9, 13, 0, 13, 6, 8);
        System.out.println("arrArr: " + arrArr);
        LinkedHashSet<Integer> arrL = new LinkedHashSet();
        arrL.addAll(arrArr);
        System.out.println("элементы без повтороы arrL.addAll(arrArr): " + arrL);

    }
}
