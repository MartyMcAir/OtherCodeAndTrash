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
public class GenericA<T, T1> {
    private T obj;
    private T1 obj1;
    
    public void setObj(T obj) {
        this.obj = obj;
    }
    public T getObj() {
        return this.obj;
    }
    public void showObj() {
        System.out.println("ваш объект: " + obj);
    }
    
    public void setobj1(T1 obj1){
        this.obj1=obj1;
    }
    public T1 getobj1() {
        return this.obj1;
    }
    public void showObj1() {
        System.out.println("ваш объект: " + obj1);
    }
}
