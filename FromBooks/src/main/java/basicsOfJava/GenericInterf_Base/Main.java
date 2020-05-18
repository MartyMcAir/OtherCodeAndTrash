/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava.GenericInterf_Base;

import java.util.ArrayList;

/**
 *
 * @author MartyMcAir
 */
public class Main {

    public static void main(String[] args) {
//        runSimpleBoxObj();
        // Пример использования экземпляра класса реализующего обобщ интерфейс 
        clsImpl cls1 = new clsImpl();
        cls1.setObj(10);
        cls1.showIntrf1(333); // объект obj: 10 T t: 333
        cls1.showObj(); // 10

        // Пример использования экземпляра класса с обобщенным ограничением типом String
        System.out.println();
        clsImpl<String> cls2 = new clsImpl();
        cls2.setObj("строка1");
        cls2.showIntrf1("строка2"); // объект obj: строка1 T t: строка2
        cls2.showObj(); // строка1

        // Пример доступа к только методу обобщенного интерфейса через интерф переменную
        System.out.println();
        GenericIntrf1 intrf1 = new clsImpl();
        intrf1.showIntrf1("333");  // объект obj: null T t: 333
        // Ограничение обобщенного интерф в действии
        GenericIntrf1<String> intrf2 = new clsImpl();
        intrf2.showIntrf1("String Only!"); // объект obj: null T t: String Only!

        // Компилятор на выходе видит все обобщенные классы без обобщения
        // а просто приводит такие обобщенны классы интерф и методы
        // к тому типу что указано в <> 
        // и сравнение таких классов через imstanceof бесполезно
        System.out.println();
        clsImpl<Integer> cls3 = new clsImpl();
        clsImpl<Double> cls4 = new clsImpl();
        clsImpl<?> cls5 = new clsImpl();
        System.out.println(cls3.getClass().getName());
        System.out.println(cls4.getClass().getName());
        System.out.println(cls5.getClass().getName());

        // Нельзя создать массив объектов обобщенного типа
        //НАПИСАНО в учебнике, а на самом деле можно!
        // Ограничения только Integer
        GenericBox<Integer>[] arrObj = new GenericBox[3];
        arrObj[0] = new GenericBox<>();
        arrObj[1] = new GenericBox<>();
        arrObj[2] = new GenericBox<>();
        // arrObj[3]= new GenericBox<>(); // ошибка лишний элемент

        arrObj[0].setObj(333);
        arrObj[0].showObj(); // ваш объект: 333
        
        System.out.println();
        // Коллекция объектов обобщенного класса ограниченная типом Double
        ArrayList< GenericBox<Double> > arrGener = new ArrayList();
        GenericBox<Double> gbx1 = new GenericBox();
        GenericBox<Double> gbx2 = new GenericBox();
        arrGener.add(gbx1);
        arrGener.add(gbx2);
        arrGener.get(0).setObj(13.33);
        arrGener.get(0).showObj();   // ваш объект: 13.33
    }
    
        public static void runSimpleBoxObj(){
        Box bx = new Box();
        
        bx.setObj("Строка");
        bx.showObjType();  // String
        bx.showObj();   // ваш объект: Строка
        
        bx.setObj(999);
        bx.showObjType();  // Integer
        bx.showObj();  // ваш объект: 999
        
        bx.setObj(99.13);
        bx.showObjType();  // Double
        bx.showObj();  // ваш объект: 99.13
        
        bx.setObj(bx);
        bx.showObjType();  // тип вашего объекта: class GenericsTE.Box
        // _ (GenericsTE - это имя пакета
        bx.showObj();  // ваш объект: GenericsTE.Box@5d624da6
    }
}
