/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_SingleFiles;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author MartyMcAir
 */
public class eventKeyListener extends JFrame implements KeyListener{
    JPanel pnl = new JPanel();
    
    JTextField txt1 = new JTextField("поле клавиши нажатой: ");
    JTextField txt2 = new JTextField("поле клавиши освобожденной: ");
    JTextField txt3 = new JTextField("поле после нажатия: ");
    JTextArea area = new JTextArea("ПОЛЕ действия генератора событий");
    
    eventKeyListener(){
        super("Окно eventKeyListener");
        setSize(500, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        add(pnl);
        
        pnl.add(txt1);
        pnl.add(txt2);
        pnl.add(txt3);
        pnl.add(area);
        area.setRows(3);
        area.setColumns(3);
        // Добавляем генераторы событий клавиатура на поле Area
        // Т.е. действовать событие будет только в рамках этого поля
        area.addKeyListener(this);
    }
    @Override
    public void keyTyped(KeyEvent e) {
        txt2.setText("\nСимвол : " + e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Благодаря оператору "+" конкатенации, getKeyChar() автоматически
        // преобразуется в тип данных String
        txt1.setText("клавиша нажата: " + e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        txt3.setText( "\nТекст клавиши : " + e.getKeyText(e.getKeyCode()));
    }
    
    public static void main(String[] args) {
        eventKeyListener gui = new eventKeyListener();
    }
    
}
