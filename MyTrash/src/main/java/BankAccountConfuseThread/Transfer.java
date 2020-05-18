/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BankAccountConfuseThread;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author MartyMcAir
 */
public class Transfer implements Callable<Boolean> {

    private Account acc1;
    private Account acc2;
    private int rnd; // случайное число для исскуственной задержки в sleep(..)
    private static int id; // id потока
    private int amount;

    public Transfer(Account acc1, Account acc2, int rnd) {
        this.acc1 = acc1;
        this.acc2 = acc2;
        this.rnd = rnd;
    }

    public Transfer(Account acc1, Account acc2, int rnd, int id) {
        this.acc1 = acc1;
        this.acc2 = acc2;
        this.rnd = rnd;
        this.id = id;
    }

    @Override
    public Boolean call() throws Exception {
        // tryLock - что-то для блокировки монитора..!?
        if (acc1.getLock().tryLock(3, TimeUnit.SECONDS)) {
            try {
                if (acc1.getTransfering() < acc2.getBalance()) {
                    System.out.println("на счете 2 нет столько денег: "
                            + acc1.getTransfering() + ", а есть: " + acc2.getBalance());
//                    System.out.println("InsufficientSumException");
//                        throw new InsufficientSumException();
                    return false;
                    // ..
                } else {
                    acc1.setBalance(acc1.getBalance() + acc1.getTransfering());
                    acc2.setBalance(acc2.getBalance() - acc1.getTransfering());
                    System.out.println("acc1 balance: " + acc1.getBalance()
                            + "transfering from acc2: " + acc1.getTransfering());
                    System.out.println("acc2 balance: " + acc2.getBalance());
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            acc1.incFailCount();
            return false;
        }
        return null;
    }

}
