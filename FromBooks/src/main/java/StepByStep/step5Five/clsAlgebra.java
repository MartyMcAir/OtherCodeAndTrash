/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepByStep.step5Five;

import java.math.BigDecimal;
import java.util.Random;

/**
 *
 * @author MartyMcAir
 */
public class clsAlgebra {

    public static void main(String[] args) {
        clsAlgebra cls = new clsAlgebra();
//        cls.passwGeneratorRnd(8);

        // Math
//        cls.passwGeneratorMath(16);
        System.out.println();
//        cls.mathRound(333, Math.PI);

        // BigDecimal
        cls.methodBigDecimal(10, 3);
    }

    void methodBigDecimal(int a, int b) {
        System.out.println("a: " + a + ", b: " + b);
        BigDecimal num1 = new BigDecimal(a);
        BigDecimal num2 = new BigDecimal(b);
        System.out.println("add +: " + num1.add(num2));
        System.out.println("subtract -: " + num1.subtract(num2));
        System.out.println("divide /: " + num2.divide(num1));
        // Ошибка при делении 10 на 3 зато 3 на 10 = 0,3
//        System.out.println("divide /: " + num1.divide(num2));
        System.out.println("multiply *: " + num1.multiply(num2));

    }

    void mathRound(int a, double b) {
        System.out.println("a: " + a + ", b: " + b);
        System.out.println("abs() _ a: " + Math.abs(a) + ", b: " + Math.abs(b));
        System.out.println("ceil() _ a: " + Math.ceil(a) + ", b: " + Math.ceil(b));
        System.out.println("floor() _ a: " + Math.floor(a) + ", b: " + Math.floor(b));
        System.out.println("rint() _ a: " + Math.rint(a) + ", b: " + Math.rint(b));
        System.out.println("round() _ a: " + Math.round(a) + ", b: " + Math.round(b));
        System.out.println("upl() _ a: " + Math.ulp(a) + ", b: " + Math.ulp(b));

        System.out.println("min(): " + Math.min(a, b) + ", max(): " + Math.max(a, b));
        System.out.println("pow(a, b): " + Math.pow(a, b));
    }

    void passwGeneratorMath(int lengthPassw) {
        char[] arr = {'a', 'b', 'c', 'd', 'e', 'f', 'g',
            'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u',
            'v', 'w', 'x', 'y', 'z'};
        StringBuilder stbl = new StringBuilder();
        for (int i = 0; i < lengthPassw; i++) {
            char tmp = arr[(int) (Math.random() * arr.length)];
            stbl.append(tmp);
        }
        System.out.println("Пароль сгенерированный Random" + stbl.toString());
    }

    void passwGeneratorRnd(int lengthPassw) {
        char[] arr = {'a', 'b', 'c', 'd', 'e', 'f', 'g',
            'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u',
            'v', 'w', 'x', 'y', 'z'};
        StringBuilder stbl = new StringBuilder();
        Random rnd = new Random();
        for (int i = 0; i < lengthPassw; i++) {
            char tmp = arr[rnd.nextInt(arr.length)];
            stbl.append(tmp);
        }
        System.out.println("Пароль сгенерированный Random" + stbl.toString());
    }
}
