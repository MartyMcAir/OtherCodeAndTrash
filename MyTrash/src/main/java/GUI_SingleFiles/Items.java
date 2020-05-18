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
public class Items extends JFrame{
    JPanel pnl = new JPanel();
    
    String[] toppings = {"Java", "SQL", "XML", "JavaScript" };
    JCheckBox chk1 = new JCheckBox(toppings[0]);
    JCheckBox chk2 = new JCheckBox(toppings[1], true);
    JCheckBox chk3 = new JCheckBox(toppings[2]);
    JCheckBox chk4 = new JCheckBox(toppings[3]);
    
    String[] styles = {"для профессионалов", "простая", "сложная"};
    JComboBox<String> box1 = new JComboBox(styles);
    
    JList<String> lst1 = new JList(toppings);
    
    Items(){
        super("Окно Items");
        setSize(500, 200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(pnl);
    
        pnl.add(chk1);
        pnl.add(chk2);
        pnl.add(chk3);
        pnl.add(chk4);
    
        box1.setSelectedIndex(0);
        pnl.add(box1);
        pnl.add(lst1);
    }
    
	public static void main ( String[] args )
	{
		Items gui = new Items();
	} 
        
}
