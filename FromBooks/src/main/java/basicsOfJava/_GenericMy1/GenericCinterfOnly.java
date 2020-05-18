/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._GenericMy1;

/**
 *
 * @author MartyMcAir
 */
public class GenericCinterfOnly<T extends intrfA & intrfB> {
    private T obj;
    
    public void setObj(T obj) {
        this.obj = obj;
    }
    public T getObj() {
        return this.obj;
    }
    public void showObj() {
        System.out.println("ваш объект ограниченный интерфейсами: " + obj);
    }
    
    // CallBack для методов двух интерфейсов
    public void callBackForInterf(){
        this.obj.showAnyA();
        this.obj.showAnyB();
    }
}
