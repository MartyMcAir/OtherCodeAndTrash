package sitepoint_com;

import java.util.stream.IntStream;

// Java 8 brought default methods to the table, so that interfaces could be evolved. This went pretty well
// but there was one unfortunate detail: Reusing code between default methods was unpleasant.
public interface PrivateInterfaceMethods {
    default boolean evenSum(int... numbers) {
        return sum(numbers) % 2 == 0;
    }

    default boolean oddSum(int... numbers) {
        return sum(numbers) % 2 == 1;
    }

    // we don't want this to be public;
    // but how else do we resuse?
    default int sum(int[] numbers) {
        return IntStream.of(numbers).sum();
    }

    // In Java 9 we can simply have a private interface method:
    private int sum2(int[] numbers) {
        return IntStream.of(numbers).sum();
    }
}