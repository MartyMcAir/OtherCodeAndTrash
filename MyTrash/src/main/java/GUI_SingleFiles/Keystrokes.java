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
class Keystrokes extends JFrame implements KeyListener {

    public static void main(String[] args) {
        Keystrokes gui = new Keystrokes();
    }
    JPanel pnl = new JPanel();
    // в аргументах размер текстовых полей
    JTextField field = new JTextField(38);
    JTextArea txtArea = new JTextArea(5, 38);

    public Keystrokes() {
        super("Окно Swing");
        setSize(500, 200); // размеры окна
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(pnl);

        pnl.add(field); // добавляем на панель текстовые поля
        pnl.add(txtArea);

        field.addKeyListener(this);
        setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent event) { // после нажатия показывает символ
        txtArea.append("\nСимвол : " + event.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent event) { // распознает нажатие
        txtArea.setText("Нажата клавиша");
    }

    @Override
    public void keyReleased(KeyEvent event) {
        // при отпущеной клавише отображает её код и инфу о ней
        int keyCode = event.getKeyCode();
        txtArea.append("\nКод клавиши : " + keyCode);
        txtArea.append("\nТекст клавиши : " + event.getKeyText(keyCode));
    }

}
