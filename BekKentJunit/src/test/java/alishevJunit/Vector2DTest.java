package alishevJunit;

import org.junit.Assert;
import org.junit.Test;

public class Vector2DTest { // запустить все тесты _ двойная стрелка слева
    @Test
    public void newVectorShouldHaveZeroLength() { // запустить именно этот тест стрелка слева
        Vector2D v1 = new Vector2D(); // action действие
        // 0-ожидаемое, v1.length()-фактический результ, 1e-9 точноть проверки при сравнении ожидаемого с фактическим
        // 1e-9 - число с нацчной точностью _ т.к. юзаем вещественные числа double
        Assert.assertEquals(0, v1.length(), 1e-9); // assertion проверка

        // при провале теста выведет
        // java.lang.AssertionError:
        //Expected :0.0 - ожидалось получить
        //Actual   :1.0 - фактический вывод от тестируемого..
    }

    @Test
    public void newVectorShouldHaveZeroX() {
        Vector2D v1 = new Vector2D();

        Assert.assertEquals(0, v1.getX(), 1e-9);
    }

    @Test
    public void newVectorShouldHaveZeroY() {
        Vector2D v1 = new Vector2D();
        Assert.assertEquals(0, v1.getY(), 1e-9);

    }
}
