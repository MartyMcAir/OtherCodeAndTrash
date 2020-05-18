package z_ClassLoader.javaOnline;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

// http://java-online.ru/java-classloader.xhtml
public class LoadRunner {
    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException,
            ClassNotFoundException, InterruptedException {
        String pathStr = LoadRunner.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        String pkgName = LoadRunner.class.getPackage().getName();
        String packagePathStr = pkgName.replaceAll("[.]", "/") + "/";
//                Set<? extends Animal> allAnimals = getAllAnimals(pathStr + packagePathStr);

//        System.out.println(pathStr); // /C:/z_n/Dropbox/GitHub/myCodeExamples/out/production/classes/
//        System.out.println(packagePathStr); // z_ClassLoader/LoadRunner

        String fullPath = pathStr + packagePathStr;
//        System.out.println(fullPath); // /C:/z_n/Dropbox/GitHub/myCodeExamples/out/production/classes/z_ClassLoader/LoadRunner


        String dynamicDotPath = "z_ClassLoader.javaOnline.DynamicClassOverloader";
        String dynamicPath = "z_ClassLoader/javaOnline/DynamicClassOverloader";

        String pathIs = "C:\\z_n\\Dropbox\\GitHub\\myCodeExamples\\src\\main\\java\\z_ClassLoader\\javaOnline\\DynamicClassOverloader.java";
//        findFile(pathIs);

        fromExamples(new String[]{dynamicPath}, dynamicPath);
    }

    private static void findFile(String path) {
        File file = new File(path);
        if (file.exists())
            System.out.println("file founded..");
        else System.out.println("file not found!");

    }

    private static void fromExamples(String[] classPath, String singlePath) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, InterruptedException {
        String[] classPath2 = {"."};
        ClassLoader loader;

        while (true) {
            loader = new DynamicClassOverloader(classPath, singlePath);

            // текущий каталог "." будет единственным _ каталогом поиска
//            this.getClass().
            Class clazz = Class.forName("z_ClassLoader.javaOnline.TestModule", true, loader);
            Object object = clazz.newInstance();
            System.out.println(object);

            // после чтения очередной строки будет нов интерация в которой будет сгенерирован нов. класс
            new BufferedReader(new InputStreamReader(System.in)).readLine();
//            Thread.sleep(500);
        }
    }
}
