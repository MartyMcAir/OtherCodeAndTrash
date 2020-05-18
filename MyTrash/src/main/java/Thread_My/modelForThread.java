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
public class modelForThread {
    public int num1, num2;
    
    public int getNum1(){
    return num1;
    }
    public void setNum1(int num1){
    this.num1=num1;
    }

    public int getNum2(){
    return num2;
    }
    public void setNum2(int num2){
    this.num2=num2;
    }
    
    public int getOth(){
    return 999;
    }
    
    public void getThreadName(){
    Thread txr = new Thread();
    System.out.println("имя потока" + txr.getName() );
    }
}
