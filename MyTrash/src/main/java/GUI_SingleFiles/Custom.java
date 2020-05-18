/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_SingleFiles;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author MartyMcAir
 */
public class Custom extends JFrame{
    JPanel pnl = new JPanel();
    
    JLabel jbl1 = new JLabel("Задний фон _ Background");
    JLabel jbl2 = new JLabel("Передний фон цвет шрифта _ Foreground");
    JLabel jbl3 = new JLabel("Пользовательскй шрифт");
    
    Color customColor = new Color(255, 0 , 0); // RGB Red Green Blue
    Font custonFont = new Font("Serif", Font.BOLD, 23);
    
    Custom(){
        super("Окно Custom");
        setSize(500, 150);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(pnl);
     
        jbl1.setOpaque(true); // делаем метку непрозрачной
        jbl1.setBackground(Color.GREEN);
        jbl2.setForeground(customColor);
        jbl3.setFont(custonFont);
        
        pnl.add(jbl1);
        pnl.add(jbl2);
        pnl.add(jbl3);
    }
    
	public static void main ( String[] args )
	{
		Custom gui = new Custom();
	} 
    
}
