/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_SingleFiles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author MartyMcAir
 */
public class eventActionListener extends JFrame implements ActionListener{
    JPanel pnl = new JPanel();
    
    JButton btn1 = new JButton("Press me");
    JTextField txt1 = new JTextField("Кнопка не нажата");
    
    eventActionListener(){
        super("Окно eventActionListener");
        setSize(500, 100);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(pnl);
        
        pnl.add(btn1);
        pnl.add(txt1);
        btn1.addActionListener(this); // генерируем события для кнопки
    }
    
    // actionPerformed() - метод обработчика событий
    @Override
    public void actionPerformed(ActionEvent e) {
        // e.getSource() получаем объект вызвавший событие
        if(e.getSource()==btn1){
            txt1.setText("Кнопка нажата!");
        }
    }
    
    public static void main(String[] args) {
        eventActionListener gui = new eventActionListener();
    }
    
}
