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
public class zclsInterfMultiple extends zclsAbsSuper implements zclsInterfSuper, zclsInterface {

    private String v;
// можно наследовать только один базовый СуперКласс, но можно реализовавыть
// произвольное кол-во интерфейсов
    
    @Override
    void setAbsM(String m) {
        System.out.println(m);
    }

    @Override
    String getAbsM() {
        return m;
    }

    @Override
    public void setV(String v) {
        this.m=m;
    }

    @Override
    public String getV() {
        return this.v;
    }

    @Override
    public void showVar() {
        System.out.println(var);
    }

    @Override
    public void overloadMethod() {
        System.out.println("overloadMethod");
    }

    @Override
    public void overloadMethod(String var, int num) {
        System.out.println("var: "+var+", num: "+num);
    }

    @Override
    public void mathMethod(int a, int b) {
        System.out.println("a: "+a+", b: "+b);
    }

//    @Override
//    public void defMethod() {
//        zclsInterface.super.defMethod(); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void defMethod(String str) {
//        zclsInterface.super.defMethod(str); //To change body of generated methods, choose Tools | Templates.
//    }
    
    public static void main(String[]args){
        zclsInterfMultiple cls = new zclsInterfMultiple();
        cls.defMethod();
        cls.defMethod("test line");
    }
}
