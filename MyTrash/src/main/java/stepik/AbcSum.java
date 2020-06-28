package stepik;

public class AbcSum {
    // https://stepik.org/lesson/12759/step/12?unit=3107
    // Реализуйте метод, возвращающий ответ на вопрос: правда ли, что a + b = c?
    // Допустимая погрешность – 0.0001 (1E-4)

    // Sample Input: //0.1 0.2 0.3
    //Sample Output: //true
    public static void main(String[] args) {
        System.out.println(doubleExpressionV3(0.1, 0.2, 0.3));
    }

    // теперь доступен форму решений! https://stepik.org/lesson/12759/step/12?thread=solutions&unit=3107
    // Прошло!
    public static boolean doubleExpressionV3(double a, double b, double c) {
        // (a + b) % c < 0.0001;
        return (((Math.abs(a) * 100) + (Math.abs(b) * 100)) - (Math.abs(c) * 100)) == 0;
    }

    public static boolean doubleExpressionV2(double a, double b, double c) {
        System.out.println("a" + a + " +b" + b + "=" + (a + b) + " and c:" + c);
        return (a + b) == (double) c;
    }

    // неверное решение т.к. А если подставить a = 1 b = 1 c = 3 ? - тоже будет true _ а длолжно быть false
    // вроде верно но не проъодит __ т.е. если после вычета меньеше 0.0001 то числа равны с допущенной погрешностью..
    public static boolean doubleExpressionV0(double a, double b, double c) {
        return ((a + b) - c) < 0.0001;
    }

}
