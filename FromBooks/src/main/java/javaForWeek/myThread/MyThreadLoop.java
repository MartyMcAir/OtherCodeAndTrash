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
public class MyThreadLoop implements Runnable {

    public static void main(String[] args) {
        Thread thr1 = new Thread(new MyThreadLoop());
        Thread thr2 = new Thread(new MyThreadLoop());
        thr2.setName("второй поток: ");

        thr1.start();
        thr2.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Текущий поток: " + Thread.currentThread().getName()
                    + " его цикл #" + i);
        }
    }

}
