/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._LyambdaIntrf3;

import java.util.Random;
import java.util.function.*;

/**
 *
 * @author MartyMcAir
 */
public class FunctionsIntrf {
    public static void main(String[] args) {
        System.out.print("Function<T, R>: ");
        runFunc(n -> n * 2, 10); // 20

        System.out.print("\nBiFunction<T, U, R>: ");
        runBiFunc((a, b) -> a + b, 10, 20); // 30

        System.out.print("\nPredicate<T>: ");
        runPredic(n -> n != 0, 10); // true
        runPredic(n -> n != 0, 0); // false

        System.out.print("\nBiPredicate<T, U>: ");
        runBiPredic((a, b) -> a == b, 10, 10); // true
        runBiPredic((a, b) -> a == b, 10, 20); // false

        System.out.print("\nConsumer<T>: ");
        runConsum((obj) -> System.out.println(obj), 10); // 10
        runConsum((obj) -> System.out.println(obj), 50); // 50

        System.out.print("\nBiConsumer<T, U>: ");
        runBiConsum((a, b) -> System.out.println(a + b), 10, 15); // 25

        System.out.print("\nSupplier<T>: ");
        runSuppl(() -> {
            Random r = new Random();
            return r.nextInt(101);
        }); // случайное число в диопазоне до 101
    }

    public static void runFunc(Function<Integer, Integer> f, int x) {
        System.out.println(f.apply(x));
    }

    public static void runBiFunc(BiFunction<Integer, Integer, Integer> f, int x, int y) {
        System.out.println(f.apply(x, y));
    }

    public static void runPredic(Predicate<Integer> f, int x) {
        System.out.println(f.test(x));
    }

    public static void runBiPredic(BiPredicate<Integer, Integer> f, int x, int y) {
        System.out.println(f.test(x, y));
    }

    public static void runConsum(Consumer<Object> f, Object obj) {
        f.accept(obj);
    }

    public static void runBiConsum(BiConsumer<Integer, Integer> f, int x, int y) {
        f.accept(x, y);
    }

    public static void runSuppl(Supplier<Integer> f) {
        System.out.println(f.get());
    }
}
