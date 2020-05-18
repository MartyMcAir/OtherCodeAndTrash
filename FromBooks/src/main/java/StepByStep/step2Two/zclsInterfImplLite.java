/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepByStep.step2Two;

/**
 *
 * @author MartyMcAir
 */
public class zclsInterfImplLite implements zclsInterfSuper {

    String v;

    @Override
    public void setV(String v) {
        this.v = v;
    }

    @Override
    public String getV() {
        return this.v;
    }

    @Override
    public void showVar() {
        System.out.print(var);
    }

    public static void main(String[] args) {
        zclsInterfImplLite cls = new zclsInterfImplLite();
        cls.setV("test");
        System.out.println("cls.getV(): " + cls.getV());
        cls.showVar();
    }
}
