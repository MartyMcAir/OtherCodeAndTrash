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
public class ChildClsForChildcls2 extends ChildClass2{
    String className = "ChildClsForChildcls2";
    ChildClsForChildcls2(){}
    
    ChildClsForChildcls2(int c){
        super (c);
    }
    
    @Override
    public void showName(){
        System.out.println(className);
        System.out.print("метод суперКласса ChildClass2: ");
        super.showName();
    }
}
