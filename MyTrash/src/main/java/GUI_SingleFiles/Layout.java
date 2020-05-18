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
public class Layout extends JFrame{
    JPanel pnl = new JPanel();
        // Создаем контейнер для управления размещением панелек
    Container contentPane = getContentPane();
    // Используем для панели менеджер компоновки GridLayout()
    JPanel grid = new JPanel(new GridLayout(2, 2)); // сетка 2 на 2
    
    Layout(){
        super("Окно Layout"); // название окан
        setSize(500, 200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Добавляем кнопки на панель
        pnl.add(new JButton("Да")); 
        pnl.add(new JButton("Нет"));
        pnl.add(new JButton("Отмена"));
        
        grid.add(new JButton("1"));
        grid.add(new JButton("2"));
        grid.add(new JButton("3"));
        grid.add(new JButton("4"));
        
        contentPane.add("North", pnl); // размещаем панель на севере т.е. вверху
        contentPane.add("Center", grid); // размещаем вторую панель в центре
        // размещаем отдельно кнопку на западе _ запад слева
        contentPane.add("West", new JButton("Запад")); 

    }
    
	public static void main ( String[] args )
	{
		Layout gui = new Layout();
	} 
    
}
