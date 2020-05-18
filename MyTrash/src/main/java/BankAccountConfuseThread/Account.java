/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BankAccountConfuseThread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author MartyMcAir
 */
class Account {

    // volatile - не поможет для потокобезопастности
    // т.к. balance+=amount не явл атомарной
    // добавление synchronized transfer(..) - решит, но это блокировка 
    // тоже самое synchronized synchronized withDraw и deposit
    // метода для всех остальных потоков, а чтое еслинеобходимо внести и забрать
    // из конкретного ресурса то юзать блокировку на уровне объекта synchronized(acc1){..
    private volatile int balance = 1000; // по умолчанию
    private int transfering;
//    private volatile int failCounter; 
// лучше чем volatile ил synchronized
// значительно быстрее в 10тки раз
    private AtomicInteger failCounter = new AtomicInteger();

    Lock l = new ReentrantLock();

    public Account(int initialBalance) {
        this.balance = initialBalance;
    }

    public Account(int balance, int transfering) {
        this.balance = balance;
        this.transfering = transfering;
    }

    public void withDraw(int amount) {
        balance -= amount;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    Account getLock() {
        return this.getLock();
    }

    boolean tryLock(int sec, TimeUnit secT) {
        return true;
    }

    int getBalance() {
        return 100;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getTransfering() {
        return transfering;
    }

    public void setTransfering(int transfering) {
        this.transfering = transfering;
    }

    void incFailCount() { // атомарная операция
        System.out.println(failCounter.incrementAndGet());
//        System.out.println((++failCounter));
        System.out.println("transfering Fail, current balance is: " + balance);
    }

    void unlock() {
        this.l.unlock();
    }
}
