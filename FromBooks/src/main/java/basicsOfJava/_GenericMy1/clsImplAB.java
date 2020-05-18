/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._GenericMy1;

/**
 *
 * @author MartyMcAir
 */
public class clsImplAB implements intrfA, intrfB{

    @Override
    public void showAnyA() {
        System.out.println("Переопределенныйй метод showAnyA() из clsImplAB");
    }

    @Override
    public void showAnyB() {
        System.out.println("Переопределенныйй метод showAnyB() из clsImplAB");
    }
    
}
