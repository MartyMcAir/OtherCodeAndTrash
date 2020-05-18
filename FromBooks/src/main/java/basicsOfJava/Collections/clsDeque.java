/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava.Collections;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author MartyMcAir
 */
public class clsDeque {

    public void listPriorityQueue() {
        //  add() и offer() из интерфейса Queue<E>, 
        // а для удаления и возвращения элемента — методы remove() и poll(). 

        // указать способ определения приоритета. с помощью компаратор и 
        // Анонимного класса переопределяющего метож
        // Изменим приоритет на противоположный:
        PriorityQueue arr1 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b.compareTo(a);
            }
        });
        Collections.addAll(arr1, 33, 18, 99);
        System.out.println("arr1: " + arr1); // [99, 18, 33]

        //  указать начальную емкость очереди и способ определения приоритета:
        // обратный перевертыш 
        PriorityQueue arr2 = new PriorityQueue<Integer>(20, Collections.reverseOrder());
        Collections.addAll(arr2, 33, 18, 99);
        System.out.println("arr1: " + arr2); // [99, 18, 33]
        // возвращает элемент с наибольшим приоритетом без удаления
        System.out.println(arr2.peek());
    }

    public void listArrayDeque() {
        ArrayDeque arr1 = new ArrayDeque<>();
        Collections.addAll(arr1, 8, 3, 16, 9);
        System.out.println("arr1: " + arr1);
        // добавляет элемент в конец очереди.
        System.out.println("arr1.add(88): " + arr1.add(88) + " _ arr1: " + arr1);
        arr1.addFirst(99);
        System.out.println("arr1.addFirst(99): _ arr1: " + arr1);
        arr1.addLast(999);
        System.out.println("arr1.addLust(999): _ arr1: " + arr1);

        // добавляет элемент в конец очереди. возвращает значение true, если элемент был добавлен. 
        arr1.offer(777);
        System.out.println("arr1.offer(777) _ arr1.add(88): " + arr1.add(88) + " _ arr1: " + arr1);
        arr1.offerFirst(111); //  добавляет элемент в начало очереди. 
        System.out.println("arr1.offerFirst(111) _ arr1: " + arr1);
        arr1.offerLast(666); //  добавляет элемент в конец очереди. 
        System.out.println("arr1.offerLast(666) _ arr1: " + arr1);
        arr1.push(333); //   добавляет элемент в начало очереди
        System.out.println("arr1.push(333) _ arr1: " + arr1);
    }   
}
