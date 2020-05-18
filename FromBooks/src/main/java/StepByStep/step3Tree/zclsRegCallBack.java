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
public class zclsRegCallBack {
    zInterfShow itf;
    zclsRegCallBack(){}
    
    zclsRegCallBack(zInterfShow itf){
        this.itf=itf;
    }
    
    void callCack(int a, int b){
        itf.show(a, b);
    }
    
}
