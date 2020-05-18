package logging;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

public class Log4jExample {
    private static final Logger logger = LoggerFactory.getLogger(Log4jExample.class);

    public static void main(String[] args) {

        logger.error("Это сообщение ошибки");
        System.out.println("zzz");
    }

    public void testMethod() {

    }

}
