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
public class zzzAbsDog extends zzzAbsAnimal{

    zzzAbsDog(){}
    zzzAbsDog(String s, String d){
        sound=s;
        doo=d;
    }
    
    @Override
    void dois() {
        System.out.println("собаки делают: "+doo);
    }

    @Override
    void soundis() {
        System.out.println("собаки звучат: ");
    }
    
}
