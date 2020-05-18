/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._fInterfLyambda;

/**
 *
 * @author MartyMcAir
 */
public class clsImpl implements intrfDo{

    @Override
    public void showMessage() {
        System.out.println("CallBack в работе");
    }
    
    public void showOth() {
        System.out.println("Другой метод _ impl2::showOth");
    }
    
}
