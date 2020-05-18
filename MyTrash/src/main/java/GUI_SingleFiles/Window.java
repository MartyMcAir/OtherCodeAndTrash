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
public class Window extends JFrame{
    JPanel pnl = new JPanel();
    
//    // ключ слово this и метод getClass() используются для ссылки на объект класса
//    // используем класс ClassLoader для включения изображения в jar файл при компиляции
//    ClassLoader ldr = this.getClass().getClassLoader();
//    URL tickURL = ldr.getResource("C:\\z_n\\netbeans_p2\\z_06_01_19\\src\\z_06_01_19\\events.png");
//    ImageIcon tick = new ImageIcon(tickURL); // НЕ РАБОТАЕТ err - NullPointerException
    
    // Подгружаем изображения для кнопок
//    ImageIcon tick = new ImageIcon("events.png"); // tесли  находится в корневой папке проекта
    // полный путь
//    ImageIcon tick = new ImageIcon("C:\\z_n\\Dropbox\\GitHub\\myCodeExamples\\myCodeExamples\\build\\classes\\GUI_SingleFiles\\events.png");
// путь до картинки относительно корневой папки проекта, взависимсоти от то го, где находится проект
    ImageIcon tick = new ImageIcon(".\\build\\classes\\GUI_SingleFiles\\events.png"); 
    ImageIcon cross = new ImageIcon(".\\build\\classes\\GUI_SingleFiles\\addEvent.png");
        
    // Создаем кнопки
    JButton btn1 = new JButton("press ME"); // текс кнопки
    JButton btnTick = new JButton(tick); // иконка кнопки
    JButton btnCross = new JButton("add Event _STOP", cross); // текс и иконка
    
    Window(){
        super("Окно Window");
        setSize(500, 150);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(pnl); // добавляем объект панели на окно
        
        // Добавляем кнопки на панель
        pnl.add(btn1);
        pnl.add(btnTick);
        pnl.add(btnCross);
    }
    
    public static void main(String[] args) {
        Window gui = new Window();
    }
    
}
