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
public class clsActions extends JFrame implements ActionListener {

    public static void main(String[] args) {
        clsActions gui = new clsActions();
    }
    JPanel pnl = new JPanel();

    JButton btn1 = new JButton("Кнопка 1");
    JButton btn2 = new JButton("Кнопка 2");
    JTextArea txtArea = new JTextArea(5, 38);

    public clsActions() {
        super("Swing Window");
        setSize(500, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(pnl);

        pnl.add(btn1);
        pnl.add(btn2); // добавляем кнопки на  Jpanel
        pnl.add(txtArea); // добавляем текстовую обл на Jpanel

        btn2.setEnabled(false); // false компонент события прерван
        txtArea.setText("Кнопка 2 деактивирована");

        btn1.addActionListener(this); // оператор генерирует события
        btn2.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        txtArea.setText(event.getActionCommand() + " Нажата и деактивирована");

        if (event.getSource() == btn1) {
            btn2.setEnabled(true);
            btn1.setEnabled(false);
        }

        if (event.getSource() == btn2) {
            btn1.setEnabled(true);
            btn2.setEnabled(false);
        }
    }

}
