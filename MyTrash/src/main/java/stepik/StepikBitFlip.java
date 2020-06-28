package stepik;

// https://stepik.org/lesson/12759/step/15?unit=3107
// Реализуйте метод flipBit, изменяющий значение одного бита заданного целого числа на противоположное.
// Данная задача актуальна, например, при работе с битовыми полями.
// Договоримся, что биты нумеруются от младшего (индекс 1) к старшему (индекс 32).
public class StepikBitFlip {
    // Ссылка
    //Sample Input: Sample Output:
    // 0 1      1
    //13 1     12
    //13 2     15
    //13 3     9
    //13 4     5
    public static void main(String[] args) {
        int[][] arrInt = {
                new int[]{7, 1}, // 110
                new int[]{7, 2}, // 101
                new int[]{0, 1},
                new int[]{0, 1},
                new int[]{1, 12},
                new int[]{2, 15},
                new int[]{3, 9},
                new int[]{4, 5},
                new int[]{5, 2},
        };

        byte bb = 0b101; // -> 111
        System.out.println(bb); // 5
        System.out.println(Byte.toUnsignedInt(bb)); // 5
        System.out.println(Integer.toBinaryString(5));   // 101

//        for (int i = 0; i < arrInt.length; i++) {
//            flipBit(arrInt[i][0], arrInt[i][1]);
//        }

        System.out.println("fff: " + (111 ^ 100)); // 11
        System.out.println("fff: " + (7 ^ 100)); // 99
        System.out.println("fff: " + (7 ^ (1 - 1))); // 7
        System.out.println("fff: " + (111 ^ (1 - 1))); // 111

        // 7 в двоичном: 1 1 1 _ на выходе должен быть 1 1 0
        System.out.println(flipBit(7, 1));
    }

    // return value ^ 1 << --bitIndex;
    // Not My прошло
    public static int flipBitV1(int value, int bitIndex) {
        // отнимается у индекса 1 т.к. условие задачи счет индекса, начинается с одного
        // далее делаем битовый сдвиг влево на 1 _ допустим bitIndex это 3 тогда
        // 1 << (3-1)  ___ 1 << 2 ___ 100
        // value это 7 т.е. 1 1 1 ^ 1 0 0
        return value ^ (1 << (bitIndex - 1));
    }

    // решить это через строки и замену символов в строке, кажется, нельзя.
    // т.е. работает но проверку не проходит
    // индекс у бит считают справо на лево
    public static int flipBit(int value, int bitIndex) {
        char[] chars = Integer.toBinaryString(value).toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.println(chars[i]);
            if (i == bitIndex - 1) chars[i] = reverseBit(chars[i]);
            sb.append(chars[i]);
        }
        return Integer.parseInt(sb.toString());
    }

    public static char reverseBit(char aChar) {   // 49 это 1 _ 48 это 0
        if ((int) aChar == 49) return '0';
        else return '1';
    }

    // Это может показаться сложным, на самом деле для тех, кто только начал знакомиться с программированием,
    // оно так есть. Да и одного примера - мало, хотя на самом деле задача интересная.
    // Просто ради понимания приведу пример: пусть value = 5, bitIndex = 2, что должен в итоге выдать метод?
    // Давайте разберемся. Для начала представим число 5 в двоичном виде, это будет 0b101. Что означает число 2?
    // 2 - это индекс для представленного в двоичном виде числа. В нашем случае индекс 2 указывает для числа 0b101 на 0.
    // Задача в том, что бы поменять то, что стоит под индексом 2 на обратное число, то есть 0 поменять на 1.
    // Итого в результате работы написанной программы должно быть что-то вроде 0b111 в двоичном виде или 7 в десятичном.

    // Еще парочка примеров:
    //1) flipBit(7, 1) = 6 или в двоичном представлении 110, т. к. 7 = 0b111, и мы меняем цифру 1 под индексом 1 на 0.
    //2) flipBit(7, 2) = 5 или в двоичном представлении 101, т.к. 7 = 0b111, и мы меняем цифру 1 под индексом 2 на 0.
    //3) аналогично flipBit(7, 2) = 3 или в двоичном представлении 011, мы меняем цифру 1 на 0 под индексом 3 на 0.
    //Чтобы написать такую программы, нужно использовать "исключающее или" и смещение влево на то кол-во бит,
    // что написано в bitIndex - 1. Надеюсь, теперь стало понятнее. Осталось подумать,
    // как использовать эти две операции и возможно, что они означают.



    // https://stepik.org/lesson/12759/step/15?thread=solutions&unit=3107
    // return value ^ (int)Math.pow(2, bitIndex-1);
    // Самым распространенным способом)) Зато легко для чтения и понимания)
    public static int flipBitV3(int value, int bitIndex) {
        int bitMask = 1;
        bitMask <<= bitIndex - 1;
        return value ^ bitMask;// put your implementation here
    }

}
