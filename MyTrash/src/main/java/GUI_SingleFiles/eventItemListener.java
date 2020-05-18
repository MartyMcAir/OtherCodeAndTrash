/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_SingleFiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 *
 * @author MartyMcAir
 */
public class eventItemListener extends JFrame implements ItemListener{
    JPanel pnl = new JPanel();
    
    JTextField txt1 = new JTextField("цвет текста по умолчанию");
    JRadioButton radRed = new JRadioButton("красный");
    JRadioButton radGreen = new JRadioButton("зеленый");
    // создаем общую группу для переключателей (для выбора только одного из группы)
    ButtonGroup wines = new ButtonGroup();
    
    eventItemListener(){
        super("Окно eventItemListener");
        setSize(500, 100);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(pnl);
        // Добавляем переключатели в общую группу
        wines.add(radRed);
        wines.add(radGreen);
        
        pnl.add(txt1);
        pnl.add(radRed);
        pnl.add(radGreen);
        // создаём обработчиков событий для переключателей
        radRed.addItemListener(this);
        radGreen.addItemListener(this);
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getItemSelectable()==radRed){
            txt1.setForeground(Color.RED);
        } else if(e.getItemSelectable()==radGreen){
            txt1.setForeground(Color.GREEN);            
        }
    }
    
    public static void main(String[] args) {
        eventItemListener gui = new eventItemListener();
    }
    
}
