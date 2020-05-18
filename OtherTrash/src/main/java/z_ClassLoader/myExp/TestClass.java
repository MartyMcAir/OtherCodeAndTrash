package z_ClassLoader.myExp;

public class TestClass {
    private static int a = getAValue();

    private static int getAValue() {
        System.out.println("initializing");
        return 5;
    }
}
