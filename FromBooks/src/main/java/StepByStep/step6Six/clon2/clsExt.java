/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepByStep.step6Six.clon2;

/**
 *
 * @author MartyMcAir
 */
public class clsExt extends User1{
    String test1="test line";
    String getStr(){
        return this.test1;
    }
    void setStr(String str){
        this.test1= str;
    }
}
