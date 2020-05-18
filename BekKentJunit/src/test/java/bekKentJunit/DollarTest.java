package bekKentJunit;

import org.junit.Assert;
import org.junit.Test;

public class DollarTest {
    @Test
    public void testMultiplication() { // проверка корректности умножения
        Dollar five = new Dollar(5);
        Assert.assertEquals(10, five.times(2).amount);
    }

    @Test
    public void testEquals2() { // проверка корректности сравнения _ нового объекта с перемноженным
        Dollar five = new Dollar(5);
        Assert.assertEquals(new Dollar(15), five.times(3));
    }

    @Test
    public void testEquals() { // проверка корректности сравнения
        Assert.assertFalse(new Dollar(15).equals(new Dollar(6)));
    }

}
