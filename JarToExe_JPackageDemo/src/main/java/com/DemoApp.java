package com;


import javax.swing.*;
import java.awt.*;

public class DemoApp {
    public static void main(String[] args) {
        System.out.println("Hello Demo");
        new MyFrame();
    }

    public static class MyFrame extends JFrame {
        public MyFrame() throws HeadlessException {
            super("MyFrame title working!");

            setDefaultLookAndFeelDecorated(true);
            this.setSize(300, 150);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLayout(new GridLayout(3, 1));

            setLocationRelativeTo(null);
            setVisible(true);
        }
    }
}