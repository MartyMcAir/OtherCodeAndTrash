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
public class RequestDialog extends JFrame implements ActionListener{
    JPanel pnl = new JPanel();
    
    JTextField txt = new JTextField(38);
    JButton btn1 = new JButton("Запрос подтверждения ");
    JButton btn2 = new JButton("Запрос Вввода ");
    //JButton btn3 = new JButton(" ");
    
    RequestDialog(){
        super("Окно RequestDialog");
        setSize(500, 200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(pnl);
        
        pnl.add(txt);
        pnl.add(btn1);
        pnl.add(btn2);
        
        btn1.addActionListener(this);
        btn2.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn1){
            int n = JOptionPane.showConfirmDialog(this, "Вы согласны?", 
                    "Диалог подтверждения", JOptionPane.YES_NO_CANCEL_OPTION);
            switch(n){
                case 0: txt.setText("Согласен");
                case 1: txt.setText("Не согласен");
                case 2: txt.setText("Отменено");
            }
        } else if(e.getSource()==btn2){
            txt.setText(JOptionPane.showInputDialog(this, "Введите ваш коментарий",
                    "Диалог ввода", JOptionPane.PLAIN_MESSAGE));
        }
    }
    
    public static void main(String[] args) {
        RequestDialog gui = new RequestDialog();
    }
    
}
