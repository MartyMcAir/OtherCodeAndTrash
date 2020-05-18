package alishevJunit;

import org.junit.Test;

public class NetworkUtilsTest {
    @Test(timeout = 1000)
    public void getConnectionShouldReturnFasterThanOneSecond() {
        NetworkUtils.getConnection(); // ожидаем его выполнение менее чем за 1 сек.
    }

}
