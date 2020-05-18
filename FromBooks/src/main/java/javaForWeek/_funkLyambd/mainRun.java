/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaForWeek._funkLyambd;

import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author MartyMcAir
 */
public class mainRun {

    public static void main(String[] args) {
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
//        numbers.forEach((Integer value) -> System.out.println(value));
//        numbers.forEach(System.out::println);

//        int res1, res2, res3;
//        res1 = sumAll(numbers, n -> true);
//        res2 = sumAll(numbers, n -> n % 2 == 0);
//        res3 = sumAll(numbers, n -> n > 3);
//        
//        System.out.println(res1);
//        System.out.println(res2);
//        System.out.println(res3);
//        Runnable r = () -> System.out.println("hello world");
//        final AtomicInteger counter = new AtomicInteger(0);
//        Runnable rb = () -> counter.incrementAndGet();
//        Runnable runnable = () -> System.out.println("Я - лямбда!");
        
//        int a=3; int b = 4;
//        intrfSum ress = new intrfSum() {
//            @Override
//            public int summ(int a, int b) {
//                return a+b;
//            }
//         ;};
//        
//        intrfSum res = (int a, int b)->{ a+b;}
//        System.out.println(ress.summ(a, b));
        
        MyFunction Cube=(int n)->{return Math.pow(n, 3); }; // возведение в куб
        MyFunction mult=(int n)->{return n*5;};
        
        mult.doit(3);
        
        // Переопределяем меняем 5 на 10
        mult=n->n*10;
        mult.doit(6);
        
    }

    public static int sumAll(List<Integer> numbers, Predicate<Integer> p) {
        int total = 0;
        for (int number : numbers) {
            if (p.test(number)) {
                total += number;
            }
        }
        return total;
    }

    private static void doWork() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
