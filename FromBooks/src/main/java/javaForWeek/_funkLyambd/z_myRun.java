/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaForWeek._funkLyambd;

/**
 *
 * @author MartyMcAir
 */
public class z_myRun {
    public static void main(String[] args){
        // Объявляем интерфейсные переменные
        z_intrfTwoNum mult, divis, summ, mix;
        
        // в передаваемой лямбде описваем то, что хотим сделать с аргументами
        mult = (int a, int b)->{return a*b;};
        divis = (int a, int b)->{return a/b;};
        summ = (int a, int b)->{return a+b;};
        mix = (int a, int b)->{int res= a+=a; return (res*b)-3;};
        
        // отправляем значения аргументов
        // и выводим результаты, через default методы интерфейса
        mult.showRes(30, 10);
        divis.showRes(30, 10);
        summ.showRes(30, 10);
     
        // а можно просто результат получить назад,  
        // через абстрактный метод и манипулировать им как необходимо
        // Out: 3+3=6*10=60-3=57
        System.out.println("Возвращенные данные: "+mix.calc(3, 10));
    }
}
