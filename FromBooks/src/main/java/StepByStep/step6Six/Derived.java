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
public class Derived extends Base {

    private int a = 33; // значение по умолчанию

    /**
     * one or more public constructors
     */
    public Derived() {
    }

    /**
     * copy-constructor
     */
    protected Derived(Derived src) {
        super(src);
        /* copy or deep-copy the state */
    }

    void setA(int a){
        this.a=a;
    }
    
    int getA(){
        return this.a;
    }
    
    @Override
    public Derived copy() {
        return new Derived(this);
    }
}
