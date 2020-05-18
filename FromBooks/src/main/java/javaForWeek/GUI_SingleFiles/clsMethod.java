/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaForWeek.GUI_SingleFiles;

import javax.swing.*;

/**
 *
 * @author MartyMcAir
 */
public class clsMethod {

    int num1, num2;

    public static void main(String[] args) {
        new clsMethod().showDialog();
    }

    public void showDialog() {
        //Scanner sc = new Scanner(System.in);
        //sc.nextLine();

        boolean t = true;
        while (t) {
            String number1 = JOptionPane.showInputDialog("Ввведите число 3");
            int numm1 = Integer.parseInt(number1);
            if (numm1 == 3) {
                JOptionPane.showMessageDialog(null, "вы ввели: " + number1);
                setNum1(numm1);
                String number2 = JOptionPane.showInputDialog("Введите второе число");
                int numm2 = Integer.parseInt(number2);
                if (numm2 != 0) {
                    setNum2(numm2);
                    JOptionPane.showMessageDialog(null, "Результат сложения: " + summ());
                    t = false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "неверное значение! попробуйте еще раз");
            }

        }
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public int summ() {
        int res = num1 + num2;
        return res;
    }

    public String overload(String name) {
        return name;
    }

    public int overload(int digital) {
        return digital;
    }
}
