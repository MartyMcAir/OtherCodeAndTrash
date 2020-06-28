package stepik;

import java.util.function.DoubleUnaryOperator;

public class LeftRectangleMethod {
    // https://stepik.org/lesson/14513/step/7?unit=4147
    public static void main(String[] args) {
//        Function<Double, Double> arrFunc =

        System.out.println(integrate(x -> 1, 0, 10));   //10.0
        System.out.println(integrate(x -> x + 2, 0, 10));   //70.0
        System.out.println(integrate(x -> Math.sin(x) / x, 1, 5));   //0.603848

    }


    public static double integrateV2(DoubleUnaryOperator f, double a, double b) {
        double rez = 0;
        double h = 1e-7;
        double n = (b - a) * 10;

        for (double i = a; i < n; i += h) {
            rez += f.applyAsDouble(i);
        }
        return rez * h;
    }

    // good
    public static double integrate(DoubleUnaryOperator f, double a, double b) {
//        double n = 0x1.0p25; // Шестнадцатеричная запись вещественного числа.
        double n = 10000000;
        double h = (b - a) / n, s = 0;
//        for (int i = 0; i < 1_000_000; i++)
        for (int i = 0; i < n; i++)
            s += f.applyAsDouble(a + h * (i + 0.5));

//        return f.applyAsDouble(b);
//        return f.applyAsDouble(s);
        return s * h;
    }

    // from forum resolve
    public static double integrateStandard(DoubleUnaryOperator f, double a, double b) {
        final double h = 10E-7;
        double n = (b - a) / h;
        double s = 0;

        for (int i = 0; i < n - 1; i++) {
            s += f.applyAsDouble(a + i * h);
        }
        return s * h;
    }

    public static double integrateSimple(DoubleUnaryOperator f, double a, double b) {
        double step = 10E-6, integrated = 0;

        for (double i = a; i <= b; i += step)
            integrated += f.applyAsDouble(i);

        return integrated * step;
    }

    public static double integrateWow(DoubleUnaryOperator f, double a, double b) {
        double x = 0, step = 10e-7;
        for (; a < b; x += f.applyAsDouble(a) * step, a += step) ;
        return x;
    }

    public static double integrateV3(DoubleUnaryOperator f, double a, double b) {
        final double h = 1e-6;
        double sum = 0;
        long i = 0;
        for (double x = a; x < b; x = a + h * i++) {
            sum += h * f.applyAsDouble(x);
        }
        return sum;
    }

    public static double integrateV4(DoubleUnaryOperator f, double a, double b) {
        double i = 0;
        while (a < b)
            i += f.applyAsDouble(a += 1e-6);

        return i * 1e-6;
    }

    public static double integrateV5(DoubleUnaryOperator f, double a, double b) {
        double step = 1e-7;
        double sum = 0;
        for (double x = a; x < b; x += step)
            sum += step * f.applyAsDouble(x);

        return sum;
    }

    public static double integrateRecursion(DoubleUnaryOperator f, double a, double b) {
        if (b - a < 1e-6) {
            return f.applyAsDouble(a) * (b - a);
        }
        return integrateRecursion(f, a, (a + b) / 2) + integrateRecursion(f, (a + b) / 2, b);
    }

    public static double integrateV6(DoubleUnaryOperator f, double a, double b) {
        double res = 0;
        while (a < b) {
            res += 0.000001 * f.applyAsDouble(a);
            a += 0.000001;
        }
        return res;
    }


    // P.S. Если задача слишком легкая, то дополнительно можете реализовать динамический выбор
    // шага сетки по следующему алгоритму:
    //
    //Вычислить приближенное значение интеграла функции при начальном значении шага сетки (например, 1).
    //Вычислить приближенное значение интеграла функции при более мелком шаге сетки
    // (например, уменьшить шаг сетки в два раза).
    //Если разность двух последовательных приближений интеграла функции достаточно мала,
    // то завершаем алгоритм и возвращаем текущее приближение в качестве результата.
    //Иначе возвращаемся к шагу 2.


    ////// comments
    // Долго подбирал n. Мне подошло:   (Зачем подбирать, если можно вычислить?)
    //double n = 0x1.0p25; // Шестнадцатеричная запись вещественного числа.
    //double h = (b - a) / n;
    //Вам осталось только организовать цикл, суммирующий площадь n прямоугольников,
    // размером h на f.applyAsDouble(a+h*ia+h∗i), где i - номер итерации(с нуля). Удачи:)

    // Задача в большей степени на математику, чем к данной теме урока.
    // Принимается ответ, как средних, так и левых прямоугольников.
    // Алгоритм, представленный на “С” по ссылке задания, переписывается на "Java" с учетом контекста задания.
    // Внимательно смотрите значения для “n”!

    // Кстати, точности 10^(-6) было мало, пришлось взять 10^(-7), её хватает.


    // Из понятого: некую кривую(?!) надо разбить на отрезки(например
    // с шагом,10^(−6)) и каким-то образом вычислить площадь каждого получившегося прямоугольника.
    // Каким образом рассчитать его параметры? Формулу рассчёта площади я помню, мне не понятно,
    // как взять высоту на участке, ведь данные об оси Y нам неизвестны?
    // --- значение функции в точке x можно получить, вызвав f.applyAsDouble(x). Это и есть высота прямоугольника.
    //  --- везде решения идет с тремя переменными a,b и n. В нашем случае только первые два,
    //  в качестве n я использовал "n = 10000000;", это точности хватило.
    // Потом везде в решениях есть с использованием то синуса то косинуса то логорифма,
    // в решении этой задачи вместо этого используйте f.applyAsDouble(...)

    // формула должна быть такой
    //S - площадь
    //f - функция
    //a, b - координаты отрезка
    //n - на сколько частей мы делим указанный отрезок. он определяет точность и
    // в данном задании это должна быть одна миллионная
    //i - текущая миллионная доля отрезка.
    //h = (b - a) / n
    //S = S + f(a + h * (i + 0.5))
    //учитывая, что i наращивается по порядку и их миллион штук, это цикличная формула.
}
