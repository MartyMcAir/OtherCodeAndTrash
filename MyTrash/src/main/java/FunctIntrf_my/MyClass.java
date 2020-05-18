/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctIntrf_my;

/**
 *
 * @author MartyMcAir
 */
public class MyClass {

    public static void main(String[] args) {
        // создаем объект класса
        MyClass obj = new MyClass();
        // объявляем интерфейсную переменную
        myInterface tmp;
        // формируем массив исходных значений
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i : nums) {
            obj.show();
            if (i % 2 == 0) { // если делится на два
                // то используем метод деления на два
                tmp = obj::div2;
            } else { // для всех остальных
                // выводим исходное число
                tmp = obj::none;
            }
            System.out.println(tmp.calc(i));
        }

        /* */
        MyClass.show3();
        clsSuper sups = new clsSubCls();
        sups.showNow();
        sups.showNowSup();
        /* */
        char ch = 'g';

        System.out.println(ch);
        /* НИСХОДЯЩЕЕ ПРИВЕДЕНИЕ ВЫДАЕТ ОШИБКУ *
        clsSuper sups2 = new clsSuper();
        ((clsSubCls)sups2).showNow();
        ((clsSubCls)sups2).showNowSub();
        /* */
    }

    // деление на два
    int div2(int n) {
        return n / 2;
    }

    // просто возвращаем значение
    int none(int n) {
        return n;
    }

    public void show() {
        System.out.println("test");
    }

    public void show2() {
        System.out.println("test2");
    }

    static void show3() {
        System.out.println("test3");
    }

    @FunctionalInterface
    public interface myInterface {

        int calc(int n);
    }
}
