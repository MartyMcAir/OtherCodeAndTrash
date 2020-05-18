/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thread_My;

/**
 *
 * @author MartyMcAir
 */
public class CommonResClass {
    int x=0;
    
    public String var1, var2, var3;
    public String var4 = "пермеменная из модели";
    
    public String getString(){
    return "строка из метода модели";
    }
    
    public String getVar1(){
    return var1;
    }
    public void setVar1(String var1){
    this.var1=var1;
    }

    public String getVar2(){
    return var2;
    }    
    public void setVar2(String var2){
    this.var2=var2;
    }
    
    public void summ(int num1, int num2){
    int res = num1+num2;
    System.out.println("результ сложения " + res);
    }
    
}
