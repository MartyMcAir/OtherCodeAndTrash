/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaForWeek.GUI_SingleFiles;

import javax.swing.*;
import java.util.Random;

/**
 *
 * @author MartyMcAir
 */
public class TryCatchRnd_Lotto {

    public static void main(String[] args) {
        new TryCatchRnd_Lotto().lotto();
    }

    public void lotto() {
        Random rnd = new Random();
        int secret = rnd.nextInt(10);
        int userInput;
        Exception myexcept = new Exception("badNumber");
        while (true) {
            String userData = JOptionPane.showInputDialog(null, "Введите число от 1 до 10_ "
                    + "(для вызова исключений класса MyExcept введите 11 или 12) :" + secret);
            int user_res = Integer.parseInt(userData);
            try {
                if (user_res == secret) {
                    JOptionPane.showMessageDialog(null, "Угадали!");
                    break;
                } else if (user_res == 11) {
                    // Укороченная форма вброса, при этом автоматически создается java машиной
                    // Анонимный объект (экземпляр класса) MyException  и ссылка на него
                    throw new MyException(11);
                } else if (user_res == 12) {
                    throw new MyException(12);
                } else if (user_res > 12) {
                    throw myexcept;
                }
            } catch (NumberFormatException e) {
                if (e.toString().contains(null)) {
                    System.exit(0);
                }
                JOptionPane.showMessageDialog(null, "Вы ввели недопустимоое значение!");
            } catch (MyException e) {
                JOptionPane.showMessageDialog(null, "Вызван пользовательский класс "
                        + "обработчик исключений: " + e);
            } catch (Exception e) {
                if (e.toString().contains("badNumber")) {
                    JOptionPane.showMessageDialog(null, "Вы вввели недопустимую цифру!: " + userData);
                }
            }
        }
    }

    public void rndShow() {
        Random rnd = new Random();
        int random = rnd.nextInt(10);
        int userData;
        boolean flag = true;
        while (flag) {
            String userInput = JOptionPane.showInputDialog("Угадайте число от 1-до10.. это число: "
                    + random);
            try {
                int user_res = Integer.parseInt(userInput);
                if (user_res <= 10) {

                    if (user_res == random) {
                        JOptionPane.showMessageDialog(null, "Поздравляем вы угадали!: "
                                + userInput);
                        flag = false;
                    } else {
                        JOptionPane.showConfirmDialog(null, "Не угадали попробуйте ещё раз!",
                                "Окно Information", JOptionPane.INFORMATION_MESSAGE);
                    }

                } else {
                    JOptionPane.showConfirmDialog(null, "Вы ввели недопустимое число!: "
                            + userInput, "Окно Warning предупреждение", JOptionPane.WARNING_MESSAGE);
                }

            } catch (NumberFormatException e) {
                if (e.toString().contains(null)) {
                    flag = false;
                    System.exit(0);
                } else {
                    JOptionPane.showConfirmDialog(null, "Вы ввели недопустимое значение, заново!"
                            + userInput, "Окно предупреждение Warning", JOptionPane.WARNING_MESSAGE);
//                    JOptionPane.showConfirmDialog(null, "Неизвеcтная ошибка!: "
//                            + e.getMessage(), "Окно ошибки", JOptionPane.ERROR_MESSAGE);
                }
            } finally {
                //JOptionPane.showMessageDialog(null, "Финальный блок сработал!", "Окно финального блока", JOptionPane.OK_CANCEL_OPTION);
            }
        }
    }
}
