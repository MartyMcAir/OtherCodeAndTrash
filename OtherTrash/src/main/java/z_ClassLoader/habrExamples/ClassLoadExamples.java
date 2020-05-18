package z_ClassLoader.habrExamples;

public class ClassLoadExamples {
    // https://habr.com/ru/post/103830/
    public static void main(String[] args) {
        C c = new C(); // A B C
//        B B = new B(); // A B
//        A a = new A(); // A
    }

    public static class A {
        public A() {
            System.out.println("A");
        }
    }

    public static class B extends A {
        public B() {
            System.out.println("B");
        }
    }

    public static class C extends B {
        public C() {
            System.out.println("C");
        }
    }
}
