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
public class clsThreadArgs implements Runnable{
    @Override
    public void run() {
    Thread thrCurrent = Thread.currentThread();
    
    int num1, num2, numOth;
    modelForThread model = new modelForThread();
    num1= model.getNum1(); // нераб
    num2= model.getNum2();
    numOth= model.getOth();
    
    int result= num1-num2; // нераб не получает из вне
    int result2= 10-5; // раб
    
    System.out.println("имя потока из файла аргумент потока: " + thrCurrent.getName());
    System.out.println("Результаты подсчета: " + num1);
    }
    
    // НЕВОЗМОЖНО ИСПОЛЬЗОВАТЬ
    public void run(int num1, int num2){
    Thread thr2 = Thread.currentThread();
    System.out.println("Имя текущего потока" + thr2.getName());
    System.out.println("Аргумент первый" + num1 );
    }
    
}
