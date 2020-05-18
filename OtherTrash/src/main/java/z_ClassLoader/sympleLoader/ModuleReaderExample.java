package z_ClassLoader.sympleLoader;

import java.io.IOException;
import java.lang.module.ModuleFinder;
import java.lang.module.ModuleReader;
import java.lang.module.ModuleReference;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ModuleReaderExample {
    // from https://books.google.ru/books?id=8pY3DwAAQBAJ&printsec=frontcover&dq=ClassLoader+java&hl=ru&sa=X&ved=0ahUKEwiFrd-y3L_oAhVssYsKHU41A7wQ6AEIgAEwCA#v=onepage&q=ClassLoader%20java&f=false
    // from book Java 9 Modularity Revealed: Project Jigsaw and Scalable Java Applications
    public static void main(String[] args) {
        List<Class<?>> classList = getClassesByModuleName("java.base");

        for (Class<?> item : classList) {
            System.out.println("Name of the class is: " + Runner.class.getName()); // z_ClassLoader.sympleLoader.Runner
            System.out.println("Name of the package is: " + Runner.class.getPackageName()); // z_ClassLoader.sympleLoader
        }

    }

    private static List<Class<?>> getClassesByModuleName(String moduleName) {
        ModuleFinder finder = ModuleFinder.ofSystem();
        Optional<ModuleReference> optionalModuleReference = finder.find(moduleName);
        ModuleReference moduleReference = optionalModuleReference.get();

        List<Class<?>> result = null;
        try (ModuleReader moduleReader = moduleReference.open()) {

            result = moduleReader.list()
                    .filter(name -> name.endsWith("Impl.class"))
                    .map(ModuleReaderExample::classLoadByFileName)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static Class<?> classLoadByFileName(String classFileName) {
        ClassLoader classLoader = ModuleReaderExample.class.getClassLoader();
        String nameOfClass = classFileName.substring(0, classFileName.length() - ".class".length());

        Class<?> result = null;
        try {
            nameOfClass = nameOfClass.replace("/", ".");
            result = classLoader.loadClass(nameOfClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}
