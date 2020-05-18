package z_ClassLoader.javaOnline;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

public class DynamicClassOverloader extends ClassLoader {
    private final static char sep = File.separatorChar;
    private Map mapCache = new java.util.HashMap();
    public final String[] classPath;
    public final String singlePath;

    public DynamicClassOverloader(String[] classPath, String singlePath) {   // Набор путей поиска - аналог переменной CLASSPATH
        this.classPath = classPath;
        this.singlePath = singlePath;
    }

    protected synchronized Class loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class result = findClass(name);
        if (resolve)
            resolveClass(result);
        return result;
    }

    protected Class findClass(String name) throws ClassNotFoundException {
        Class result = (Class) mapCache.get(name);
        if (result != null) {   // System.out.println("% Class " + name + " found in cache");
            return result;
        }

        File f = findFile(name.replace('.', '/'), ".class");
        // Класс mypackage.MyClass следует искать файле
        // mypackage/MyClass.class
        // System.out.println("% Class " + name + (f==null?"":" found in "+f));
        if (f == null) {
            // Обращаемся к системному загрузчику в случае неудачи.
            // findSystemClass – это метод абстрактного класса ClassLoader с объявлением
            // protected Class findSystemClass(String name)
            // (т.е. предназначенный для использования в наследниках и не подлежащий переопределению).
            // Он выполняет поиск и загрузку класса по алгоритму системного загрузчика.
            // Без вызова findSystemClass(name) нам пришлось бы самостоятельно позаботиться о загрузке всех
            // стандартных библиотечных классов типа java.lang.String, что потребовало бы
            // реализовать работу с JAR-архивами (стандартные библиотеки почти всегда упакованы в JAR)
            return findSystemClass(name);
        }

        try {
            byte[] classBytes = loadFileAsBytes(f);
            result = defineClass(name, classBytes, 0,
                    classBytes.length);
        } catch (IOException e) {
            throw new ClassNotFoundException(
                    "Cannot load class " + name + ": " + e);
        } catch (ClassFormatError e) {
            throw new ClassNotFoundException(
                    "Format of class file incorrect for class "
                            + name + " : " + e);
        }
        mapCache.put(name, result);
        return result;
    }

    protected java.net.URL findResource(String name) {
        File f = findFile(name, "java");
        if (f == null)
            return null;
        try {
            return f.toURL();
        } catch (MalformedURLException e) {
            return null;
        }
    }

    /**
     * Поиск файла с именем name и, возможно, расширением
     * extension в каталогах поиска, заданных параметром конструктора classPath.
     */
    private File findFile(String name, String extension) {
        File file;
        for (int k = 0; k < classPath.length; k++) {
            file = new File((new File(classPath[k])).getPath()
                    + sep + name.replace('/', sep) + extension);

            if (file.exists())
                return file;
        }
        return null;
    }

    public static byte[] loadFileAsBytes(File file) throws IOException {
        byte[] result = new byte[(int) file.length()];

        try (FileInputStream f = new FileInputStream(file)) {
            f.read(result, 0, result.length);
        }
        return result;
    }
}
