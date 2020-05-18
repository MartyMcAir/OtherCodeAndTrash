package zzz_TMP;

import java.util.concurrent.RecursiveTask;

public class RecursiveCalc extends RecursiveTask<Double> {
    private static final int SEQUENTIAL_THRESHOLD = 50_000;
    private final int[] array;
    private final int start;
    private final int end;

    public RecursiveCalc(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    protected Double compute() {
        if (end - start <= SEQUENTIAL_THRESHOLD) {
            return Commons.calculate(array, start, end);
        } else {
            int mid = start + (end - start) / 2;
            RecursiveCalc left = new RecursiveCalc(array, start, mid);
            RecursiveCalc right = new RecursiveCalc(array, mid, end);
            invokeAll(left, right);
            return left.join() + right.join();
        }
    }

}
