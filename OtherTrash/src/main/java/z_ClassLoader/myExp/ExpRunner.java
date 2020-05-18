package z_ClassLoader.myExp;

public class ExpRunner {
    public static void main(String[] args) throws ClassNotFoundException {
        // https://www.logicbig.com/how-to/code-snippets/jcode-reflection-class-forname.html
        Class<?> aClass = Class.forName("z_ClassLoader.myExp.TestClass"); // initialized
//        Class<?> aClass = Class.forName("z_ClassLoader.myExp.TestClass", false,
//                DynamicClassOverloader.class.getClassLoader()); // will not be initialized _ false!
        System.out.println(aClass);   // if true: initializing and _ class com.logicbig.example.TestClass

//        example1();
    }

    private static void example1() {
        // https://www.educative.io/edpresso/what-is-the-classforname-method-in-java\
        // https://www.tutorialspoint.com/java/lang/class_forname_loader.htm _ same  education but better
        try {
            // надо указывать путь пакета и имя файла
            Class cls = Class.forName("z_ClassLoader.myExp.ExpRunner");

            // returns the ClassLoader object
            ClassLoader cLoader = cls.getClassLoader();

         /* returns the Class object associated with the class or interface
            with the given string name, using the given classloader. */
            Class cls2 = Class.forName("java.lang.Thread", true, cLoader);

            // returns the name of the class
            System.out.println("----------------------------");
            System.out.println("Class = " + cls.getName());
            System.out.println("Class = " + cls2.getName());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        }
    }

}
