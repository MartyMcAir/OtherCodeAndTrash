/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._callBack_GUI;

import javax.swing.*;

/**
 *
 * @author MartyMcAir
 */
public class TimeTest {

    public static void main(String[] args) {
        //  сдесь  что-то не верно
        
        // присваиваем интерфейсной переменной, экземпляр класса реализующий его
        //ActionListener lst = new TimePrinter();

        // Создание таймера, вызывавшего обработчик каждые 10сек
//        Timer t = new Timer(10000, lst);
//        t.start();   // НЕВЕРНО не РАБОТАЕТ

        JOptionPane.showMessageDialog(null, "Завершить программу");
        System.exit(0);
    }
}
