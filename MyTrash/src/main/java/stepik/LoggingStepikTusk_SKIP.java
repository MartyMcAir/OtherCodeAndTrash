package stepik;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class LoggingStepikTusk_SKIP {
    // https://stepik.org/lesson/12774/step/8?unit=3122

    // Failed. Unexpected handlers found for org.stepic.java.logging.ClassA
    public static void main(String[] args) throws IOException {
        Logger loggerA = Logger.getLogger("org.stepic.java.logging.ClassA");
        loggerA.setLevel(Level.ALL);
        Logger loggerB = Logger.getLogger("org.stepic.java.logging.ClassB");
        loggerB.setLevel(Level.WARNING);

        ConsoleHandler consoleHandlerA = new ConsoleHandler();
        consoleHandlerA.setLevel(Level.ALL);
        ConsoleHandler consoleHandlerB = new ConsoleHandler();
        consoleHandlerB.setLevel(Level.WARNING);

        loggerA.addHandler(consoleHandlerA);
        loggerB.addHandler(consoleHandlerB);

        XMLFormatter xmlFormatterA = new XMLFormatter();
        consoleHandlerA.setFormatter(xmlFormatterA);
        XMLFormatter xmlFormatterB = new XMLFormatter();
        consoleHandlerB.setFormatter(xmlFormatterB);

    }

    // 1) вся реализация идет внутри заданного в косоли метода;
    //2) Инициализируем логгеры и сразу меняем им уровень на нужный (при помощи setLevel)
    //Дальше начинается пяска с 3-м handler (впринципе ошибки которые будут приходить само подскажут чего не хватает) :
    //3_1 Инициализируем consoleHandler и связываем его с логгером (addHandler)
    //3_2 Меняем левел консольхадлера на нужный (темже сетлэвэлом)
    //3_3 инициализируем xml formatter
    //3_4 связываем с нашим хендлером (setformatter)
}
