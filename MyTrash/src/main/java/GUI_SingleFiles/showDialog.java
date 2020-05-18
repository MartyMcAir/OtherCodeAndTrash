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
public class showDialog extends JFrame implements ActionListener{
    JPanel pnl = new JPanel();
    
    JButton btn1 = new JButton("Показать информационное сообщение");
    JButton btn2 = new JButton("Показать предупреждение");
    JButton btn3 = new JButton("Показать сообщение об ошибке");
    
    showDialog(){
        super("Окно showDialog");
        setSize(500, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        add(pnl);
        
        pnl.add(btn1);
        pnl.add(btn2);
        pnl.add(btn3);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn1){
            JOptionPane.showMessageDialog(this, "Информация", 
                    "Диалоговое сообщение", JOptionPane.INFORMATION_MESSAGE);
        } else if(e.getSource()==btn2){
            JOptionPane.showMessageDialog(this, "Предупреждение", 
                    "Диалоговое сообщение", JOptionPane.WARNING_MESSAGE);            
        } else if(e.getSource()==btn3){
            JOptionPane.showMessageDialog(this, "Ошибка", 
                    "Диалоговое сообщение", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String[] args) {
        showDialog gui = new showDialog();
    }
    
}
