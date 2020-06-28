package stepik;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.logging.*;

public class LoggingExpStd {
    static {
//        String sep = System.lineSeparator();
        String sep = File.separator;

        String logProperties = "MyTrash/src/main/java/" + LoggingExpStd.class.getPackage().getName()
                .replaceAll("[.]", "/") + "/loggingToFile.properties";
        String path1 = Paths.get(logProperties).toAbsolutePath().toString();
        // requireNonNull - for NPE _ error: ExceptionInInitializerError
//        String path2 = Objects.requireNonNull(LoggingExpStd.class.getClassLoader().getResource("loggingToFile.properties")).getFile();
        String path3 = Paths.get("").toAbsolutePath() + sep + "MyTrash" + sep + "src" + sep + "main" +
                sep + "java" + sep + LoggingExpStd.class.getPackage().getName()
                .replaceAll("[.]", sep) + sep + "loggingToFile.properties";
        System.setProperty("java.util.logging.config.file", path3);
    }

    //must initialize loggers after setting above property
    private static final Logger LOGGER = Logger.getLogger(LoggingExpStd.class.getName());

    // Хэндлеры обработчики сообщений, указывает куда сохранять логи
    //Handler consoleHandler = new ConsoleHandler();
    //Handler streamHandler = new StreamHandler();
    //Handler socketHandler = new SocketHandler();

    public LoggingExpStd() throws IOException {
    }

    // паттерны для указания места записи инфы с хэндлеров
    // "/" the local pathname separator
    //"%t" the system temporary directory
    //"%h" the value of the "user.home" system property
    //"%g" the generation number to distinguish rotated logs
    //"%u" a unique number to resolve conflicts
    //"%%" translates to a single percent sign "%"

    public static void main(String[] args) throws IOException {
//    Handler fileHandler = new FileHandler("%h/myJava.log"); // указывает куда сохранять
        // оба пути корректны
        String cnfPath1 = "e:\\log\\myJava.log", cnfPath2 = "E:/log/myJava.log";
        Handler fileHandler = new FileHandler(cnfPath2);

        // сеттим фильтер в хэндлер и добавляем хэнддер в логгер
//        fileHandler.setFilter(new MyFilter()); // фильтр сообщений, т.е. запись только соответствующих условию в..
        // для управления форматированием логов.. то кк они записываются в файл ил выводятся в консоль
        fileHandler.setFormatter(new MyFormatter());
        // setLevel(..) - действует на все обрабатываем сообщения хэндлером.. так же как и фильтр,
        // но только для Level'а сообщений

        fileHandler.setLevel(Level.ALL);  // у хэндлеров тоже если уровни, но юзаются не так часто
        LOGGER.setLevel(Level.ALL);
        // сеттим хэндлер _ не перекрывает System.setProperty(.. а дополняет его..
        LOGGER.addHandler(fileHandler);

        // в консоль при любом LEVEL выводит 0 3 5 6 9 11
        // ALL - пишет всЁ в файл,
        // OFF -     в файл ничего
        // FINEST -  в файл 0 1 2 3 5 6 7 8 9 10 11 12 _ INFO FINE FINEST SEVERE WARNING FINER OFF CONFIG
        // FINER -   в файл 0 1 3 5 6 8 10 11 12 _ INFO FINE SEVERE WARNING FINER OFF CONFIG
        // FINE -    в файл 0 1 3 5 6 9 11 12 _ INFO FINE SEVERE WARNING OFF
        // CONFIG -  в файл 0 3 5 6 9 11 12 _ INFO SEVERE WARNING OFF CONFIG
        // INFO -    в файл 0 3 5 6 9 11 _ INFO SEVERE WARNING OFF
        // WARNING - в файл 3 6 9 11 _ WARNING SEVERE OFF
        // SEVERE -  в файл 3 9 11 _ SEVERE OFF

        // Тестовые методы
//        settingCnfByUtilLogger();   // анулирует все остальные конфиги и засеттеные хэндлеры
        writeTestLogByUtilLogger();
//        exampleSystemLogger();
    }

    public static void writeTestLogByUtilLogger() {   // какая-то логика
        System.out.println("openOrder Заказ оформлен!");
        // логируем инфо
        LOGGER.info(" 0 text from  LOGGER.info(..\n");
        LOGGER.fine(" 1 text from  LOGGER.fine(..\n");
        LOGGER.finest(" 2 text from  LOGGER.finest(..\n");
        LOGGER.severe(" 3 text from  LOGGER.severe(..\n\n");

//        String variable = "writeTestLog()";
        // {0} - сюда будет подставлена variable _ вместо конкатенации т.к.
        // конкатенация весьма затратна при огромном кол-ве логов _ НЕРАБОТАЕТ
//        LOGGER.log(Level.FINEST, "test log msg from method: {0}", variable);

        LOGGER.log(Level.ALL, " 4 msg from   LOGGER.log(Level.ALL,\n");
        LOGGER.log(Level.INFO, " 5 msg from   LOGGER.log(Level.INFO,\n");
        LOGGER.log(Level.WARNING, " 6 msg from   LOGGER.log(Level.WARNING,\n");

        LOGGER.log(Level.FINEST, " 7 msg from   LOGGER.log(Level.FINEST,\n");
        LOGGER.log(Level.FINE, " 8 msg from   LOGGER.log(Level.FINE,\n");
        LOGGER.log(Level.SEVERE, " 9 msg from   LOGGER.log(Level.SEVERE,\n");
        LOGGER.log(Level.FINER, " 10 msg from   LOGGER.log(Level.FINER,\n");

        LOGGER.log(Level.OFF, " 11 msg from   LOGGER.log(Level.OFF,\n");
        LOGGER.log(Level.CONFIG, " 12 msg from   LOGGER.log(Level.CONFIG,\n");
    }

    static class MyFilter implements Filter {
        @Override
        public boolean isLoggable(LogRecord record) {
            return record.getMessage().endsWith("textEnd");
        }
    }

    static class MyFormatter extends Formatter {
        @Override
        public String format(LogRecord record) {
            return record.getLevel() + record.getMessage();
        }
    }

    public static void settingCnfByUtilLogger() throws IOException {
        // или Настраиваем конфигурацию Логгера
        // через сам объект логгера
//        String configTxt = "level=ALL..";
//        Supplier<String> supplier = () -> configTxt;
//        LOGGER.config(supplier);
//        LOGGER.config(configTxt);

        // через LogManager
        LogManager logManager = LogManager.getLogManager();
        logManager.addLogger(LOGGER);   // сеттим настраиваемый Логгер

        // получаем конфиги, подгружая их из файла as Stream.. лежащего в текущем package
        String pathFileCnf1 = "C:\\Users\\marty\\OneDrive\\Dropbox\\GitHub\\OtherCodeAndTrash\\MyTrash\\src\\main\\java\\stepik\\loggingToFile.properties";
//        String pathFileCnf2 = LoggingExpStd.class.getResource("/loggingToFile.properties").toString(); // NPE

        // читаем конфиг через указанный путь _ НЕРАБОТАЕТ
//        logManager.getProperty(pathFileCnf1);
//        logManager.readConfiguration();

        // читаем конфиг через InputStream
        InputStream resourceAsStream1 = Files.newInputStream(Paths.get(pathFileCnf1));
//        InputStream resourceAsStream2 = LoggingExpLite.class.getResourceAsStream("/loggingToFile.properties"); // NPE
        logManager.readConfiguration(resourceAsStream1);
    }

    public static void exampleSystemLogger() {
//        Properties properties = new Properties();
        Properties properties = System.getProperties();
        properties.put("level", "ALL");
        properties.put("handler", "FileHandler");
        properties.put("formatter", "SimpleFormatter");
        properties.put("pattern", "%h/java%u.log");

        System.Logger sysLogger = System.getLogger(LoggingExpStd.class.getName());
        // Варианты указания кофигов
        System.setProperties(properties); // в коде через объект Properties
        // через файл *.properties
        System.getProperty(LoggingExpStd.class.getPackageName() + "." + "logging.properties");
        String cnfPath = "C:\\Users\\marty\\OneDrive\\Dropbox\\GitHub\\OtherCodeAndTrash\\MyTrash\\src\\main\\java\\stepik\\logging.properties";
        System.setProperty("java.util.logging.config.file", cnfPath);

        // Логирование
        sysLogger.log(System.Logger.Level.INFO, "test Info log from exampleSystemLogger()");
        String variable = "testVariable";
        sysLogger.log(System.Logger.Level.WARNING, "test WARNING log from exampleSystemLogger() {0}", variable);
    }
}