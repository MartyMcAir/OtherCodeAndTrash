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
public class zclsAbsExtLite extends zclsAbsSuper {

    @Override
    void setAbsM(String m) {
        this.m=m;
    }

    @Override
    String getAbsM() {
        return this.m;
    }
    
    public static void main(String[] args){
        zclsAbsExtLite cls = new zclsAbsExtLite();
        cls.setAbsM("тест _ it is work");
        System.out.println("get: "+cls.getAbsM());
    }
}
