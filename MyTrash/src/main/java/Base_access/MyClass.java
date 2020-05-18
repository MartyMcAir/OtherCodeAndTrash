/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base_access;

/**
 *
 * @author MartyMcAir
 */
public class MyClass extends SuperClass {

    public static void main(String[] args) {
        // Создаем объектную перменную mcls 
        // и инициализируем её создавая объект класса MyClass() через ключ слово new
        MyClass mcls = new MyClass();
        mcls.showSomething();
        System.out.println(mcls.simpleStr); // вызываем обычно поле класса MyClass
        mcls.showSuperClassMethod();

        // вызываем статический метод напрямую (без создания экземпляра класса)
        MyClass.showSomething("Cтатический");
        System.out.println(MyClass.staticStr + "\n"); // вызываем статическое поле класса MyClass

        // Восходящее приведение _ экземпляра под класс к его супер классус
        // Создаем объектную перменную supcls
        // и инициализируем её создавая объект класса MyClass() через ключ слово new
        SuperClass supcls = new MyClass();
        supcls.showSuper();
        System.out.println(supcls.simpleSuper); // вызываем обычно поле класса SuperClass
    }
    public String simpleStr = "Обычное поле класса MyClass";
    public static String staticStr = "Статическое поле класса MyClass";

    public void showSomething() {
        System.out.println("Метод showSomething() класса MyClass");
    }

    public static void showSomething(String txt) {
        System.out.println(txt + " Метод showSomething() класса MyClass ");
    }

    public void showSuperClassMethod() {
        super.showSuperForMyClass();
    }
}
