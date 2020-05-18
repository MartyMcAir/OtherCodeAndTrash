/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaForWeek.myThread;

import javax.swing.*;

/**
 *
 * @author MartyMcAir
 */
public class MyThreadDialog extends Thread {
    @Override
    public void run() {
        JOptionPane.showMessageDialog(null, "Поток 2 MyThreadDialog диалогового окна");
    }
}
