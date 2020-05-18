/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava.Collections;

import java.util.Date;

/**
 *
 * @author MartyMcAir
 */
public class CloneImplA implements Cloneable{
    private int x;
    private Date d; // Изменяемый объект
    
    public CloneImplA(int x){
        this.x = x;
        this.d = new Date();
    }
    public Date getD(){
        // Изменяемые объеекты возвращ только так
        // через приведение к типу (Date)
        return (Date) this.d.clone();
    }
    // setter времени
    public void newDate(long time){
        this.d.setTime(time);
    }
    @Override   // переопределяем метод клонирования объекта
    public CloneImplA clone(){
        CloneImplA obj = null;
        try{
            // вызов метода из класса Object
            obj = (CloneImplA) super.clone(); 
        } catch (CloneNotSupportedException e){
            e.printStackTrace();
            System.exit(1);
        }
        obj.d = (Date) this.d.clone();
        return obj;
    }
}
