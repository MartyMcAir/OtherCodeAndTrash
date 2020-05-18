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
public class MyButton {
    private IClick ic = null;
    
    MyButton(){}
    MyButton(IClick ic){
        this.ic=ic;
    }
    
    public void reg(IClick ic){  // регистрация сеттер обработчика
        this.ic=ic;
    }
    
    public void click(){ // CallBack функция обратного вызова
        if(ic !=null){
            this.ic.onClick();
        }
    }
}
