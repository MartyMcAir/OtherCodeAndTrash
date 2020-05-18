/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava.Collections;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author MartyMcAir
 */
public class Main {

    public static void main(String[] args) {
        // Списки
        clsList cls1 = new clsList();
        // cls1.showCreate();
        // cls1.showCRUD();
         cls1.showSortReverseShuffle();
        // cls1.showExm_sTrimToSize();
        // cls1.showMinMaxContain();
        // cls1.listLoops();
        // cls1.listVector();
        // cls1.listStack();

        // Очереди
        clsDeque cls2 = new clsDeque();
        // cls2.listArrayDeque();
        // cls2.listPriorityQueue();
        
        // Перебор элементов
        clsIterator cls3 = new clsIterator();
        // cls3.listIterator();
        // cls3.listEnumeration();
        
        // Множества
        clsSet cls4 = new clsSet();
        // cls4.listSet();
        // cls4.listTreeSet();
        
        // Словари ассоциативные массивы
        clsMap cls5 = new clsMap();
        // cls5.listHashMap(); 
        // cls5.listLinkedHashMap();
        // cls5.listProperties();
        // cls5.listTreeMap();
        
        
        clsCloneableComparable cls6 = new clsCloneableComparable();
        // listMehtodsComparator();
        // simpleComparable();
        //simpleClone();
    }
   
    
    
    public static void simpleClone(){
        CloneImplA obj1 = new CloneImplA(10);
        CloneImplA obj2 = obj1.clone();
        
        System.out.println("obj1.getD(): "+obj1.getD());
        System.out.println("obj2.getD(): "+obj2.getD());
        
        obj2.newDate(1245L);
        
        System.out.println("obj1.getD(): "+obj1.getD());
        // Thu Jan 01 03:00:01 MSK 1970
        System.out.println("obj2.getD(): "+obj2.getD()); 
    }
    
    public static void simpleComparable(){
        // значение 0 если объекты равны, положительное число если текущий 
        // объект больше other, и отрицательное число если текущий 
        // объект меньше other.
        CompImplA obj1 = new CompImplA(1, 1);
        CompImplA obj2 = new CompImplA(1, 1);
        CompImplA obj3 = new CompImplA(1, 2);
        CompImplA obj4 = new CompImplA(2, 1);
        
        System.out.println(obj1.compareTo(obj2)); // 0
        System.out.println(obj1.compareTo(obj3)); // 0
        System.out.println(obj1.compareTo(obj4)+"\n"); // -1
        
        System.out.println(obj3.compareTo(obj1)); // 0
        System.out.println(obj3.compareTo(obj4)+"\n"); // -1
        
        System.out.println(obj4.compareTo(obj1)); // 1
        System.out.println(obj4.compareTo(obj3)+"\n"); // 1

        
        System.out.println("Сравнение с одним аргументом: "); 
        CompImplA obj5 = new CompImplA(1);
        CompImplA obj6 = new CompImplA(1);
        CompImplA obj7 = new CompImplA(2);
        CompImplA obj8 = new CompImplA(3);
        
        System.out.println(obj5.compareTo(obj6)); // 0
        System.out.println(obj5.compareTo(obj7)); // -1
        System.out.println(obj5.compareTo(obj8)+"\n"); // -1
        
        System.out.println(obj7.compareTo(obj5)); // 1
        System.out.println(obj7.compareTo(obj8)+"\n"); // -1
        
        System.out.println(obj8.compareTo(obj5)); // 1
        System.out.println(obj8.compareTo(obj7)+"\n"); // 1
    }
    
    public static void listMehtodsComparator(){
        ArrayList<CompImplA> arr1 = new ArrayList<CompImplA>();
        arr1.add(new CompImplA( 1, 3) );
        arr1.add(new CompImplA( 3, 1) );
        arr1.add(new CompImplA( 2, 4) );
        System.out.println("arr1: "+arr1); // [{1;3}, {3;1}, {2;4}]
        // сортировка по х
        arr1.sort(null);
        System.out.println("sort по X по возрастанию arr1: "+arr1); // [{1;3}, {2;4}, {3;1}]
        
        // сортировка по y
        arr1.sort(new Comparator<CompImplA>(){
            @Override
            public int compare(CompImplA a, CompImplA b){
                if(a.getY() > b.getY()) return 1;
                if(a.getY() < b.getY()) return -1;
                return 0;
            }
        });
        System.out.println("sort по Y по возрастанию arr1: "+arr1); // [{3;1}, {1;3}, {2;4}]
        
        // Сортировка по x по убыванию
        arr1.sort(new CompImplReverse() );
        System.out.println("sort по X по убыванию arr1: "+arr1);
        
        // Сортировка по y по убыванию
        // через лямбда выражение
        arr1.sort( (CompImplA a, CompImplA b)->{
            if(a.getY() > b.getY()) return -1;
            if(a.getY() < b.getY()) return 1;
            return 0;
        } );   // arr1: [{2;4}, {1;3}, {3;1}]
        System.out.println("sort по Y по убыванию через лямбду arr1: "+arr1);
    }
}
