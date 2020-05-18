/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._callBack_GUI;

/**
 *
 * @author MartyMcAir
 */
public class clsImpl2 implements Callback {
    @Override
    public void callingBack(String s) {
        System.out.println("Другой метод");
        if (s != null) {
            switch (s) {
                case "Да":
                    System.out.println("Вы нажали Да");
                    break;
                case "Нет":
                    System.out.println("Вы нажали Нет");
                    break;
            }
        } else {
            System.out.println("Вы ничего не нажали 2");
        }
    }
}
