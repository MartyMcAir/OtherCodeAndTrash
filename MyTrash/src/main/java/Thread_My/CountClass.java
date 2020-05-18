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
public class CountClass implements Runnable {

    public static void main(String[] args) {
        // создаем объект класса CommonResClass
        CommonResClass myRes = new CommonResClass();
        // в цикле создаем четыре потока и запускаем их
        for (int i = 1; i < 5; i++) {
            Thread thr = new Thread(new CountClass(myRes));
            thr.setName("Поток " + i);
            thr.start();
        }
    }
    CommonResClass res;

    // конструктор класса
    CountClass(CommonResClass res) {
        this.res = res;
    }

    // реализация метода run()
    @Override
    public void run() {
        // объявляем ресурс res как синхронизированный
        synchronized (res) {
            // присваиваем полю объекта начальное значение
            res.x = 1;
            for (int i = 1; i <= 5; i++) {
                System.out.printf("%s %d \n", Thread.currentThread().getName(), res.x);
                res.x++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
