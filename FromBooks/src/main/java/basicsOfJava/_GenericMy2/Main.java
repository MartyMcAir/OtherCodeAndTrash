/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._GenericMy2;

/**
 *
 * @author MartyMcAir
 */
public class Main {
    public static void main(String[] args){
        GenericBox<Integer> gb1 = new GenericBox();
        GenericBox<Double> gb2 = new GenericBox();
        GenericBox<String> gb3 = new GenericBox();
        
        gb1.setObj(333);
        gb2.setObj(13.18);
        gb3.setObj("строка-объект");
        
        showIntAndBase(gb1); // gb3 не принимает работает ограничение
        showNumbeOnly(gb2); // gb3 не принимает работает ограничение
        showVariable(gb3);  // принимает любой тип
        
        
        // Пример использования наследуемых обобщенных классов
        GenericBox<String> gbx1 = new GenericBox("строка1");
        GenericChild1<Integer, String> gChild1 = new GenericChild1(333, "строка2");
        
        gbx1.showObj();  // ваш объект: строка1
        gChild1.showObj(); // переопределенный метод из GenericChild1 и его B объект:  строка2
        gChild1.callBackForSuperClass(); // ваш объект: 333
        
        // Пример наследования и использования обобщенного класса обычным классом
        System.out.println();
        Child2ForGeneric<String> child2 = new Child2ForGeneric("строка3");
        child2.setStr("строка4");
        child2.showObj(); // строка4
        child2.callBackForSuperClass(); // строка3
    }
    
    // Класс Number и производные классы (т.е. Number и Object)
    public static void showIntAndBase(GenericBox<? super Integer> obj){
        System.out.println("Number Only объект: "+obj.getObj());
    }
    // Класс Number и производные классы
    public static void showNumbeOnly(GenericBox<? extends Number> obj){
        System.out.println("Number Only объект: "+obj.getObj());
    }
    
    // Любые типы
    public static void showVariable(GenericBox<?> obj){
        System.out.println("любой объект получен: "+obj.getObj());
    }
    
    // Пример методов способных обрабатывать случайное кол-во случайных объектов
    public static <T> void showVar(T obj){
    }
    public static void showVar(Object... a){
    }
    public static void showVar(int... a){
    }
    public static <T extends Integer> void showVar(T... obj){
    }
}
