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
public class Base {

    private Base src;
    private int a = 33; // значение по умолчанию

    /**
     * one or more public constructors
     */
    public Base() {
    }

    /**
     * copy-constructor
     */
    protected Base(Base src) {
        /* copy or deep-copy the state */
        this.src = src;
    }

    void setA(int a) {
        this.a = a;
    }

    int getA() {
        return this.a;
    }

    public Base copy() {
        return new Base(this);
    }
}
