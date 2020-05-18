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
public class clsList {

    public void listStack() {
        Stack arr1 = new Stack<>();
        Collections.addAll(arr1, 3, 18, 8, 6);
        // добавляет элемент в конец очереди.
        System.out.println("arr1: " + arr1);  // [3, 18, 8, 6]
        arr1.push(33);
        System.out.println("arr1.push(33) _ arr1: " + arr1);  // [3, 18, 8, 6, 33]
        //  удаляет последний элемент из очереди и возвращает его.
        System.out.println("arr1.pop(): " + arr1.pop() + " arr1: " + arr1);
        // возвращает значение true, если очередь пуста, и false — в противном случае.
        System.out.println("arr1.empty(): " + arr1.empty());  // false
        //  возвращает номер позиции элемента с конца очереди, соответствующего указанному объекту.
        System.out.println("arr1.search(8): " + arr1.search(18));  // 2

        // Перебираем список с помощью while
        int i = 0;
        while (!arr1.isEmpty()) {
            System.out.print(arr1.pop() + "; "); // 6; 8; 18; 3; 
            i++;
        }
    }

    public void listVector() {
        // Если еспользовать интерфейсную переменную, 
        // то будут доступны только методы интерфейса, а его 
        // т.е. Vector'a нет
        Vector arr1 = new Vector<>();
        Collections.addAll(arr1, 6, 8, 13, 9);
        // // arr1.size(): 4 _ arr1: [6, 8, 13, 9]
        System.out.println("arr1.size(): " + arr1.size() + " _ arr1: " + arr1);
        arr1.setSize(8);
        // arr1.setSize(8): 8 _ arr1: [6, 8, 13, 9, null, null, null, null]
        System.out.println("arr1.setSize(8): " + arr1.size() + " _ arr1: " + arr1);
        System.out.println("arr1.capacity(): " + arr1.capacity());   // 10
        arr1.trimToSize(); // удаляет все пустые емкости
        System.out.println(" arr1.trimToSize() _ arr1.capacity(): " + arr1.capacity());   // 8
        System.out.println(arr1);   // [6, 8, 13, 9, null, null, null, null]

        // добавляет один элемент в конец списка. 
        arr1.addElement(10);
        // [6, 8, 13, 9, null, null, null, null, 10]
        System.out.println("arr1.addElement(10) в коней списка: " + arr1);

        // вставляет элемент в указанную позицию. 
        arr1.insertElementAt(88, 0); // 88 в начало
        // [88, 6, 8, 13, 9, null, null, null, null, 10]
        System.out.println("arr1.insertElementAt(88, 0): " + arr1);
        // Получаем первый и последний элементы
        System.out.println("arr1.firstElement(): " + arr1.firstElement());
        System.out.println("arr1.lastElement(): " + arr1.lastElement());
        // Получаем элемент списка по индексу
        System.out.println("arr1.elementAt(3): " + arr1.elementAt(3));
        // Изменяем значение элемента списка по индексу
        arr1.setElementAt(33, 3);
        // [88, 6, 8, 33, 9, null, null, null, null, 10]
        System.out.println("arr1.setElementAt(33, 3): " + arr1);

        // удаляем элемент по индексу
        arr1.removeElementAt(4);
        System.out.println("arr1.removeElementAt(4): " + arr1);
        // удаляет первый элемент с указанным значением. 
        arr1.removeElement(null);
        System.out.println("arr1.removeElement(null): " + arr1);

        // находит первый элемент, соответствующий указанному объекту, 
        // и возвращает его индекс или значение –1, означающее, что элемент не найден.
        System.out.println("arr1.indexOf(null): " + arr1.indexOf(null));
        //  находит последний элемент, соответствующий указанному объекту,
        System.out.println("arr1.lastIndexOf(null): " + arr1.lastIndexOf(null));
        arr1.removeAllElements();
        System.out.println(" arr1.size(): " + arr1.size()
                + " arr1.capacity(): " + arr1.capacity() + " arr1: " + arr1);
        arr1.trimToSize();
        System.out.println("arr1.trimToSize() _ arr1.capacity(): " + arr1.capacity());
    }

    public void listLoops() {
        List arr1 = new ArrayList<Integer>();
        Collections.addAll(arr1, 1, 3, 2, 4, 6, 5);

        // Перебираем список через метод forEach
        System.out.println("\n_ arr1.forEach(elem->System.out.print(elem+\", \")");
        arr1.forEach(elem -> System.out.print(elem + ", "));

        // Перебираем список с помощью спец формы цикла for
        System.out.println("\n_ for(Object item : arr1){ }");
        for (Object item : arr1) {
            System.out.print(item + "; ");
        }

        // Перебираем список с помощью цикла for
        // И изменим его элемнты умнохив их на 2
        System.out.println("\n_ for(int i = 0; i < arr1.size(); i++){ }");
        Integer x = 0;
        for (int i = 0; i < arr1.size(); i++) {
            x = (Integer) arr1.get(i); // приведение к типу (Integer)
            x *= 2;
            arr1.set(i, x);
        }
        System.out.print("После умножения каждого его элемента на 2 arr1: "
                + arr1);

        System.out.println("\n_ while(j < arr1.size()){ }");
        int j = 0;
        while (j < arr1.size()) {
            System.out.print(j + " _ ");
            j++;
        }

        // Перебираем список с помощью while и Iterator
        System.out.println("\n_ while(it.hasNext()){ }");
        Iterator<Integer> it = arr1.iterator();
        while (it.hasNext()) { // переставляем указатель на след элемент
            System.out.print(it.next() + ": "); // получаем элемент
        }
    }

    public void showExm_sTrimToSize() {
        List arr1 = new ArrayList<>();
        Collections.addAll(arr1, 9, 3, 6, 13, 18, 33);

        List arr2 = new ArrayList<>();
        Collections.addAll(arr2, "tree", "two", "one", "zero");
        // добавляет элементы из другой коллекции
        arr1.addAll(arr2);

        // используются для получения позиций вхождения одного списка в другой 
        // НЕ ПОНЯЛ СМЫСЛА И ЧТО ДЕЛАЕТ !?
        Collections.indexOfSubList(arr1, arr2);
        System.out.println("Collections.indexOfSubList(arr1, arr2) arr1: " + arr1);
        Collections.indexOfSubList(arr2, arr1);
        Collections.lastIndexOfSubList(arr1, arr2);
        System.out.println("Collections.indexOfSubList(arr2, arr1) arr1: " + arr1);

        // создаем массив объектов из списка
        Object arrObj = arr1.toArray();
        System.out.println(arrObj.toString()); // без toString [Ljava.lang.Object;@17550481

        // НЕ РАБОТАЕТ
//        // создаем массив и заполняем элементами из списка
//        List arr3 = new ArrayList<Integer>();
//        Collections.addAll(arr3, 3, 8, 13, 9);
//        // c Integer arrInt _ почемуто не хочет работать
//        Object[] arrInt = arr3.toArray( new Integer [arr3.size()] );
//        //int arrInt2 = Integer.parseInt(arrInt.toString());
//        //System.out.println(arrInt );
        // trimToSize Где сам метод!?
        // При удалениии жлемента емкость списка не уменьшается
        // для уменьшения емкости используют trimToSize()
        System.out.println(arr1);
        System.out.println("arr1.size: " + arr1.size() + " _ arr1: " + arr1);
        arr1.remove(0);
        System.out.println("arr1.size: " + arr1.size() + " _ arr1.remove(0) _ arr1: " + arr1);

        // НЕ ЯСНО КАК ПОЛУЧИТЬ значение емкости ведь arr.size
        // почему-то уменьшает автоматич кол-во емкости т.е. и 
        // после trimToSize никаких изменений не происходит
        ArrayList arr3 = new ArrayList<>();
        Collections.addAll(arr3, 1, 2, 3, 4, 5, 6);
        System.out.println("arr3.size: " + arr3.size() + " _ arr3: " + arr3);
        arr3.remove(5);
        System.out.println("arr3.remove(5): " + "arr3.size: " + arr3.size() + " _ arr3: " + arr3);
        arr3.trimToSize();
        System.out.println("arr3.trimToSize(): " + "arr3.size: " + arr3.size() + " _ arr3: " + arr3);

    }

    public void showMinMaxContain() {
        List arr1 = new ArrayList<>();
        Collections.addAll(arr1, 33, 13, 99, 8, 6, 88);

        List arr2 = new ArrayList<>();
        Collections.addAll(arr2, 6, 8, 88);
        List arr3 = new ArrayList<>();
        Collections.addAll(arr3, 800, 8, 88);
        System.out.println("current arr1: " + arr1); // [33, 13, 99, 8, 6, 88]
        System.out.println("current arr2: " + arr2); // [6, 8, 88]
        System.out.println("current arr3: " + arr3); // [800, 8, 88]

        // получаем минимал значение списка
        System.out.println("Collections.min(arr1): " + Collections.min(arr1)); // 6
        // получаем максим значение списка
        System.out.println("Collections.max(arr1): " + Collections.max(arr1)); // 99

        // проверяем содержатся ли все значения из списка arr2 в arr1
        System.out.println("arr1 содержит все значения из arr2?: "
                + arr1.containsAll(arr2));  // true
        System.out.println("arr1 содержит все значения из arr3?: "
                + arr1.containsAll(arr3));  // false

        System.out.println("arr1.contains(99) arr1 содержит 99?: "
                + arr1.contains(99));  // true
        System.out.println("arr2.contains(99) arr2 содержит 99?: "
                + arr2.contains(99));  // false

    }

    public void showSortReverseShuffle() {
        // Создаем и сортируем
        List arr3 = new ArrayList<Integer>();
        Collections.addAll(arr3, 33, 88, 99, 13, 8, 8);
        // [33, 88, 99, 13, 8, 8]
        System.out.println("arr3 create: " + arr3.toString());

        Collections.sort(arr3); // по порядку
        System.out.println(" Collections.sort: "
                + arr3.toString());  // [8, 8, 13, 33, 88, 99]
        Collections.sort(arr3, Collections.reverseOrder());
        // в обратном порядке  [99, 88, 33, 13, 8, 8]
        System.out.println("Collections.reverseOrder(): "
                + arr3.toString());  // [99, 88, 33, 13, 8 8]

//        // тоже самое что и сортировка в обратном порядке
//        Collections.sort(arr3, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer x, Integer y) {
//                return y.compareTo(x);
//            }
//        });
//        System.out.println(arr3.toString());  // [99, 88, 33, 13, 8, 8]
        // Заменяем все значения в списке 8 на значения 777
        Collections.replaceAll(arr3, 8, 777);
        System.out.println("Collections.replaceAll 8 to 777: " + arr3.toString());  // [99, 88, 33, 13, 777, 777]

        // Исщем значение в списке и получаем его индекс
        System.out.println("Collections.binarySearch for 777: "
                + Collections.binarySearch(arr3, 777)); // 4
        // -5 если возвращает отрицательно число то не нашел
        System.out.println("Collections.binarySearch for 77: "
                + Collections.binarySearch(arr3, 77));

        // кол-во элементов в списке с указанным значением..
        System.out.println("Collections.frequency _ элемнтов с указанным значеним: "
                + Collections.frequency(arr3, 777)); // 2

        List arr1 = new ArrayList<>();
        Collections.addAll(arr1, 33, 13, 99, 8, 6, 88);
        System.out.println("with out reverse: " + arr1); // [33, 13, 99, 8, 6, 88]
        Collections.reverse(arr1);
        System.out.println("Collections.reverse: " + arr1); // [88, 6, 8, 99, 13, 33]

        Random rnd = new Random();
        Collections.shuffle(arr1, rnd);
        // порядок их следования все время меняется
        System.out.println("Collections.shuffle(arr1, rnd): " + arr1);
        Collections.shuffle(arr1);
        // тоже все время меняется
        System.out.println("Collections.shuffle(arr1): " + arr1);

        arr1.sort(Comparator.naturalOrder());
        // [6, 8, 13, 33, 88, 99]
        System.out.println("arr1.sort(Comparator.naturalOrder()): " + arr1);
        // сдвигаем элементы на указанное расстояние 
        // (по сути меняется те что в начале становятся в конце и наоборот)
        Collections.rotate(arr1, 3);  // [33, 88, 99, 6, 8, 13]
        System.out.println("Collections.rotate(arr1, 2): " + arr1);
        // свапаем меняем местами первый элемент с последним 
        Collections.swap(arr1, 0, 5); // [13, 88, 99, 6, 8, 33]
        System.out.println("Collections.swap(arr1, 0, 6): " + arr1);

        arr1.sort(null);
        System.out.println("arr1.sort(null): " + arr1);

        
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Collections.addAll(arr, 4, 5, 3, 2, 6, 1);
        Collections.sort(arr, (x, y) -> {
            return x.compareTo(y);
        });
        System.out.println(" (x, y) -> {\n" +
"            return x.compareTo(y): "+arr.toString());   // [1, 2, 3, 4, 5, 6] 
        Collections.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                return y.compareTo(x);
            }
        });
        System.out.println("new Comparator<Integer>() {: "+arr.toString());   // [6, 5, 4, 3, 2, 1]
    }

    public void showCRUD() {
        List arr1 = new ArrayList<Integer>();
        Collections.addAll(arr1, 9, 5, 1, 0, 777);

        List arr2 = new ArrayList<Integer>();
        // добавляем значения
        Collections.addAll(arr2, 33, 13, 8, 6);
        System.out.println(" Collections.addAll"
                + arr2.toString());  // [33, 13, 8, 6]

        // сеттим заменяем значение по индексу на другое
        arr2.set(0, 3);
        System.out.println("arr2.set(0, 3)"
                + arr2.toString());  // [3, 13, 8, 6]

        // копируем элементы из одного списка в начало другого
        // ПРи этом все значения вначале списка заменяются
        // исходный список должен содержать, такое же кол-во элементов или большее
        Collections.copy(arr1, arr2); // копируем arr2 в arr1
        System.out.println("Collections.copy(arr1, arr2): "
                + arr1.toString());  // [3, 13, 8, 6, 777]

        // получаем по индексу
        System.out.println("arr2.get(1) get по индексу: "
                + arr2.get(1));  // 13 
        // удаляем значение по индексу
        arr2.remove(3); // вернет true
        System.out.println("arr2.remove(3) по индексу: "
                + arr2.toString());  // [3, 13, 8]

        // НЕ РАБОТАЕТ removeIf 
        // удаляем значение в случае если в результате условия с этим
        // значением вернется true
        // System.out.println( arr2.removeIf(elem -> elem < 4));
        // удаляем по значению
        arr2.remove(new Integer(13));
        System.out.println("arr2.remove(3) по индексу: " + arr2); // [3, 8]

        // создаем список arr3 и удаляем из него все элементы
        // которые совпадают с элементами в arr2
        List arr3 = new ArrayList<>();
        Collections.addAll(arr3, 777, 3, 333, 777, 8, 88, 3, 8);
        // [777, 3, 333, 777, 8, 88, 3, 8]
        System.out.println("Collections.addAll.. arr3: " + arr3);
        arr3.removeAll(arr2);  // вернет true
        System.out.println("arr3.removeAll(arr2).. удаляем 3 и 8 из arr3: "
                + arr3);

        // удаляем все элементы из arr3 которые не совпали 
        // со списком arr4
        List arr4 = new ArrayList<>();
        Collections.addAll(arr4, 777, 88);
        arr3.retainAll(arr4);
        System.out.println("arr3.retainAll(arr4) все кроме 777 и 88 arr3:  " + arr3);

        // Удаляем с помощью итератора
        Iterator it = arr3.iterator();
        // Возвращает следующий объект и перемещает итератор
        System.out.println("it.next(): " + it.next());
        it.remove(); // даляет элемент, расположенный слева (текущий) от указателя.
        System.out.println("it.remove() _ arr3:  " + arr3);

    }

    public void showCreate() {
        // 1й способ напонения списка
        List arr1 = new ArrayList<>();
        System.out.println(arr1.size()); // 0
        System.out.println("список пуст: " + arr1.isEmpty()); // true

        arr1.add(0, "one");
        arr1.add(1, "two");
        arr1.add(2, "tree");

        System.out.println(arr1.toString());  // [one, two, tree]
        System.out.println(arr1.get(2)); // tree

        // 2ой способ наполнения списка с помощью цикла
        for (int i = 0; i < 6; i++) {
            arr1.add(i);
        }
        System.out.println(arr1.size());  // размер списка 9 элементов
        System.out.println(arr1.toString());  // [one, two, tree, 0, 1, 2, 3, 4, 5]

        // 3ий способ напонения списка с помощью другого списка
        List arr2 = new ArrayList<>();
        // добавляет элементы из другой коллекции начиная с 0левого индекса
        arr2.addAll(0, arr1);
        System.out.println(arr1.size());  // 9

        arr2.subList(0, 3).clear(); // удаляем по инексу от 0 до 2
        System.out.println(arr2.toString());  // [0, 1, 2, 3, 4, 5]

        // 4ый способ наполнения списка
        Collections.addAll(arr2, 999, 333, 888);
        System.out.println(arr2.toString());  // [four, 13, 8, 7, 4, 5, 999, 333, 888] 

        // 5ый способ наполнения списка одинаковыми значениям
        List arr3 = new ArrayList<>();
        Collections.addAll(arr3, 999, 333, 888);
        Collections.fill(arr3, 8);
        System.out.println("fill: " + arr3);

        // 6ой способ наполения списка одинаковыми значениями
        // 6 элементов значеним 888
        List arr4 = new ArrayList<>(Collections.nCopies(6, 888));
        System.out.println(arr4.toString());  // [888, 888, 888, 888, 888, 888]

        // Создание списка из массива
        Integer[] arrInt = {1, 2, 3};
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Collections.addAll(arr, arrInt);
        Collections.addAll(arr, 4, 5, 6);
        System.out.println("Collections.addAll(arr, arrInt) _ arr:" + arr.toString()); // [1, 2, 3, 4, 5, 6]
    }
}
