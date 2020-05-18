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
public class clsExtends extends clsChild {

    public static void main(String[] args) {
        // Супер класс
        cls3Tree cls3 = new cls3Tree();
        cls3.protectedMethod();
        
        System.out.println("Демонстрация полиморфизма, иерархия наследуемых "
                + "классов, один за другим, с общими методами но переопределенными");
        clsChild clsCh = new clsChild();
        clsCh.publicMethod();
        
        System.out.println();
        clsExtends cls = new clsExtends();
        cls.publicMethod();
    }
    
    @Override
    void publicMethod() {
        System.out.println("метод publicMethod(), "
                + "переопределен в классе clsExtends");
    }
}
