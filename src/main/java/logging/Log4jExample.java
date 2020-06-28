package logging;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

public class Log4jExample {
    // Error IllegalAccessError: class logging.Log4jExample (in unnamed module @0x380fb434)
    private static final Logger logger = LoggerFactory.getLogger(Log4jExample.class);

    public static void main(String[] args) {

//        LogManager logManager = LogManager.getLogManager();
//        logManager.addLogger(logger);


        logger.error("Это сообщение ошибки");
        System.out.println("zzz");
    }

    public void testMethod() {

    }

}
