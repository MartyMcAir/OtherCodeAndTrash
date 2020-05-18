package zzz_TMP;

import java.util.concurrent.*;

public class Commons {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] arr = Commons.prepareArray(); // 1.7896068191307428
//        System.out.println(sequential(arr)); // без парелеизма один поток _ // 1259ms

//        System.out.println(parallelInExecutorService(arr));  // 820ms _ 2 воркера _
        System.out.println(parallelInForkJoinPool(arr)); // 393ms _ создает сток потоков скок ядер
    }

    public static String parallelInForkJoinPool(int[] array) {
        ForkJoinPool pool = new ForkJoinPool();
        long start = System.currentTimeMillis();

        double sum = pool.invoke(new RecursiveCalc(array, 0, array.length));

        long end = System.currentTimeMillis();
        pool.shutdown();
        return "sum: " + sum + ", time: " + (end - start) + "ms.";
    }

    public static String parallelInExecutorService(int[] array) throws ExecutionException, InterruptedException {
        ExecutorService exevutor = Executors.newFixedThreadPool(2);
        long start = System.currentTimeMillis();
        Future<Double> future1 = exevutor.submit(new PartialCalc(array, 0, array.length / 2));
        Future<Double> future2 = exevutor.submit(new PartialCalc(array, array.length / 2, array.length));

        double sum = future1.get() + future2.get();

        long end = System.currentTimeMillis();
        exevutor.shutdown();
        return "sum: " + sum + ", time: " + (end - start) + "ms.";
    }

    public static String sequential(int[] array) {
        long start = System.currentTimeMillis();

        double sum = Commons.calculate(array);

        long end = System.currentTimeMillis();
        return "sum: " + sum + ", time: " + (end - start) + "ms.";
    }

    //////////
    public static int[] prepareArray() {
        int[] array = new int[9_000_000];
        for (int i = 0; i < array.length; ++i) {
            array[i] = i;
        }
        return array;
    }

    public static double calculate(int[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; ++i) {
            sum += function(array[i]);
        }
        return sum;
    }

    public static double calculate(int[] array, int start, int end) {
        double sum = 0;
        for (int i = start; i < end; ++i) {
            sum += function(array[i]);
        }
        return sum;
    }

    private static double function(int argument) {
        return Math.sin(argument);
    }
}
