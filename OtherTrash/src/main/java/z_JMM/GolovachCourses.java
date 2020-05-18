package z_JMM;

public class GolovachCourses {
    static int counter0 = 0, counter10 = 0, commonsCounter;

    public static void main(String[] args) {
        try {
            test10();
        } catch (StackOverflowError ignored) {
        }
        System.out.println("test0() counted is: " + counter0); // 0
        System.out.println(commonsCounter);   // 30129

        try {
            test10();
        } catch (StackOverflowError ignored) {
        }
        System.out.println("test10() counted is: " + counter10); // 92661
        System.out.println(commonsCounter);   // 92661
    }

    private static void test0() {
        counter0++;
        commonsCounter++;
        test0();
    }

    private static void test10() {
        long l1 = 0;
        long l2 = 0;
        long l3 = 0;
        long l4 = 0;
        long l5 = 0;
        long l6 = 0;
        long l7 = 0;
        long l8 = 0;
        long l9 = 0;
        counter10++;
        commonsCounter++;
        test10();
    }
}
