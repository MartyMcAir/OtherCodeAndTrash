/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thread_My;

/**
 *
 * @author MartyMcAir
 */
public class clsThreadExtends extends Thread{
    @Override
    public void run(){
    Thread thr1 = Thread.currentThread();
    thr1.getName();
    System.out.println("Имя текущего потока" + thr1.getName());
    }
    
    /* */
    // НЕВОЗМОЖНО ИСПОЛЬЗОВАТЬ
    public void run(int num1, int num2){
    Thread thr2 = Thread.currentThread();
    System.out.println("Имя текущего потока" + thr2.getName());
    System.out.println("Аргумент первый" + num1 );
    } /* */
}
