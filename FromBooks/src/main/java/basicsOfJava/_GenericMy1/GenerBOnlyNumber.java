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
public class GenerBOnlyNumber <T extends Number>{
    private T obj;
    
    public void setObj(T obj) {
        this.obj = obj;
    }
    public T getObj() {
        return this.obj;
    }
    public void showObj() {
        System.out.println("ваш объект ограниченный классом Number: " + obj);
    }
}
