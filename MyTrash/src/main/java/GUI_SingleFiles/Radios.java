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
public class Radios extends JFrame{
    JPanel pnl = new JPanel();
    
    JRadioButton rad1 = new JRadioButton("Red", true);
    JRadioButton rad2 = new JRadioButton("Pink");
    JRadioButton rad3 = new JRadioButton("White");
    
    ButtonGroup wines = new ButtonGroup();
            
    Radios(){
        super("Окно Radios");
        setSize(500, 100);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(pnl);
        
        wines.add(rad1);
        wines.add(rad2);
        wines.add(rad3);
        
        pnl.add(rad1);
        pnl.add(rad2);
        pnl.add(rad3);
    }
    
    public static void main(String[] args) {
        Radios gui = new Radios();
    }
    
}
