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
public class GenericBox<T> {
    private T obj;
    GenericBox(){}
    
    GenericBox(T obj){
        this.obj = obj;
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
