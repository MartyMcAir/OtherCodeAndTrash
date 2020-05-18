/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._callBack_GUI;

import javax.swing.*;

/**
 *
 * @author MartyMcAir
 */
public class SomeClass {
    private Callback callback;
    String replyTo;
    
    // SeT'ter
    public void registerCallBack(Callback callback){
        this.callback=callback;
    }
    
    void doSomething(){
//        JOptionPane.showMessageDialog(null, "Выполняется работа");
        int reply = JOptionPane.showConfirmDialog(null, "Вопрос  y/n");
        if(reply==JOptionPane.NO_OPTION){
            replyTo="Нет";
        }
        if(reply==JOptionPane.YES_OPTION){
            replyTo="Да";
        }
//        if(reply==JOptionPane.CANCEL_OPTION){
//            replyTo="Cancel";
//        }
        
        // вызываем метод обратного вызова (с интерфейса)
        callback.callingBack(replyTo);
    }
    
}
