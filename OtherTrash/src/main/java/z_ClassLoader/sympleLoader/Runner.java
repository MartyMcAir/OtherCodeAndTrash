package z_ClassLoader.sympleLoader;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Runner {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // https://habr.com/ru/post/341930/
        Constructor<Class> constructor = Class.class.getDeclaredConstructor(ClassLoader.class);

        constructor.setAccessible(true);
        Class<?> clazz = constructor.newInstance(ClassLoader.getSystemClassLoader());
    }
}
