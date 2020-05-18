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
public class clsMethods {
    public void division(int a, int b){
        System.out.println("division: "+a+"/"+b+"="+(a/b));
    }
    public void multiply(int a, int b){
        System.out.println("mutiply: "+a+"*"+b+"="+(a*b));
    }

    public void multiplyAndDivis(int a, int b){
        System.out.println("multiplyAndDivis: ("+a+"*"+b+")"+"/"+b+
                "="+ ( (a*b)/b ) );
    }
}
