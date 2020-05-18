/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepByStep.step4Four;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author MartyMcAir
 */
public class clsLinkedList {

    public static void main(String[] args) {
        clsLinkedList cls = new clsLinkedList();
        System.out.println("LinkeList связанный список или очередь, элементы храняты"
                + "ссылки на соседние элементы _ быстро удал и добавл"
                + "\n, но медленный доступ по индексу");
        LinkedList<String> arr = new LinkedList<String>();
        Collections.addAll(arr, "easy", "java", "difficult", "learn");
        System.out.println("\n" + arr);

        arr.sort(null);
        System.out.println("\nСортировка: \narr.sort(null): " + arr);
        arr.sort(Collections.reverseOrder());
        System.out.println("arr.sort(Collections.reverseOrder()): " + arr);

        arr.add("I Pick");
        arr.add("I Boil");
        arr.add("I Braise");
        System.out.println("\narr.add(\"I Pick\")..: " + arr);
        arr.remove(2);
        System.out.println("arr.remove(2): " + arr);

        System.out.println("\nСоздаем одностороннюю очередь Queue "
                + "(первым пришел первым ушел) _ poll и pop удаляют из очереди"
                + "\nи перебираем её через while и arr.poll(): ");
        Queue<Integer> arrPoll = new LinkedList<Integer>();
        arrPoll.offer(1); // в коней очереди
        arrPoll.offer(2);
        arrPoll.offer(3);
        arrPoll.offer(6);
        arrPoll.offer(9);
        arrPoll.offer(0);
        cls.arrShowPoll(arrPoll);

        System.out.println("\nСоздаем двухстороннюю очередь Deque "
                + "(последний уходит первым) т.е. по сути reverse на оборот"
                + "\nи перебираем её через while и arr.pop(): ");
        Deque<Integer> arrPop = new LinkedList<Integer>();
        arrPop.push(1); // в начало очереди
        arrPop.push(2);
        arrPop.push(3);
        arrPop.push(9);
        arrPop.push(6);
        arrPop.push(0);
        cls.arrShowPop(arrPop);    
        
    }

    void arrShowPoll(Queue<Integer> arr) {
        while (!arr.isEmpty()) {
            System.out.print(arr.poll() + ", ");
        }
    }

    void arrShowPop(Deque<Integer> arr) {
        while (!arr.isEmpty()) {
            System.out.print(arr.pop() + ", ");
        }
    }
}
