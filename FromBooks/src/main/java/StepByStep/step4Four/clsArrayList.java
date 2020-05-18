/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepByStep.step4Four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author MartyMcAir
 */
public class clsArrayList {

    public static void main(String[] args) {
        clsArrayList cls = new clsArrayList();
        System.out.println("ArrayList список как массив с автоматическим"
                + " увеличением своей емкости, быстрый доступ по индексу"
                + "\n но добавл и удаляются, элементы списка долго");
        
        ArrayList<Integer> arrInt = new ArrayList<Integer>();
        Integer[] arrInts = {46,88,99,13,33,66};
        Collections.addAll(arrInt, arrInts);
        System.out.println("Cоздание коллекции из Integer[] arr: "+arrInt+"\n");
        
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Collections.addAll(arr, 3, 6, 8, 9, 13);
        System.out.println("Collections.addAll(arr, 3,6,8,9,13): " + arr
                + ", arr.size(): " + arr.size());
        arr.add(18);
        System.out.println("arr.add(18): " + arr);
        arr.remove(2);
        System.out.println("arr.remove(2): " + arr);

        System.out.println("\nПримеры перебора Array списка");
        cls.arrShow(arr);
        System.out.println("через for(int i..) x*2: " + cls.arrMultipleX2(arr));
        System.out.print("arr.forEach((elem)->System.out.print(elem+\"; \")): ");
        arr.forEach((elem) -> System.out.print(elem + "; "));

        Iterator it = arr.iterator();
        System.out.println("\nПеребор с помощью Итератора: "
                + "\ncls.arrIteratorPlus10(it) x+10: "
                + cls.arrIteratorPlus10(it));

        
        System.out.println("\nПеребор циклом for(int i..) внутри лямбды +10"
                + "цикл внутри цикла: ");
        arr.forEach((n) -> {
            int tmp;
            for (int i = 0; i < arr.size(); i++) {
                System.out.print((arr.get(i) + 10) + ", ");
            }
            System.out.println("___" + n);
        });

        System.out.println("\nArray список to int[] arr: ");
        System.out.println(Arrays.toString(cls.ListToArray(arr)));

        System.out.println("\nСортирока в обратном порядке _ reverseOrder(): ");
        Collections.sort(arr, Collections.reverseOrder());
//        Collections.sort(arr); // сортировка по порядку
        System.out.println(arr);
        
        arr.add(666);
        System.out.println("arr.add(666): "+arr);
        arr.remove(3);
        System.out.println("arr.remove(3): "+arr);
    }

    int[] ListToArray(ArrayList<Integer> arr) {
        int tmp;
        int[] arr2 = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            tmp = arr.get(i);
            arr2[i] = tmp;
        }
        return arr2;
    }
    
    void arrShow(ArrayList<Integer> arr) {
        System.out.print("for(* : *): ");
        for (int item : arr) {
            System.out.print(item + ", ");
        }
        System.out.println();
    }

    ArrayList<Integer> arrMultipleX2(ArrayList<Integer> arr) {
        int tmp;
        for (int i = 0; i < arr.size(); i++) {
            tmp = arr.get(i);
            arr.set(i, (tmp * 2));
        }
        return arr;
    }

    ArrayList<Integer> arrIteratorPlus10(Iterator it) {
        int tmp, i = 0;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        while (it.hasNext()) {
            tmp = (int) it.next();
            arr.add(i, (tmp + 10));
            i++;
        }
        return arr;
    }
}
