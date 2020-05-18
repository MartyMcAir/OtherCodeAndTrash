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
public class StartThreads {

    public static void main(String[] args) {
//        clsTryCatchRnd obj = new clsTryCatchRnd();
//        obj.rndShow();
//        obj.lotto();
        StartThreads st = new StartThreads();
        st.startAll();

    }

    public void startAll() {
        // Создаем потоки из наследующих классов
        MyThreadConsole thread1 = new MyThreadConsole();
        MyThreadDialog thread2 = new MyThreadDialog();
        MyThreadDialog2 thread3 = new MyThreadDialog2();
        // Создаем поток из реализующего класса
        Thread thr1 = new Thread(new MyThreadImpl(), "название потока");

        thread1.setName("имя потока");
        // Приоритеты потоков от 1 до 10
        thread1.setPriority(1);
        thread2.setPriority(1);
        thread3.setPriority(1);
        thr1.setPriority(1);

        thread3.setName("Demon -thread");
        thread3.setDaemon(true);

        // Запускаем потоки
        thread1.start();
        thread2.start();
        thread3.start();
        thr1.start();

        System.out.println(thr1);
        System.out.println(thread1);
        System.out.println(thread2);
        System.out.println(thread3);

        Thread thr_t = Thread.currentThread();
        System.out.println(thr_t);
    }
}
