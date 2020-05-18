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
public class zzzAbsCat extends zzzAbsAnimal{

    zzzAbsCat(){}
    zzzAbsCat(String s, String d){
        sound=s;
        doo=d;
    }
    
    @Override
    void dois() {
        System.out.println("коты делают: "+doo);
    }

    @Override
    void soundis() {
        System.out.println("коты звучат: "+sound);
    }
    
    void additional(){
        System.out.println("\n(zzzAbsCat extends zzzAbsAnimal) этот метод"
                + " не будет доступен, через восходящее приведение");
    }
    
}
