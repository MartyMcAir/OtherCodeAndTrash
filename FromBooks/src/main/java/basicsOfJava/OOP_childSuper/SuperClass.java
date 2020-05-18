/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava.OOP_childSuper;

/**
 *
 * @author MartyMcAir
 */
public class SuperClass {

    private int a, b, c, d, e = 999;
    public String className = "Супер Класс _ SuperClass";

    SuperClass(){}
    
    SuperClass(int c){
        this.c=c;
    }
    
    public int getC(){
        return this.c;
    }
    
    public void setA(int a) {
        this.a = a;
    }
    public int getA() {
        return this.a;
    }

    public int getD33() {
        return this.d=33;
    }
    
    public void setB(int b) {
        this.b = b;
    }
    public int getB() {
        return this.b;
    }
    
    public void showName() {
        System.out.println(className);
    }
}
