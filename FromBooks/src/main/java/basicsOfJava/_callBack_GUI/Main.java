/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._callBack_GUI;

/**
 *
 * @author MartyMcAir
 */
public class Main {

    public static void main(String[] args) {
        SomeClass cls = new SomeClass();
        clsImpl impl = new clsImpl();
        
        clsImpl2 impl2 = new clsImpl2();

        // инициализируем колбек, передавая методу registerCallBack 
        // экземпляр класса clsImpl - реализующего интерфейс Callback
        // по сути сообщаем что будем использовать метод из этого класа
        cls.registerCallBack(impl);
        cls.doSomething();

        cls.registerCallBack(impl2);
        cls.doSomething();
    }
}
