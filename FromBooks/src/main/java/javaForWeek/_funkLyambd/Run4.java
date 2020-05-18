/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaForWeek._funkLyambd;

/**
 *
 * @author MartyMcAir
 */
public class Run4 {
    public static void main(String[] args){
        clsMethods methods = new clsMethods();
        MyIntrf1 intrf1;
        MyIntrf2 intrf2;
        
        intrf1 = methods::mult;
        intrf2 = methods::mult;
        
        intrf1.doIt();
        intrf2.doIt(6);
    }
}
