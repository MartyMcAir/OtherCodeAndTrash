/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava.getSetObj;

/**
 *
 * @author MartyMcAir
 */
public class Child2 extends SuperClass {
    Object obj;
    Child2(){}
    
    Child2(String str){
        super(str);
    }
    
    public void setObj(Object obj){
        this.obj=obj;
    }
    
    @Override
    public Object getObj(){
        return this.obj;
    }
}
