package z_ClassLoader.sympleLoader;

public class ExampleLoadBloks {
    public static String staticStr;
    public String notStaticStr;

    static {
        System.out.println("before initialize staticStr: " + staticStr);
        staticStr = "Static string";
        System.out.println(staticStr);
    }

    {
        System.out.println("before initialize notStaticStr: " + notStaticStr);
        notStaticStr = "not static string";
        System.out.println(notStaticStr);
    }

    public ExampleLoadBloks() {
        System.out.println("Constructor");
    }

    public static void main(String[] args) {
        ExampleLoadBloks exampleLoadBloks = new ExampleLoadBloks();
    }
}
