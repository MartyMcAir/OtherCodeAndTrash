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
public class Buttons extends JFrame {

    JPanel pnl = new JPanel();

    // НЕ РАБОТАЕТ err - NullPointerException
//	ClassLoader ldr = this.getClass().getClassLoader();
//	java.net.URL tickURL = ldr.getResource("tick.png");
//	java.net.URL crossURL = ldr.getResource("cross.png");
    
    // Подгружаем изображения для кнопок
//    ImageIcon tick = new ImageIcon("events.png"); // tесли  находится в корневой папке проекта
    // полный путь
//    ImageIcon tick = new ImageIcon("C:\\z_n\\Dropbox\\GitHub\\myCodeExamples\\myCodeExamples\\build\\classes\\GUI_SingleFiles\\events.png");
// путь до картинки относительно корневой папки проекта, взависимсоти от то го, где находится проект
    ImageIcon tick = new ImageIcon(".\\build\\classes\\GUI_SingleFiles\\events.png"); 
    ImageIcon cross = new ImageIcon(".\\build\\classes\\GUI_SingleFiles\\addEvent.png");

    //ImageIcon tick = new ImageIcon( "tick.png" );
    //ImageIcon cross = new ImageIcon( "cross.png" );
    JButton btn = new JButton("Нажми меня");
    JButton tickBtn = new JButton(tick);
    JButton crossBtn = new JButton("СТОП", cross);

    public Buttons() {
        super("Окно Buttons");
        setSize(500, 200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(pnl);

        pnl.add(btn);
        pnl.add(tickBtn);
        pnl.add(crossBtn);
    }

    public static void main(String[] args) {
        Buttons gui = new Buttons();
    }
}
