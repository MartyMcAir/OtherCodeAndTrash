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
@FunctionalInterface
public interface z_intrfTwoNum {
    // используем метод по умолчанию, для предварительной 
    // обработки или маниуляции с данными
    default void showRes(int a, int b){
        System.out.println("Result: "+calc(a, b));
    }
    // Абстрактный метод, возвращает результат
    int calc(int a, int b);
}
