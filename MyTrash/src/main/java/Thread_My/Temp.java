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
public class Temp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
    modelForThread model = new modelForThread();
    model.setNum1(10);    
    model.setNum2(5);
    
    Thread thr1 = new Thread(new clsThread(), " first");
    Thread thr2 = new Thread(new clsThread(), " second");
    
    thr1.setPriority(1);
    thr2.setPriority(2);
    thr1.start();
    thr2.start();
    
    for(int i=0; i<3; i++){
    System.out.println("Главный поток интерация №" + i);
    Thread.sleep(800);   }
    
    if(thr1.isAlive() || thr2.isAlive()){
    System.out.println("Ждем завершения дочерних потоков" + "\n");
    thr1.join();
    thr2.join();
    }
    
    System.out.println("Все потоки завершены" + "\n");
    
    ////////////////////
    Thread thrArgs = new Thread( new clsThreadArgs(), "Поток с Аргументами");
    thrArgs.setPriority(3);
    thrArgs.run();
    
    System.out.println("имя потока из глав метода: " + thrArgs.getName() );
    System.out.println("получаем из модели: " + model.getNum1());

    // Создание потока методом наследования потока
    clsThreadExtends thrExt = new clsThreadExtends();
    thrArgs.setPriority(4);
    thrArgs.run();
    
    modelForExtends mdlTrx = new modelForExtends();
    mdlTrx.setVar1("Переменная кинутая из глав метода");
    
    Thread loader = new Thread( new clsLoaderModel());
    loader.setPriority(5);
    loader.run();
    System.out.println("вызов метода получить из модели: " + mdlTrx.getVar2() );
    }
    
}
