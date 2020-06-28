package fromCS50specific;

public class Tmp {
    public static void main(String[] args) {
//        System.out.println(sigma(3));
//        System.out.println(sigma(6));
//        System.out.println(sigma(50));

//        System.out.println(sigmaRecursion(3));
//        System.out.println(sigmaRecursion(6));
//        System.out.println(sigmaRecursion(50));

        swapBitsShow(1, 2);
    }

    // https://javarush.ru/quests/lectures/questharvardcs50.level04.lecture01
    // https://www.youtube.com/watch?v=lqovT3n62ts
    public static int sigma(int m) {   // сигма
        int sum = 0;
        for (int i = 1; i <= m; i++)
            sum += i;
        return sum;
    }

    public static int sigmaRecursion(int m) {
        if (m <= 0) return 0;
        else return (m + sigmaRecursion(m - 1));
    }

    /////
    public static void swap(int a, int b) {
        int tmp = a;
        a = b;
        b = tmp;
    }

    public static void swapBits(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }

    public static void swapBitsShow(int a, int b) {
        // 1   10
        System.out.println("a: " + Integer.toBinaryString(a) + ", " + Integer.toBinaryString(b));
        a = a ^ b;   // 11   10
        System.out.println("a: " + Integer.toBinaryString(a) + ", " + Integer.toBinaryString(b));
        b = a ^ b;   // 11   1
        System.out.println("a: " + Integer.toBinaryString(a) + ", " + Integer.toBinaryString(b));
        a = a ^ b;   // 10   1
        System.out.println("a: " + Integer.toBinaryString(a) + ", " + Integer.toBinaryString(b));
        System.out.println("a is: " + a + ", b is: " + b);   // a is: 2, b is: 1
    }
}
