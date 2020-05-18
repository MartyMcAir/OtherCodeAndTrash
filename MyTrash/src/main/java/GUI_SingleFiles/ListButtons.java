/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_SingleFiles;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 *
 * @author MartyMcAir
 */
public class ListButtons extends JFrame implements ItemListener{
    JPanel pnl = new JPanel();
    
    JTextField txt = new JTextField("текст поля ");
    // Объявляем и инициализируем массив для отправки в JComboBox
    String[] itemList = {"Red", "Green", "Blue"};
    JComboBox<String> jbox = new JComboBox(itemList); 
    
    
    ListButtons(){
        super("Окно ListButtons for JComboBox<E>");
        setSize(500, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        add(pnl);
        // Добавляем на панель графические элементы
        pnl.add(txt);
        pnl.add(jbox);
        // генератор события для выпадающего меню
        jbox.addItemListener(this);
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        // проверка на выбранный пункт меню
        if(e.getItemSelectable()==jbox){
            txt.setText(" "+ e.getItem().toString());
        }
    }
    
    public static void main(String[] args) {
        ListButtons gui = new ListButtons();
    }
    
}
