/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava.lyambdaIntrf2;

/**
 *
 * @author MartyMcAir
 */
public class clsImpl implements IClick {

    @Override
    public void onClick() {
        System.out.println("CallBack в работе");
    }

    public void showOth() {
        System.out.println("Другой метод ");
    }

    public void showOth2() {
        System.out.println("Другой метод 2");
    }

}
