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
abstract public class zzzAbsAnimal {
    String sound, doo;
    zzzAbsAnimal(){}
    zzzAbsAnimal(String s, String d){
        sound=s;
        doo=d;
    }
    
    abstract void dois();
    abstract void soundis();
}
