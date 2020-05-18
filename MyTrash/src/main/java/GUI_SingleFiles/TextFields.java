/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_SingleFiles;

import javax.swing.*;

/**
 *
 * @author MartyMcAir
 */
public class TextFields extends JFrame{
    JPanel pnl = new JPanel();
    JTextField txt1 = new JTextField(38);
    JTextField txt2 = new JTextField("текс поля", 38);
    JTextArea txtArea = new JTextArea(5, 27);
    JScrollPane pane = new JScrollPane(txtArea);
    
    TextFields(){
        super("Окно TextFields");
        setSize(500, 200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(pnl); // добавляем объект панели на окно
        
        txtArea.setLineWrap(true); // перенос слов
        txtArea.setWrapStyleWord(true);
        // всегда показывать скролл бар
        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        // добавляем на панель элементы
        pnl.add(txt1); //
        pnl.add(txt2);
        pnl.add(pane); // add JScrollPane вместе с его содержимым т.е. текст полем
        
    }
 
    public static void main(String[] args) {
        TextFields gui = new TextFields();
    }
    
}
