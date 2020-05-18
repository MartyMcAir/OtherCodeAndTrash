package alishevJunit;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class Vector2DTest_V2 {
    private final double deltaEPS = 1e-9;
    //    private alishevJunit.Vector2D v1;
    private static Vector2D v1; // static для @BeforeClass

    // и для каждого метода теста - создается отдельный тестовый объект
//    @Before  // будет вызван перед каждым запуском любого теста, текущего класса
    @BeforeClass // будет создавать alishevJunit.Vector2D - только один раз общий объект, для всех методов-тестов
    public void createNewVector() {
        v1 = new Vector2D();
    }

    @Test
    public void newVectorShouldHaveZeroLength() {
        Assert.assertEquals(0, v1.length(), deltaEPS);
    }

    // Пример того как не надо делать (антипаттерн), объединять тесты в один метод
    @Test // Commons Method for Simple tests _ this bad Way
    public void newVectorShouldHaveZeroXAndZeroY_CommonsMethod() {
        Assert.assertEquals(0, v1.getY(), deltaEPS);
        // если первый тест на getY() выкинет ошибку то второй не запустится
        Assert.assertEquals(0, v1.getX(), deltaEPS);
    }

    @Test
    public void newVectorShouldHaveZeroX() {
        Assert.assertEquals(0, v1.getX(), deltaEPS);
    }

    @Test
    public void newVectorShouldHaveZeroY() {
        Assert.assertEquals(0, v1.getY(), deltaEPS);
    }
}
