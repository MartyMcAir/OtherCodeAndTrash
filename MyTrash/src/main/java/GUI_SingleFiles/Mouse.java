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
public class Mouse extends JFrame implements MouseMotionListener, MouseListener {

    public static void main(String[] args) {
        Mouse gui = new Mouse();
    }
    JPanel pnl = new JPanel();
    JTextArea txtArea = new JTextArea(13, 63); // текстовое поле	
    int x, y;

    public Mouse() {
        super("Окно Swing");
        setSize(640, 480); // размер области действия указателя в txtArea
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(pnl);

        pnl.add(txtArea); // поле области действия указателя
        txtArea.addMouseMotionListener(this); // генерируем события
        txtArea.addMouseListener(this);
        setVisible(true); // видимость
    }

    @Override
    public void mouseDragged(MouseEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent event) { // координаты указателя
        x = event.getX();
        y = event.getY();
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        txtArea.append("\nmouseClicked : " + x + " Y : " + y);
    }

    @Override
    public void mousePressed(MouseEvent event) { // 
        txtArea.append("\nКнопка нажата, когда указатель в позиции X : " + x + " Y : " + y);
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        txtArea.append("\nКнопка мыши отпущена"); // информирует об отпущенной кнопке
    }

    @Override
    public void mouseEntered(MouseEvent event) {
        txtArea.setText("Нажата кнопка мыши"); // нажата кнопка is..
    }

    @Override
    public void mouseExited(MouseEvent event) {
        txtArea.append("\nmouseExited : " + x + " Y : " + y);
    }

}
