/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava.Collections;

import java.util.*;

/**
 *
 * @author MartyMcAir
 */
public class clsIterator {
    public void listEnumeration() {
        Vector arr1 = new Vector<>();
        Collections.addAll(arr1, 33, 13, 888);
        System.out.println("arr1: " + arr1);

        Enumeration<Integer> en = arr1.elements();
        // hasMoreElements() возвращает значение true, если можно получить 
        // следующий элемент, и false — в противном случае
        System.out.print(" while(en.hasMoreElements())_ en.nextElement(): \n");
        while (en.hasMoreElements()) {
            //  перемещает указатель на одну позицию и возвращает 
            // элемент слева от указателя.
            System.out.print(en.nextElement() + "; ");
        }
        // Если ожидается объект, реализующий интерфейс Enumeration<E>, 
        // но коллекция не реализует этот интерфейс, то можно воспользоваться
        // статическим методом enumeration() из класса Collections. 
        Enumeration<Integer> en2 = Collections.enumeration(arr1);
        System.out.println("\narr1: " + arr1);
        en2.nextElement();
        System.out.println("en2.nextElement _ en2.nextElement: " + en2.nextElement());
    }

    public void listIterator() {
        List arr1 = new ArrayList<>();
        Collections.addAll(arr1, 33, 8, 99);
        ListIterator li = arr1.listIterator();
        System.out.println("arr1: " + arr1);
        // возвращает значение true, если можно получить 
        // следующий элемент коллекции, и false — в противном случае
        System.out.println("li.hasNext(): " + li.hasNext());
        // перемещает указатель на одну позицию и возвращает элемент слева от указателя.
        System.out.println("li.next(): " + li.next());
        //  метод возвращает значение true, если можно 
        // получить предыдущий элемент коллекции, и false — в противном случае.
        System.out.println("li.hasPrevious(): " + li.hasPrevious());
        //  перемещает указатель на одну позицию назад и возвращает элемент справа от указателя
        System.out.println("li.previous(): " + li.previous());
        // удаляет элемент слева от указателя
        // (если вызван метод next()) или справа (если вызван метод previous()).
        li.remove();
        System.out.println("li.remove() _ arr1: " + arr1);
        System.out.println("li.nextIndex() _ arr1: " + li.nextIndex());
        System.out.println("li.previousIndex() _ arr1: " + li.previousIndex());
        li.add(777);
        System.out.println("li.add(777) _ arr1: " + arr1);
        // заменяет элемент, возвращенный последним вызовом метода 
        // next() или previous(). Если перед этим был вызван метод add() 
        // или метод remove(), то следует предварительно вызвать 
        // метод next() или previous(), иначе будет ошибка. 
        li.next();
        li.set(333);
        System.out.println("li.next() _ li.set(333) _ arr1: " + arr1);
    }
}
