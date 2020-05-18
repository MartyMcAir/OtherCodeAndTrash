/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava.CallBack2;

/**
 *
 * @author MartyMcAir
 */
public class MyButton {
    private IClick ic = null;
    
    // по сути сеттер объекта
    public void reg(IClick ic) { // Регистрация обработчика
        this.ic=ic;
    }
    
    // callback функция обратного вызова
    public void click(){ // нажатие кнопки
        if(this.ic!=null){ // проверка на пустое значение
            this.ic.onClick();
        }
    }
}
