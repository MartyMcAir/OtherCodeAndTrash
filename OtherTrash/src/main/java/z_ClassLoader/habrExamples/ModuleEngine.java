package z_ClassLoader.habrExamples;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

public class ModuleEngine {

    public static void main(String args[]) {
//        String modulePath = args[0];
//        String modulePath = "z_ClassLoader.habrExamples.ModulePrinter";
        String modulePath = "z_ClassLoader.habrExamples";
        // Создаем загрузчик модулей.
        ModuleLoader loader = new ModuleLoader(modulePath, ClassLoader.getSystemClassLoader());

        File dir = new File(modulePath);
        String[] modules = dir.list();   // Получаем список доступных модулей.

        try {
            for (String module : modules) { // Загружаем и исполняем каждый модуль
                String moduleName = module.split(".class")[0]; // NPE
                Class clazz = loader.loadClass(moduleName);

//                Module execute = (Module) clazz.newInstance();   // deprecated way.. newInstance
                Module execute = (Module) clazz.getConstructor().newInstance();
                execute.load();
                execute.run();
                execute.unload();
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}