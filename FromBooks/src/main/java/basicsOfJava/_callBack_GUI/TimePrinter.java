/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._callBack_GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Date;

/**
 *
 * @author MartyMcAir
 */
public class TimePrinter implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent event) {
        Date now = new Date();
        System.out.println("Звонок, время: "+now);
        Toolkit.getDefaultToolkit().beep();
    }
    
}
