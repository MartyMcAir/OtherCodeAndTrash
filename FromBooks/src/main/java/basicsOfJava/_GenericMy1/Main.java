/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._GenericMy1;

import java.util.Date;

/**
 *
 * @author MartyMcAir
 */
public class Main {

    public static void main(String[] args) {
        // run2GenericType(); // Пример использования одновременно 2х типов в одном обобщенном классе
        // runGenericNumberOnly(); // Пример Огранич обобщ класса 1им общим класом для Integer & Double
        // runGenericOnlyInterf(); // Пример огранич обобщ класса 2мя интерфейсами

        // Пример использования обобщенных методов
        // Вызван обобщен статич метод, получивш в каче объекта: объект-строка
        Main.showGenericStatMethod("объект-строка");
        Main.showGenericStatMethod(388);   // 388 

        System.out.println("\nВызов обобщенного не статического метода: ");
        Main m = new Main();
        m.showGenericMethod("строка-объект2"); // строка-объект2
        m.showGenericMethod(888);  // 888

        System.out.println("\nВызов обобщенного метода с 2мя параметрами: ");
        // Пример обобщенного метода с несколькими обобщенными типами
        Main.showGeneric3Method("строка-объект3", 333);

        // пример ограничения метода Number классом
        // m.showGenerNumberOnly("text"); // Ошибка работает ограничение Number Only!
        m.showGenerNumberOnly(911);
        m.showGenerNumberOnly(13.23);

        // пример получения и возврата одного и того же произвольного объекта
        System.out.println("\nвернувшийся объект: " + m.getTobj("объект-строка4"));
    }

    public <T> T getTobj(T obj) {
        // пример получения и возврата одного и того же произвольного объекта
        return obj;
    }

    public <T extends Number> void showGenerNumberOnly(T obj) {
        // пример ограничения метода Number классом и 
        // т.е. классами Integer и Double
        System.out.println("ваш объект Number Only: ");
    }

    public void showGenericM4(
            GenericA<Integer, Double> obj, int a, double b) {
        // Пример отправки и получения объекта обобщенного класса
        obj = new GenericA();
        obj.setObj(a);
        obj.setobj1(b);
        System.out.println("obj: " + obj.getObj() + ", obj1: " + obj.getobj1());
    }

    public static <T, U> void showGeneric3Method(T obj1, U obj2) {
        // Пример обобщенного метода с несколькими обобщенными типами
        System.out.println("первый объект обобщенного метода: " + obj1);
        System.out.println("второй объект: " + obj2);
    }

    public <T> void showGenericMethod(T obj) {
        System.out.println("Вызван обобщенный метод, "
                + "получивший в качестве объекта: " + obj);
    }

    public static <T> void showGenericStatMethod(T obj) {
        System.out.println("Вызван обобщенный статический метод, "
                + "получивший в качестве объекта: " + obj);
    }

    public static void runGenericOnlyInterf() {
        // Пример ограничения обобщенного класса двумя интерфейсами
        // И вызов их методов

        // Ошибка ограничение работает! обобщенный класс принимает в качесвте типа
        // Только классы реализовавшие интерфейсы, которыми он ограничен
        // GenericCinterfOnly<Integer> giA1 = new GenericCinterfOnly(); // Ошибка
        //GenericCinterfOnly<Date> giA2 = new GenericCinterfOnly(); // Ошибка
        GenericCinterfOnly<clsImplAB> giA = new GenericCinterfOnly();
        giA.setObj(new clsImplAB());
        giA.callBackForInterf();
    }

    public static void runGenericNumberOnly() {
        // Пример Ограничения обобщенного класса одним общим класом для Integer & Double
        // Ошибка Date не входит в класс Number ограничение работает!
//        GenerBOnlyNumber<Date> gbo2 = new GenerBOnlyNumber(); 
        GenerBOnlyNumber<Integer> gbo1 = new GenerBOnlyNumber();
        GenerBOnlyNumber<Double> gbo2 = new GenerBOnlyNumber();
        gbo1.setObj(333);
        gbo2.setObj(13.33);

        gbo1.showObj(); // ваш объект ограниченный классом Number: 333
        gbo2.showObj(); // ваш объект ограниченный классом Number: 13.33
    }

    public static void run2GenericType() {
        // Пример использования одновременно 2х типов в одном обобщенном классе 
        GenericA<String, Integer> gn1 = new GenericA();
        gn1.setObj("строка");
        gn1.setobj1(938);
        gn1.showObj();   // ваш объект: строка
        gn1.showObj1(); // ваш объект: 938

        GenericA<Date, String> gn2 = new GenericA();
        gn2.setObj(new Date());
        gn2.showObj();  // ваш объект: Sun Feb 10 18:12:34 MSK 2019
        System.out.println("результат getTime(): " + gn2.getObj().getTime()); // 1549811754141
    }

}
