/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepByStep.step3Tree;

/**
 *
 * @author MartyMcAir
 */
// расширям обобщенный класс интерфейсами через слово extends
// Если указать вторым K то он автоматически под К
// Будет подстраивать интерфейс для interfForGen2
// А так он подстраивается только через один T т.е. методы берет через this.obj...
// если бы был K то было бы this.objK. и метод из interfForGen2
// а через this.obj.. метод был бы доступен с interfForGen1
public class clsGenExt <T extends interfForGen1 & interfForGen2>{
    private T obj;
    clsGenExt(){
    }
    clsGenExt(T obj){
        this.obj=obj;;
    }
    
    void runInterfMethods(){
        this.obj.showForGen1(obj.getClass().getName());
        this.obj.showForGen2();
    }
}
