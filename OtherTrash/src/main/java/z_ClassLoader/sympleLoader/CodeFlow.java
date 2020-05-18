package z_ClassLoader.sympleLoader;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

public class CodeFlow extends ClassLoader {
    private static volatile int counter = 0;

    // https://www.codeflow.site/ru/article/java-classloaders
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException,
            InstantiationException, NoSuchMethodException, InvocationTargetException, IOException {
        while (true) {
            CodeFlow codeFlow = new CodeFlow();

            Class<?> aClass = Class.forName("z_ClassLoader.javaOnline.TestModule", true,
                    codeFlow.getClass().getClassLoader());

            Object o = aClass.getConstructor().newInstance();
            System.out.println(o);

            System.out.println(aClass.toString());
            new InputStreamReader(System.in).read();
        }

    }

    @Override
    public Class findClass(String name) throws ClassNotFoundException {
        byte[] b = loadClassFromFile(name);
        return defineClass(name, b, 0, b.length);
    }

    private byte[] loadClassFromFile(String fileName) {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(
                fileName.replace('.', File.separatorChar) + ".class");
        byte[] buffer;
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        int nextValue = 0;
        try {
            while ((nextValue = inputStream.read()) != -1) {
                byteStream.write(nextValue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        buffer = byteStream.toByteArray();
        return buffer;
    }

    @Override
    public String toString() {
        return "string loaded is: 0 and counter: " + (counter++);
    }
}
