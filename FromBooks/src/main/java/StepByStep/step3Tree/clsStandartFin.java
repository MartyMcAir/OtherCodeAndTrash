/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepByStep.step3Tree;

import java.util.Random;
import java.util.function.*;

/**
 *
 * @author MartyMcAir
 */
public class clsStandartFin {

    public static void main(String[] args) {
        clsStandartFin cls = new clsStandartFin();
        // манипуляция с одним числом
        cls.runFunction((n) -> n * 2, 10);
        // манипуляция с 2 числами
        cls.runBiFunction((a, b) -> a + b, 10, 20);

        // булевое значение 1го выражения
        cls.runPredicate((n) -> n != 0, 10);
        // булевое значение 2x аргументов
        cls.runBiPredicate((a, b) -> a == b, 10, 20);

        // вывод объекта в консоль
        cls.runConsumer((obj) -> System.out.println(obj), 999);
        // вывод 2x объеков в консоль
        cls.runBiConsumer((a, b) -> System.out.println("a: "+a+", b: "+b+" _ a*b="
                +(a * b)), 3, 6);

        // return
        cls.runSupplier(()->{ Random rnd = new Random();
            return rnd.nextInt();
        });
    }

    void runFunction(Function<Integer, Integer> f, int a) {
        System.out.println("\nFunction<Integer, Integer> f, int a: " + a
                + ", f.apply(a): " + f.apply(a));
    }

    void runBiFunction(BiFunction<Integer, Integer, Integer> f, int a, int b) {
        System.out.println("BiFunction<Integer, Integer, Integer> f, int a, in b: "
                + a + ", b: " + b + ", f.apply(a): " + f.apply(a, b));
    }

    void runPredicate(Predicate<Integer> f, int a) {
        System.out.println("\nPredicate<Integer> f, int a: " + a
                + ", f.test(a): " + f.test(a));
    }

    void runBiPredicate(BiPredicate<Integer, Integer> f, int a, int b) {
        System.out.println("BiPredicate<Integer, Integer> f, int a, int b: " + a
                + ", b: " + b + ", f.test(a): " + f.test(a, b));
    }

    void runConsumer(Consumer<Object> f, Object obj) {
        System.out.print("\nConsumer<Object> f, Object obj: " + obj.toString()
                + ", f.accept(obj): ");
        f.accept(obj);
    }

    void runBiConsumer(BiConsumer<Integer, Integer> f, int a, int b) {
        System.out.print("BiConsumer<Integer, Integer> f, int a, int b: " + a
                + ", b: " + b + "f.accept(obj): ");
        f.accept(a, b);
    }
    
    void runSupplier(Supplier<Integer> f){
        System.out.println("\nf.get(): "+f.get());
    }
}
