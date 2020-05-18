/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_SingleFiles;

    // импортируем класс JOptionPane из библиотеки Swing

import javax.swing.*;

/**
 *
 * @author MartyMcAir
 */
public class JoptionModal {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int yearNow, yearBorn, userAge;
        String userDate;
        
        // выводим окно запроса текущей даты
        userDate=JOptionPane.showInputDialog("Какой сейчас год? ");
        //Преобрзуем строку в число
        yearNow=Integer.parseInt(userDate);
        userDate=JOptionPane.showInputDialog("В каком году вы родились? ");
        yearBorn=Integer.parseInt(userDate);
        
        userAge=yearNow-yearBorn;
        //Выводим окно с результатом
        JOptionPane.showMessageDialog(null,"Ваш возраст: " +userAge);
        
        
    }
    
}
