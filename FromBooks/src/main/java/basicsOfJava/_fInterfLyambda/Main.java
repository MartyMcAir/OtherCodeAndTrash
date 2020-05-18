/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._fInterfLyambda;

/**
 *
 * @author MartyMcAir
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
            // 0й обычный способ через экземпляр класса реализующего интерфейс
            // но он же найболее гибкий что четод может быть оч. развернутым
            // так же можно использовать анонимный класс вместо него
//        intrfDo itd = new clsImpl();
//        clsSetter cls = new clsSetter(itd);

        // 1й способ
        intrfDo itd2 = ()->System.out.println("Лямбда вместо целого класса!");
        clsSetter cls2 = new clsSetter( itd2 );
        
        // 2й способ более краткий
        clsSetter cls3 = new clsSetter(
                ()->System.out.println("Лямбда вместо интерф переменной и т.д."));
        
        cls2.callback();   // Лямбда вместо целого класса!
        cls3.callback();   // // Лямбда вместо интерф переменной и т.д.
        
//        //3й способ
        clsImpl impl2 = new clsImpl();
        clsSetter cls4 = new clsSetter( impl2::showOth );
        cls4.callback();   // Другой метод _ impl2::showOth
    }
}
