/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zzz;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MartyMcAir
 */
public class Tmp {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MyThread());
        t1.start();
        Thread t2 = new Thread(new MyThread(t1));
//        t1.join();
        t2.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            System.out.println("ffffffffffffff");
//            Logger.getLogger(TmpSup1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static class MyThread implements Runnable {

        private static int i = 0;
        private Thread another;

        public MyThread(Thread another) {
            this.another = another;
            try {
                another.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Tmp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        public MyThread() {
        }

        @Override
        public void run() {
            Thread current = Thread.currentThread();
            String state = current.getState().toString();
            try {
                while (true) {
                    System.out.println("state is: " + state + ", i:" + (++i)
                            + ", name is:" + current.getName());
                    Thread.sleep(500);
                    if (i == 6) {
                        current.interrupt();
                        i = -1;
                    }
                }
            } catch (InterruptedException ex) {
                System.out.println("--- FINISH--- FOR: " + current.getName());
//                Logger.getLogger(TmpSup1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
