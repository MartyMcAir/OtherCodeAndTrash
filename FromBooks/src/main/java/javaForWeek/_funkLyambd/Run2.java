/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaForWeek._funkLyambd;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author MartyMcAir
 */
public class Run2 {

    public static void main(String[] args) {
        // условия роверки на истинность
        // true, если остаток от деления на 2 равен 0
        MyFunc2Link term1 = (a) -> a % 2 == 0;
        // true, если a меньше 5-ти
        MyFunc2Link term2 = (a) -> a < 5;
        MyFunc2Link term3 = (a) -> a > 5 & a < 10;

        // Отправляем значение аргумента и выводим результаты
        System.out.println("term1: " + term1.isTrue(4)); // true
        System.out.println("term1: " + term1.isTrue(5)); // false
        System.out.println("term2: " + term2.isTrue(6)); // true
        System.out.println("term2: " + term2.isTrue(3)); // false

        int[] nums = {2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(nums));
        
        // Отправляем методу getArr(), лямбду в качестве параметра
        // Ссылке term1 как и другим, им уже присвоенны необходимые лямбды
        // И она является объектом необходимого интерфейса, а потому 
        // свободно отправляется в метод, как раз таки и принимавший
        // ссылки (объекты) данного интерфейса
        System.out.println("Чётные числа: " + getArr(nums, term1));
        System.out.println("Меньше 5ти: " + getArr(nums, term2));
        System.out.println("Больше 5ти и меньше 10ти: " + getArr(nums, term3));

        System.out.println("Сумма чётных чисел: " + sum(nums, term1));
        System.out.println("Сумма чисел, корторые меньше 5ти: " + sum(nums, term2));
        System.out.println("Сумма чисел, которые больше 5ти и меньше 10ти: "
                + sum(nums, term3));
//        int[] test = new int[10];
//        test[1]=2;
//        System.out.println(test[1]);
    }

    private static ArrayList<Integer> getArr(int[] arr, MyFunc2Link var_link) {
        // Создаем коллекци для наполнения её значениями 
        // прошедшими проверку на true
        ArrayList<Integer> new_Arr = new ArrayList<>();
        for (int i : arr) {
            if (var_link.isTrue(i)) {
                new_Arr.add(i);
            }
        }
        return new_Arr;
    }

    private static int[] sum2(int[] arr, MyFunc2Link var_link) {
        int res[] = new int[10];
        for (int i = 0; i < arr.length; i++) {
            // если отправленное значение из массива 
            // вернет в качестве результата true
            if (var_link.isTrue(i)) {
                for (int j = 0; j < 10; j++) {
                    res[j] = i;
                }
            }
        }
        return res;
    }

    // описываем метод для вычисления суммы
    private static int sum(int[] numbers, MyFunc2Link func) {
        int result = 0;
        // перебираем элементы массива
        for (int i : numbers) {
            if (func.isTrue(i)) {
                result += i;
            }
        }
        return result;
    }

}
