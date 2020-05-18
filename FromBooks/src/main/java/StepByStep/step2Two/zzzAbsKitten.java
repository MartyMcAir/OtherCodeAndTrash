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
public class zzzAbsKitten extends zzzAbsCat {
    
    zzzAbsKitten(){}
    zzzAbsKitten(String s, String d){
        super(s, d);
    }
    
    void additionKitten(){
        System.out.println("метод из zzzAbsKitten extends zzzAbsCat");
    }
}
