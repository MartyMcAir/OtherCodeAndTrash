package stepik;

public class StepikBool {
    // https://stepik.org/lesson/12759/step/6?unit=3107
    // Реализуйте метод, возвращающий true, если среди четырех его аргументов ровно два истинны (любые).

    // Во всех остальных случаях метод должен возвращать false.
    // Совет тем, у кого не проходит какой-то из тестов. В данной задаче возможно всего 16 комбинаций значений входных
    // параметров. Их можно выписать на бумажку, посчитать для них правильные ответы и сравнить с тем, что выдает ваше
    // решение.
    public static void main(String[] args) {
        boolean[][] arrBool = {
                new boolean[]{true, true, false, false}, // +
                new boolean[]{false, true, true, false}, // +
                new boolean[]{false, false, true, true}, // +
                new boolean[]{true, false, false, true}, // +
                new boolean[]{false, true, false, true}, // +
                new boolean[]{true, false, true, false}, // +

                new boolean[]{true, true, true, true},
                new boolean[]{false, false, false, false},

                new boolean[]{true, true, true, false},
                new boolean[]{true, false, false, false},
        };

        for (int i = 0; i < arrBool.length; i++) {
            System.out.println(booleanExpressionV3(arrBool[i][0], arrBool[i][1], arrBool[i][2], arrBool[i][3]));
        }

    }

    // from comments Проще объявить переменную возврата и = ложь.
    // Перебрать варианты положительного исхода, придав ей истину. И вернуться из метода.
    public static boolean booleanExpressionV3(boolean a, boolean b, boolean c, boolean d) {
        return (a & b & !c & !d) || (a & !b & c & !d) || (a & !b & !c & d) || (!a & b & c & !d) || (!a & b & !c & d) || (!a & !b & c & d);
    }

    // работает и на удивление прошло проверку..
    public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
        boolean[] arrBool = {a, b, c, d};
        int counter = 0;
        for (boolean item : arrBool)
            if (item) counter++;

        return counter == 2;
    }

    // не проходит если true, true, true, false
    public static boolean booleanExpressionV1(boolean a, boolean b, boolean c, boolean d) {
        return (a & b) ^ (b & c) ^ (c & d) ^ (a & c) ^ (a & d) ^ (b & d);
    }

    // from forum
    public static boolean booleanExpressionV6(boolean a, boolean b, boolean c, boolean d) {
        return ((a ? 1 : 0) + (b ? 1 : 0) + (c ? 1 : 0) + (d ? 1 : 0)) == 2;
    }

    public static boolean booleanExpressionV7(boolean a, boolean b, boolean c, boolean d) {
        return ((a != b) && (c != d)) || ((a != c) && (b != d));
    }

    // у нас есть матрица ответов тру
    //a b c d
    //0 0 1 1
    //0 1 0 1
    //0 1 1 0
    //1 0 0 1
    //остальные зеркальная копия первых двух. делим список по-полам (ab cd) они не должны быть равны кроме единственного
    // (по факту в двух) случая, в нем же не равны ac и bd. проверяем неравенство ab cd и
    // неравенство ac bd если кто-нибудь сработал вернёт тру
    public static boolean booleanExpressionV8(boolean a, boolean b, boolean c, boolean d) {
        return a ^ b ? c ^ d : a ^ c && b ^ d;
    }

    public static boolean booleanExpressionV9(boolean a, boolean b, boolean c, boolean d) {
        return (a | b | c | d) && !(a & b & c & d) && !(a ^ b ^ c ^ d);
    }

    public static boolean booleanExpressionV11(boolean a, boolean b, boolean c, boolean d) {
        return (a ^ b) & (c ^ d)|| (a ^ c) & (b ^ d);
    }

    public static boolean booleanExpressionV12(boolean a, boolean b, boolean c, boolean d) {
        return ((a&b&!c&!d)^(a&!b&c&!d)^(a&!b&!c&d)^(!a&b&c&!d)^(!a&b&!c&d)^(!a&!b&c&d));

    }

    // Исходя из условий задачи, множество входных данных состоит из 16-ти элементов.
    // Из них 6-ть удовлетворяют требованиям, а 10-ть нет. Решение было бы еще проще,
    // если бы из входных данных исключались две ситуации: true true true true и false false false false ,
    // в таком случае решением стало return(a==c)==(b==d). Однако существование в входных данных случая,
    // когда все четыре аргумента равны заставляет "приписать" конъюнкцию с (a!=b)|(b!=c)﻿.
    public static boolean booleanExpressionV13(boolean a, boolean b, boolean c, boolean d) {
        return ((a==c)==(b==d))&((a!=b)|(b!=c));
    }

    public static int f(boolean b) {
        if (b) return 1;
        else return 0;
    }

    public static boolean booleanExpressionV10(boolean a, boolean b, boolean c, boolean d) {
        return f(a) + f(b) + f(c) + f(d) == 2;
    }
}
