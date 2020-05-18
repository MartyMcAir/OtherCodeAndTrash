package alishevJunit;

import org.junit.Test;

public class MyMathTest {
    @Test(expected = ArithmeticException.class) // ожидаем выброса ArithmeticException от метода divide()
    public void zeroDenominationShouldThrowException() {
        MyMath.divide(1, 0);
    }
}
