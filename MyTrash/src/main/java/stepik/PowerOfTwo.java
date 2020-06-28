package stepik;

public class PowerOfTwo {
    // https://stepik.org/lesson/12760/step/9?unit=3108
    // Реализуйте метод, проверяющий, является ли заданное число по абсолютной величине степенью двойки.

    //Решать можно разными способами:
    // воспользовавшись одним удобным статическим методом из класса java.lang.Integer;
    // применив пару трюков из двоичной арифметики;
    // написав решение "в лоб" с циклом и условными операторами (можете вернуться к этой задаче
    // после просмотра соответствующих уроков).

    // in 0 out false
    // in 1 out true
    // in -2 out true
    public static void main(String[] args) {
        int[] arrInt = {0, 1, -2};
        for (int item : arrInt)
            System.out.println(isPowerOfTwo(item));
    }

    public static boolean isPowerOfTwo(int value) {
        return Integer.bitCount(Math.abs(value)) == 1;
    }

    // from forums
    // Побитовое сложение степени двойки и предыдущего двоичного числа даст ноль.
    public static boolean isPowerOfTwoV1(int value) {
        value = Math.abs(value);
        return ((value & (value - 1)) == 0) & (0 != value);// you implementation here
    }

    public static boolean isPowerOfTwoV2(int v) {
        return v != 0 && (v & -v) == Math.abs(v);
    }

    public static boolean isPowerOfTwoV3(int value) {
        return value == 0 ? false : (value & -value) == (value < 0 ? -value : value);
    }

    public static boolean isPowerOfTwoV4(int value) {
        double l = Math.log(Math.abs(value)) / Math.log(2);
        return l == (int) l;
    }

    public static boolean isPowerOfTwoV5(int value) {
        return (value != 0) & (((value & value-1) == 0) || ((-1*value & -1*value-1) == 0)) ;// you implementation here
    }

    public static boolean isPowerOfTwoV6(int value) {
        return value != 0 && Integer.highestOneBit(Math.abs(value)) == Math.abs(value);
    }

    public static boolean isPowerOfTwoV7(int value) {
        int val = Math.abs(value);
        boolean res = false;
        if (value != 0) {
            if ((val & (val-1)) == 0) {
                res = true;
            }
        }
        return res; // you implementation here
    }

    public static boolean isPowerOfTwoV8(int value) {
        return (Integer.numberOfLeadingZeros(Math.abs(value))+Integer.numberOfTrailingZeros(Math.abs(value)))==31;
    }

    // comments
    // Integer.numberOfLeadingZeros
    //Integer.numberOfTrailingZeros
    //Подсказка такая. Если число - степень двойки,
    // то в двоичной записи у этого числа будет одна единица (самая первая), а остальные разряды - нули.
    // он подсчитывает количество единиц в двоичном виде числа

    // Напишу для таких как я, под абсолютным числом понимают любое число без знака минус

    // Решила с помощью методов Math.abs() и java.lang.Integer.bitCount() с небольшим циклом.

    // В общем, я понял что от меня хотят и как это работает после 5 минут рассматривания таблицы, где перечислены
    // степени числа 2. Их всех объединяет количество единиц. А дальше стоит как и рекомендуется использовать
    // статический метод самый первый bitCount

    // Позволю себе внести свою критику в формулировку задания, потому что бомбит.
    //"является ли заданное число по абсолютной величине степенью двойки"
    //звучит как:
    //"является ли заданное число по абсолютной величине показателем степени двойки".
    //Ну это же правда одно и тоже! По крайней мере для меня...
    //
    //Разве нельзя было нормально составить предложение как:
    //"является ли заданное число по абсолютной величине результатом возведения двойки в степень"?
}
