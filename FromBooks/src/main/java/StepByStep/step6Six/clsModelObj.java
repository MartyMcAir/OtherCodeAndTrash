/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepByStep.step6Six;

/**
 *
 * @author MartyMcAir
 */
public class clsModelObj {
    Object obj;
    clsModelObj(){}
    clsModelObj(Object obj){
        setObj(obj);
    }
    
    void setObj(Object obj){
        this.obj=obj;
    }
    
    Object getObj(){
        return this.obj;
    }
    
    @Override
    public String toString(){
        return "объект obj из метода toString: "+obj;
    }
}
