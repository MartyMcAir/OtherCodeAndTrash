/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calc;

import javax.swing.*;

/**
 * @author MartyMcAir
 */
public class Calc_gui {

    public static void main(String[] args) {

        // Объявляем переменные главного класса
        int input1, input2;
        String inputString;

        // Создаем объект класса MyClass
        // чтобы использовать поля и методы класса надо создать объект этого класса "obj"это фактические объектная переменная которая на него ссылается
        Calc_gui obj = new Calc_gui();

        // Присваиваем значения полям
        //ссылаясь на экземпляр класса "demo" получаем доступ к полям класса "MyClass"
        obj.data = 1234;
        obj.letter = 'B';
        // Выводим значения полей на печать
        System.out.println("Число: " + obj.data);
        System.out.println("Буква: " + obj.letter);

        // Вызов метода, выполняющего сложение c передачей аргументов "(4, 5)"
        System.out.println("Сумма чисел 4+5=" + obj.summ(4, 5));

        // Окно ввода первого значения
        inputString = JOptionPane.showInputDialog("Введите первое значение");
        input1 = Integer.parseInt(inputString);
        // Окно ввода второго значения
        inputString = JOptionPane.showInputDialog("Введите второе значение");
        input2 = Integer.parseInt(inputString);

        // Вызываем метод для присвоения значений полям объекта
        obj.set(input1, input2);
        // Выводим в диалоговое окно результат умножения
        JOptionPane.showMessageDialog(null, "Результат умножения: " + obj.multiply());

    }

    // Поля класса
    // фактически просто переменные класса или ссылки на другие объекты
    int data;
    char letter;
    int fieldOne, fieldTwo;

    // Описание метода, выполняющего сложение
    int summ(int a, int b) {
        int summa = a + b;
        return summa;
    }

    // Метод для присваивания значений полям
    void set(int a, int b) {
        fieldOne = a;
        fieldTwo = b;
    }

    // Метод для перемножения значений полей
    int multiply() {
        return fieldOne * fieldTwo;
    }
}
