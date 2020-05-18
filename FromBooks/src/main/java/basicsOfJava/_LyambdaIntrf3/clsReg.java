/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._LyambdaIntrf3;

/**
 *
 * @author MartyMcAir
 */
public class clsReg {
    intrfWith2arg intrf;
    
    public void regSet(intrfWith2arg intrf){
        this.intrf=intrf;
    }
    
    public void callback(int a, int b){
        intrf.showCalc(a, b);
    }
}
