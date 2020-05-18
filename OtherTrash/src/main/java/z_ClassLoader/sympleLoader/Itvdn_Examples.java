package z_ClassLoader.sympleLoader;

public class Itvdn_Examples {
    // https://www.youtube.com/watch?v=xfCt0g5EQs4 __ - ITVDN
    public static void main(String[] args) throws ClassNotFoundException {
//        getByGetClass();
//        getByClass();

        // 3 by .forName(..) _ т.е. здесь мы подставляяем либо стандартный загрузчик
        // так же этот способ предпочтителен, если есть только пути к файлам..
        Integer numberInt = 33;
        ClassLoader integerClassLoader = numberInt.getClass().getClassLoader();

        ClassLoader loader = Itvdn_Examples.class.getClassLoader(); // стандартный загрузчик для конкретного класса
//        ClassLoader loader2 = new MyLoaderExtendtsClassLoader; // или наш личный загрузчик наследующий ClassLoader
        Class<?> cl1 = Class.forName("z_ClassLoader.sympleLoader.Itvdn_Examples", true, loader);

        Class<?> cl2 = Class.forName("java.lang.String"); // без подстановки своего загрузчика
        System.out.println(cl1);
        System.out.println(cl2);

        // 4 by Reflection API

    }

    private static void getByClass() {
        // 2
        int[] arrInt = new int[]{3, 4, 5, 6};

        Class<?> cl1 = Itvdn_Examples.class;
        Class<?> cl2 = int[].class; // arrInt.class; - don't work
    }

    private static void getByGetClass() {
        // 1 способ получения Class<?>
        Itvdn_Examples examples1 = new Itvdn_Examples();
        int[] arrInt = new int[]{3, 4, 5, 6};
        Integer numberInt = 33;

        // Class<?> - используется в рефлекссии для получения инфы об объекте, его методы поля и т.д.
        Class<?> cl1 = examples1.getClass();
        Class<?> cl2 = arrInt.getClass();
        Class<?> cl3 = "String".getClass();
        Class<?> cl4 = numberInt.getClass();
    }
}
