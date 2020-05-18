package bekKentJunit;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MoneyTest {

    @Test
    public void equals() { // 5CHF != 5USD
        Money fiveBucks = new Dollar(5);
        Money fiveChf = new Franc(5);
        Assert.assertFalse(fiveBucks.equals(fiveChf));
    }

    @Test
    public void equals2() { // obj1 15$ = another obj2 (5*3) 15$
        Money fiveBucks = new Dollar(5);
        Assert.assertEquals(new Dollar(15), fiveBucks.times(3));
    }

    @Test
    public void equals3() { // теперь тож самое можно делать через фабричный метод получать валюту ии
        Money fiveBucks = Money.dollar(5);
//        Assert.assertEquals(new Dollar(15), fiveBucks.times(3));
        Assert.assertEquals(Money.dollar(15), fiveBucks.times(3));
    }

    @Test
    public void equals4() { // терь тип валюты определяет строка
        assertEquals("USD", Money.dollar(1).getCurrency());
    }

    @Test
    public void testDifferentClassEquality() {
        // стр 61 _ new Money() - юзает но класс Money abstract!
        // или вернули назад!?
//        assertTrue(Money.dollar(3).equals(new Dollar(3)));
        assertTrue(Money.dollar(3).equals(Money.dollar(3)));
    }

    @Test
    public void testSimpleAddition() {
        Money sum = Money.dollar(5).plus(Money.dollar(5));
        assertEquals(Money.dollar(10), sum);
    }

    @Test
    public void testSimpleAddition2() {
        Money sum = Money.dollar(5).plus(Money.dollar(5));
        assertEquals(Money.dollar(10), sum);
    }

}