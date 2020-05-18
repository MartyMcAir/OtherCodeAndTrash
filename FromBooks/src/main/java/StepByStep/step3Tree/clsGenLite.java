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
public class clsGenLite <T>{
    private T obj;
    clsGenLite(){}
    clsGenLite(T obj){
        this.setObj(obj);
    }
    void setObj(T obj){
        this.obj=obj;
    }
}
