/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepByStep.step6Six;

import java.util.Date;

/**
 *
 * @author MartyMcAir
 */
public class clsClone {

    private int a;
    private Date b;

    clsClone() {
    }

    clsClone(int a) {
        this.a = a;
        this.b = new Date();
    }

    clsClone(int a, Date b) {
        this.a = a;
        this.b = b;
    }

    void setA(int a) {
        this.a = a;
    }

    void setB(Date b) {
        this.b = b;
    }

    int getA() {
        return this.a;
    }

    Date getB() {
        return this.b;
    }

    @Override
    public clsClone clone() {
        clsClone obj = null;
        try {
            obj = (clsClone) super.clone();
        } catch (CloneNotSupportedException e){
            e.printStackTrace();
            System.exit(1);
        }
        obj.b= (Date) this.b.clone();
        return obj;
    }

}
