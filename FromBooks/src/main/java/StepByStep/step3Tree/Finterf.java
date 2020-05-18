/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepByStep.step3Tree;

/**
 *
 * @author MartyMcAir
 */
@FunctionalInterface 
interface Finterf {

    // абстрактный метод 
    // _ может быть перегружаемым, но тогда нельзя будет использовать
    // лямюда выражение применимо к интерфейсной переменной данного типа
    // абстракт метод "calc(n)" вызывается через метод по умолчанию
    double calc(int a, int b);
//    double calc(int a); 

    // метод по умолчанию 
    // _ может быть перегружаемым
    default void defshowRes(int a, int b) {
        System.out.println("Результат: " + calc(a, b));
    }

    default void defshowRes(int a) {
        System.out.println("Результат: " + calc(a, 3));
    }

    default void defshowRes(int a, int b, int c) {
        System.out.println("Результат: " + (calc(a, b) / c));
    }

}
