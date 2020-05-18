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
public class zclsInterfImpl implements zclsInterface {

    String v;

    @Override
    public void overloadMethod() {
        System.out.println("overloadMethod() from zclsInterfImpl implements "
                + "zclsInterface");
    }

    @Override
    public void overloadMethod(String var, int num) {
        System.out.println("overloadMethod() from zclsInterfImpl implements "
                + "zclsInterface var: " + var + ", num: " + num);
    }

    @Override
    public void mathMethod(int a, int b) {
        int res = a + b;
        System.out.println("a+b = " + res);
    }

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
        System.out.println(var);
    }

    public static void main(String[] args) {
        zclsInterfImpl cls = new zclsInterfImpl();
        cls.setV("test");
        System.out.print(cls.getV() + "\n");
        System.out.print("cls.getV(): "+cls.getV() + "\n");
        cls.mathMethod(3, 6);
        cls.additionalMethod();
        
        zclsInterface interf = new zclsInterfImpl();
        interf.setV("test from interface variable");
        System.out.print(interf.getV() + "\n");
        
        cls.defMethod();
        cls.defMethod("тестовая строка");
    }

    void additionalMethod() {
        System.out.println("--- метод не доступен из интерфейсной переменной ---");
    }
}
