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
public class clsGen<T, Number> {

    private T objT;
    private Number objK;

    clsGen() {
    }

    clsGen(T objT, Number objK) {
        this.objK = objK;
        this.objT = objT;
    }

    T getT() {
        return this.objT;
    }

    Number getK() {
        return this.objK;
    }

    void setT(T objT) {
        this.objT = objT;
    }

    void setK(Number objK) {
        this.objK = objK;
    }
}
