/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_SingleFiles;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author MartyMcAir
 */
public class eventMouseListener extends JFrame implements MouseListener, MouseMotionListener{
    JPanel pnl = new JPanel();
    
    int x, y ;
    JTextArea area1 = new JTextArea(3, 63);
    JTextArea area2 = new JTextArea(3, 63);
    JTextArea area3 = new JTextArea(3, 63);
    
    eventMouseListener(){
        super("Окно eventMouseListener");
        setSize(640, 480);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        add(pnl);
        
        pnl.add(area1);
        pnl.add(area2);
        pnl.add(area3);
        
        // Добавляем генератор событий на всю панель
        pnl.addMouseListener(this);
        pnl.addMouseMotionListener(this);
    }
    @Override   // MouseMotionListener
    public void mouseDragged(MouseEvent event) {    }

    @Override   // MouseMotionListener
    public void mouseMoved(MouseEvent event) { // координаты указателя
        x = event.getX(); y = event.getY();	
    }

    @Override
    public void mousePressed(MouseEvent e) {
        area1.setText( "\nКнопка нажата и её код: "+e.getButton()+", когда указатель в позиции X : " + x + " Y : " + y );
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
        area2.setText("указатель вошел в область c позиции X : " + x + " Y : " + y );
    }

    @Override
    public void mouseExited(MouseEvent e) {
        area3.setText("указатель вышел из области c позиции X : " + x + " Y : " + y );
    }
    
    @Override   // освобождена кнопка мыши
    public void mouseReleased(MouseEvent e) {    }

    @Override   // щелчек кнопкой мыши
    public void mouseClicked(MouseEvent e) {    }
    
    
    public static void main(String[] args) {
        eventMouseListener gui = new eventMouseListener();
    }
    
}
