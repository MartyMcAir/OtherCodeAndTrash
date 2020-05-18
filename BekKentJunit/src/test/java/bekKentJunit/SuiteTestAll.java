package bekKentJunit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// Запускаем все тесты всех тестовых классов перечисленных через запятую..
@RunWith(Suite.class)
@Suite.SuiteClasses({DollarTest.class, FrancTest.class, MoneyTest.class})
public class SuiteTestAll {
    @Test
    public void test() {

    }
}
