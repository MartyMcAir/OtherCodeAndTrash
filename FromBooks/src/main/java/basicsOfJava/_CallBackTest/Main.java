/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._CallBackTest;

/**
 *
 * @author MartyMcAir
 */
public class Main {
    public static void main(String[] args) throws InterruptedException{
        intrfDo itd = new clsImpl();
        clsSetter cls = new clsSetter(itd);
        cls.callback();
    }
}
