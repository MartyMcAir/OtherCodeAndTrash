/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaForWeek.myThread;

/**
 *
 * @author MartyMcAir
 */
public class MyThreadConsole extends Thread{
    @Override
    public void run(){
        System.out.println("Поток 1 консоли MyThreadConsole");
    }
}
