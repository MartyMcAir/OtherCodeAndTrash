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
public class clsTreeSet {

    public static void main(String[] args) {
        System.out.println("PriorityQueue Очередь с приоритетом "
                + "(т.к. очередь => может иметь одинаковые значения)_ "
                + "new Coparator<Integer(){..} >: ");
        System.out.println("Приортет на противоположный .. return b.compareTo(a): ");
        PriorityQueue<Integer> arrP = new PriorityQueue<Integer>(
                new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b.compareTo(a);
            }
        });
        Collections.addAll(arrP, 3, 3, 6, 6, 8, 8, 9, 9);
        System.out.println("arrP: " + arrP);  // [9, 9, 8, 6, 6, 3, 8, 3]

        System.out.println("Приортет попорядку: ");
        implComparator impl = new implComparator();
        PriorityQueue<Integer> arrP2 = new PriorityQueue<Integer>(impl);
        Collections.addAll(arrP2, 3, 3, 6, 6, 8, 8, 9, 9);
        System.out.println("arrP2: " + arrP2);  // [3, 3, 6, 6, 8, 8, 9, 9]
        
        
        // как и множество не может хранить одинаковые элементы
        System.out.println("\nНабор уникальных элементов, хранимых в отсортированном "
                + "порядке, в соответствии с алгоритмом «красно-черное дерево»");
        System.out.println("TreeSet по сути основная его функция Хранит методы при определенных "
                + "условиях для получения оперделенного среза от очереди. ");
     
        System.out.println("\nheadSet(*) возвращает срез от указанного элемента НЕ включая его.. ");
        TreeSet<Integer> arr = new TreeSet<Integer>(Collections.reverseOrder());
        Collections.addAll(arr, 3, 3, 6, 6, 8, 8, 9, 9, 18, 18, 13, 13, 1, 1);
        System.out.println("arr: " + arr);
        SortedSet<Integer> arr2 = arr.headSet(8);
        System.out.println("arr.headSet(8): " + arr2);

        System.out.println("\ntailSet(*) возвращает срез от указанного элемента включая его.. ");
        TreeSet<Integer> arr3 = new TreeSet<Integer>(Collections.reverseOrder());
        Collections.addAll(arr3, 3, 3, 6, 6, 8, 8, 9, 9, 18, 18, 13, 13, 1, 1);
        System.out.println("arr3: " + arr3);
        SortedSet<Integer> arr4 = arr3.tailSet(8);
        System.out.println("arr3.tailSet(8): " + arr4);

        System.out.println("\nsubSet(*,*) возвращает срез от элемента до элемента.. ");
        TreeSet<Integer> arr5 = new TreeSet<Integer>(Collections.reverseOrder());
        Collections.addAll(arr5, 3, 3, 6, 6, 8, 8, 9, 9, 18, 18, 13, 13, 1, 1);
        System.out.println("arr5: " + arr5);
        SortedSet<Integer> arr6 = arr5.subSet(13, 3);
        System.out.println("arr5.subSet(13, 3): " + arr6);

        System.out.println("\nhigher(*) возвращает след. элемент больший указанного"
                + ", если сортировка в обратном порядке то след. элем меньше указанного ");
        TreeSet<Integer> arrH = new TreeSet<Integer>(impl);
        Collections.addAll(arrH, 3, 3, 6, 6, 8, 8, 9, 9, 18, 18, 13, 13, 1, 1);
        System.out.println("arrH: " + arrH);
        System.out.println("arrH.higher(3): " + arrH.higher(3));

        System.out.println("\nhigher(*) возвращает след. элемент с больш или равным знач");
        System.out.println("arrH.ceiling(3): " + arrH.ceiling(3));

        System.out.println("\nhigher(*) возвращает след. элемент с меньш или равн знач");
        System.out.println("arrH.floor(3): " + arrH.floor(3));

        System.out.println("\nhigher(*) возвращает след. элемент с меньш знач");
        System.out.println("arrH.lower(3): " + arrH.lower(3));
        
        System.out.println("\ndescendingSet() возвращает набор в обратном порядке");
        NavigableSet<Integer> sSet = arrH.descendingSet();
        System.out.println("arrH to sSet reverse: "+sSet);
        
        System.out.println("\ndescendingIterator() Iterator для прохождения"
                + " множества в обратном порядке");
        System.out.println("arrH to come backe");
        Iterator<Integer> it = sSet.descendingIterator();
        while(it.hasNext()){
            System.out.print(it.next()+" _ ");
        }
    }
}
