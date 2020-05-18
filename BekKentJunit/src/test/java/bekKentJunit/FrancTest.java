package bekKentJunit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FrancTest {

    @Test
    public void times() {
        Franc five = new Franc(5);
        assertEquals(new Franc(10), five.times(2));
    }

    @Test
    public void times2() {
        Franc five = new Franc(5);
//        assertEquals(new Franc(10), five.times(2)); // а в книге норм у Бэка Кента
        assertEquals(new Franc(15), five.times(3));
    }

    @Test
    public void equals() {
    }

}