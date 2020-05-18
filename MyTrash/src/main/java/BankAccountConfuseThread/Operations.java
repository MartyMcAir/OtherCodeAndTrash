/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BankAccountConfuseThread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MartyMcAir
 */
// FROM 
// https://www.youtube.com/watch?v=g7ynfDFoCL4&list=PL6jg6AGdCNaXo06LjCBmRao-qJdf38oKp&index=2
public class Operations {

    final static Account a = new Account(1000);
    final static Account b = new Account(1000);

    public static void main(String[] args) throws Exception {
        mainV0();
//        mainV1();
//        mainV2();
    }

    public static void mainV2() throws InterruptedException {
        Account acc1 = new Account(100, 350); // перекидывание мани, из одного акк в другой
        Account acc2 = new Account(300, 0);
        Random rnd = new Random(); // для эмуляции радомного ожидания sleep до 3 сек..

        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            service.submit(
                    new Transfer(acc1, acc2, rnd.nextInt(3)));
        }
        service.shutdown();
        service.awaitTermination(100, TimeUnit.SECONDS);
    }

    public static void mainV1() {
        new Thread(new Runnable() {
            public void run() {
                transfer(a, b, 500);
            }

        }).start();

        transfer(b, a, 500);
    }

    public static void mainV0() {
        // симулируем DeadLock при исопльзовании synchronized
        // не удалось получить DeadLock
        runTransferInThread(a, b, 500); // поток 1
        runTransferInThread(b, a, 300); // поток 2
    }

    // обход DeadLock через Lock
    public static void transferWithLock(Account acc1, Account acc2, int amount) {
        if (acc1.getLock().tryLock(amount, TimeUnit.SECONDS)) {
            try {
                if (acc2.getLock().tryLock(amount, TimeUnit.SECONDS)) {
                    try {
                        acc2.getLock().unlock();
                        Thread.sleep(1000); // симулируем задержку после блокировки
                        if (acc1.getBalance() < amount) {
                            System.out.println("IsufficientFundsException");
                        } else {
                            System.out.println("Transfering complete");
                            acc1.withDraw(amount);
                            acc2.deposit(amount);
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    System.out.println("Err");
                }
            } catch (Exception ex) {
                Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                acc1.getLock().unlock();
            }
        } else {
            System.out.println("Err");
        }
    }

    public static void transfer(Account acc1, Account acc2, int amount) {
        // делаем потокобезопасным для конкретных 2х ресурсов
        // блокировка для всех остальных для объектов
        synchronized (acc1) {
            synchronized (acc2) {
                System.out.println("Transfering..");
                try {
                    // для пораждения DeadLock
                    Thread.sleep(1000); // симулируем задержку после блокировки
                    if (acc1.getBalance() < amount) {
                        System.out.println("IsufficientFundsException");
                    } else {
                        System.out.println("Transfering complete");
                        acc1.withDraw(amount);
                        acc2.deposit(amount);
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                    Logger.getLogger(Operations.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
//            throw new IsufficientFundsException();
        Lock l = new ReentrantLock();
        l.lock();
        try {
            // доступ к ресурсу, защищенных этим Lock 
        } finally {
            l.unlock();
        }
    }

    public static void runTransferInThread(Account aa, Account bb, int amount) {
        new Thread(new Runnable() {
            public void run() {
                transfer(aa, bb, amount);
            }
        }).start();
    }
}
