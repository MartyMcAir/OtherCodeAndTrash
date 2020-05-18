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
public class clsLoaderModel extends modelForExtends implements Runnable{
    @Override
    public void run() {
        Thread txr = Thread.currentThread();
        txr.setName("Лодер");
        System.out.println("Имя текущего LoaderModel потока  " + txr.getName());

        System.out.println(var4); // раб
        getString(); // не работает
        summ(5,10); // работает
        setVar2("переменная отправленная с потока в модель");

        System.out.println("получаем внутри потока из модели значение: " + getVar1() ); // не работает
    }

}
