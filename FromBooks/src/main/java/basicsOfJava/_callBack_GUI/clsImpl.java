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
public class clsImpl implements Callback{

    @Override
    public void callingBack(String s) {
        System.out.println("Вызов метода обратного вызова");
         if(s!=null){
             System.out.println("Ваш ответ: "+s);
         } else {
             System.out.println("Вы не ответили.");
         }
    }
    
}
