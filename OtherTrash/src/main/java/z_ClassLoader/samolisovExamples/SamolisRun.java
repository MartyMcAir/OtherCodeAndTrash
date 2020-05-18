package z_ClassLoader.samolisovExamples;

public class SamolisRun {
    // http://samolisov.blogspot.com/2008/01/java.html
    // - не рабочий код с кучей ошибок
    public static void main(String[] args) {
// Создаем загрузчик
        JarClassLoader jarClassLoader = new JarClassLoader("beq.jar",
                "org.beq.classloader.classes.impl");
// Загружаем класс
//        Class<?> clazz = loadClass("JarSample");
//// Создаем экземпляр класса
//        IJarSample sample = (IJarSample) clazz.newInstance();
//        sample.demo("Test");
    }
}