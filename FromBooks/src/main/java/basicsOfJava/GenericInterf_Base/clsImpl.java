/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava.GenericInterf_Base;

/**
 *
 * @author MartyMcAir
 */
// Класс реализующий обобщенный интерфейс
public class clsImpl<T> implements GenericIntrf1<T>{
    private T obj;
    
    @Override
    public void showIntrf1(T t) {
        System.out.println("объект obj: "+this.obj+" "
                + "T t: "+t);
    }
    
    public void setObj(T obj) {
        this.obj = obj;
    }
    public T getObj() {
        return this.obj;
    }
    public void showObj() {
        System.out.println("ваш объект: " + obj);
    }
}
