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
public class Labels extends JFrame {

    JPanel pnl = new JPanel();

    // Подгружаем изображения для кнопок
//    ImageIcon tick = new ImageIcon("events.png"); // tесли  находится в корневой папке проекта
    // полный путь
//    ImageIcon tick = new ImageIcon("C:\\z_n\\Dropbox\\GitHub\\myCodeExamples\\myCodeExamples\\build\\classes\\GUI_SingleFiles\\events.png");
// путь до картинки относительно корневой папки проекта, взависимсоти от то го, где находится проект
    ImageIcon img = new ImageIcon(".\\build\\classes\\GUI_SingleFiles\\events.png");

    JLabel jbl1 = new JLabel(img);
    JLabel jbl2 = new JLabel("технология метки JLabel (на первой картинке ToolTip)");
    JLabel jbl3 = new JLabel("метка с картинкой и по центру _ текст снизу", img, JLabel.CENTER);

    Labels() {
        super("JLabel Labels");
        setSize(500, 200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(pnl);

        jbl1.setToolTipText("toolTip подсказка");

        jbl3.setHorizontalAlignment(JLabel.CENTER);
        jbl3.setVerticalTextPosition(JLabel.BOTTOM);

        pnl.add(jbl1);
        pnl.add(jbl2);
        pnl.add(jbl3);
    }

    public static void main(String[] args) {
        Labels gui = new Labels();
    }

}
