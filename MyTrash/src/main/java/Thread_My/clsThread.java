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
public class clsThread implements Runnable {
    @Override
    public void run() {
        Thread txr = Thread.currentThread();
        System.out.println("Имя текущего потока " + txr.getName());
        
        try{ Thread.sleep(2500); }
        catch(InterruptedException e) {
        System.out.println("Прерывание текущ дочернего потока "); }
    }
    
}
