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
public class clsGen2 <T, U> extends clsGen1<T> {
    private T objT;
    private U objU;
    clsGen2(){}
    clsGen2(T objT, U objU){
        super(objT);
        this.objT=objT;
        this.objU=objU;
    }
    
    void showGen2(){
        System.out.println("showGen2 _ clsGen2 <T> objT: "+objT+
                ", objU: "+objU);
    }
}
