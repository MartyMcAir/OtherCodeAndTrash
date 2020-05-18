package zzz_TMP;

import java.util.concurrent.Callable;

public class PartialCalc implements Callable<Double> {
    private final int[] array;
    private final int start;
    private final int end;

    public PartialCalc(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public Double call() throws Exception {
        return Commons.calculate(array, start, end);
    }
}
