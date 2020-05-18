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
public class clsGen1 <T>{
    private T obj;
    clsGen1(){}
    clsGen1(T obj){
        this.obj=obj;
    }
    
    void showGen1(){
        System.out.println("showGen1 _ clsGen1 <T> obj: "+obj);
    }
}
