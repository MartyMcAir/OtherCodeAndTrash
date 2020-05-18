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
public class clsSet {
    public void listTreeSet() {
        // пустое множество со способом сравнения по умолчанию
        Set arr1 = new TreeSet<>();
        Collections.addAll(arr1, 99, 33, 666);
        System.out.println("Set arr1:  " + arr1); // [33, 99, 666]

        // позволяет указать способ сравнения
        Set arr2 = new TreeSet<>(Collections.reverseOrder());
        Collections.addAll(arr2, 99, 33, 666);
        System.out.println("arr2:  " + arr2); // [666, 99, 33]

        //  создает объект на основе другой коллекции, 
        // используя способ сравнения по умолчанию
        List lArr1 = new ArrayList<>();
        Collections.addAll(lArr1, 888, 333, 13, 333, 13, 99, 666, 555, 3, 8, 6);
        System.out.println("ArrayList<>() _ lArr1: " + lArr1);
        SortedSet arr3 = new TreeSet<>(lArr1);
        System.out.println("\nSortedSet\n _ TreeSet<>(lArr1) _ arr3: " + arr3);

        System.out.println("arr3.first(): " + arr3.first());
        System.out.println("arr3.last(): " + arr3.last());

        // возвращает срез от указанного значения (не включая элемент 
        // с этим значением) до начала набора. Обратите внимание на то, 
        // что все действия с этим набором повлияют на исходный набор.
        // (но это влияние заметно только после применения clear() )
        SortedSet ssArr = arr3.headSet(333);
        System.out.println("arr3.headSet(333) _ ssArr: " + ssArr);
        ssArr.clear();
        System.out.println("ssArr.clear() _ arr3: " + arr3);

        // — возвращает срез от указанного значения 
        // (включая элемент с этим значением) до конца набора.
        SortedSet ssArr2 = arr3.tailSet(555);
        System.out.println("arr3.tailSet(555) _ ssArr2: " + ssArr2);
        ssArr2.clear();
        System.out.println("ssArr2.clear() _ arr3: " + arr3);

        // возвращает срез от значения fromElement (включая элемент 
        // с этим значением) до значения toElement (не включая элемент 
        // с этим значением). 
        TreeSet arr4 = new TreeSet<>();
        Collections.addAll(arr4, 8, 113, 88, 99, 34, 666, 333);
        System.out.println("\nTreeSet arr4 = new TreeSet<>(): \narr4: " + arr4);
        SortedSet ssArr3 = arr4.subSet(34, 333);
        System.out.println("ssArr3: " + ssArr3);

        TreeSet arr5 = new TreeSet<>();
        Collections.addAll(arr5, 113, 6, 9, 13, 16, 33, 36, 39, 3);
        System.out.println("arr5: " + arr5);
        //  удаляет первый элемент и возвращает его.
        System.out.println("arr5.pollFirst(): " + arr5.pollFirst());
        System.out.println("arr5.pollLast(): " + arr5.pollLast());
        System.out.println("arr5: " + arr5);
        //  возвращает элемент с бо?льшим значением, чем указано 
        // (если сорти ровка в обратном порядке, то, наоборот, с меньшим значением)
        System.out.println("arr5.higher(9): " + arr5.higher(9));
        // возвращает элемент с бо?льшим или равным значением, чем указано
        System.out.println("arr5.ceiling(16): " + arr5.ceiling(16));
        //  возвращает элемент с меньшим значением, чем указано
        System.out.println("arr5.lower(39): " + arr5.lower(39));
        // возвращает элемент с меньшим или равным значением, чем указано
        System.out.println("arr5.floor(9): " + arr5.floor(9));
        System.out.println("arr5: " + arr5);

        //  возвращает срез от указанного значения, включая элемент с этим значением
        // (inclusive = true) или не включая его (inclusive = false)
        // Обратите внимание на то, что все действия с этим набором повлияют на исходный набор. 
        System.out.println("\nNavigableSet:");
        NavigableSet nvgArr1 = arr5.headSet(36, false);
        System.out.println("arr5.headSet(36, false) _ nvgArr1: " + nvgArr1);
        //  возвращает срез от указанного значения
        NavigableSet nvgArr2 = arr5.tailSet(16, false);
        System.out.println("arr5.tailSet(16, false) _ nvgArr2: " + nvgArr2);
        //  возвращает срез от значения fromElement, включая элемент с этим значением
        // до значения toElement,
        NavigableSet nvgArr3 = arr5.subSet(9, true, 36, true);
        System.out.println("subSet(9, true, 36, true) _ nvgArr3: " + nvgArr3);

        //  возвращает набор, отсортированный в обратном порядке. 
        NavigableSet nvgArr4 = arr5.descendingSet();
        System.out.println("arr5.descendingSet() _ nvgArr4: " + nvgArr4);
        // возвращает итератор, с помощью которого можно обойти набор в обратном порядке. 
        Iterator it = arr5.descendingIterator(); // [39, 36, 33, 16, 13, 9, 6]
//        Iterator it = arr5.iterator(); // 6; 9; 13; 16; 33; 36; 39
        while (it.hasNext()) { // вернет true если есть след элемент
            System.out.print(it.next() + "; ");
        }
    }

    public void listSet() {
        // HashSet не гарантирует никакого порядка получения элементов
        Set arr1 = new HashSet<>();
        Collections.addAll(arr1, 33, 3, 18);
        // всеравно какой-то свой порядок следования элементов
//        arr1.add(33); arr1.add(3); arr1.add(18); 
        System.out.println("arr1: " + arr1); // [33, 18, 3]

        Set arr2 = new HashSet<>(arr1); // [33, 18, 3]
        System.out.println("Set arr2 = new HashSet<>(arr1) _ arr2: " + arr2);
        Collections.addAll(arr2, 8, 88, 9, 13); // [33, 18, 3, 8, 88, 9, 13]
        System.out.println("Collections.addAll _ arr2: " + arr2);

        // разница множеств _ удалет из arr2 все элементы совпавшие с arr1
        System.out.println("arr2.removeAll(arr1): " + arr2.removeAll(arr1));
        System.out.println("arr2: " + arr2);

        // пересечение множеств _ переносит из двух множеств сходные значения
        // в третье множество
        Set<Integer> set1 = new HashSet<Integer>();
        Collections.addAll(set1, 1, 2, 3);
        System.out.println("set1: " + set1);
        Set<Integer> set2 = new HashSet<Integer>();
        Collections.addAll(set2, 1, 2, 4);
        System.out.println("set2: " + set2);
        Set<Integer> set3 = new HashSet<Integer>(set1);
        set3.retainAll(set2);
        System.out.println("set3.retainAll(set2) _ set3: " + set3);
        // Остальные методы очень похожи на методы из ArrayList<>()

        //  LinkedHashSet<>() — запоминает порядок вставки элементов.
        Set lhsArr1 = new LinkedHashSet<>();
        Collections.addAll(lhsArr1, 33, 3, 18);
        System.out.println("\nLinkedHashSet: \nlhsArr1: " + lhsArr1); // [33, 18, 3]

        // указать начальную емкость множества, а третий — дополнительно 
        // коэффициент заполнения (вещественное число от 0.0 до 1.0), 
        // при достижении которого произойдет расширение множества: 
        Set lhsArr2 = new LinkedHashSet<>(10, 0.75f);
        // Множество не может содержать одинаковых значений элементов
//        Collections.addAll(lhsArr2, 88, 99, 33, 33, 99, 88); // 88 99 33
        Collections.addAll(lhsArr2, 88, 99, 33);
        System.out.println("lhsArr2: " + lhsArr2);

        //  создает множество на основе другой коллекции. 
        // В итоге мы получим только уникальные элементы коллекции: 
        List lArr = new ArrayList<>();
        Collections.addAll(lArr, 3, 6, 9, 9, 6, 3);
        System.out.println("ArrayList<>() _ lArr: " + lArr);
        Set lhsArr3 = new LinkedHashSet<>(lArr);
        System.out.println("LinkedHashSet<>(lArr) _ lhsArr3: " + lhsArr3); // [3, 6, 9]
    }
}
