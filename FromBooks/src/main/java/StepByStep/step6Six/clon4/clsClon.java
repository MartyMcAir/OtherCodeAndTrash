/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepByStep.step6Six.clon4;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author MartyMcAir
 */
public class clsClon implements Cloneable {

    private LocalDate ld ;//=LocalDate.now(); // don't have clone method
    // Если перменную Date только объявить т.е. без инициализации, 
    // то при клонировании будет null
    private Calendar cal;
    private Date d = new Date(); // have clone method
    private String str; // have clone method
    private int[] arr;
    
    clsClon() {    }
    clsClon(LocalDate ld) {
        this.ld = ld;
    }
    
    void setCalendar(Calendar cal){
        this.cal=cal;
    }
    
    Calendar getCalendar(){
        return this.cal;
    }
    
    void setArr(int[] arr){
        this.arr=arr;
    }
    int[] getArr(){
        return this.arr;
    }
    
    void setStr(String str){
        this.str=str;
    }
    
    String getStr(){
        return this.str;
    }
    
    void setDate(Date d){
        this.d=d;
    }
    
    Date getDate(){
        return this.d;
    }
    
    void changeDate(Long time){
        d.setTime(time);
    }
    
    LocalDate getLd(){
        return this.ld;
    }
    
    void ldMinusMonth(int a){
        this.ld.minus(Period.ofMonths(a));
    }
    
    String formatLd(int year, int month, int day){
        SimpleDateFormat sdf = new SimpleDateFormat();
        Calendar cal = Calendar.getInstance();
        cal.set(year, (month-1),day ); // err мес показывает на 1 больше 
        return sdf.format(cal.getTime());
    }
    
    @Override
    public clsClon clone(){
        clsClon obj=null;
        try{
            obj= (clsClon) super.clone();
            obj.d= (Date) this.d.clone(); // если закоментить, то клон не будет полноценным
            obj.cal= (Calendar) this.cal.clone();
//            obj.arr= (int[]) this.arr.clone(); // и так работает
//            obj.ld = LocalDate.now(); // и так работает, да и способ так се
            
        // а можно и так, для получения вообще других данных отличных т.е. не клона
//            obj.ld= LocalDate.of(2999, Month.MARCH, 13); // работает

//            Calendar cal2 = Calendar.getInstance();
//            cal2.set(3999, 3, 13);
//            obj.d= (Date) cal2.getTime(); // не работает
//            obj.str = "Строка из метода clone"; // не работает
//            obj.arr = (int[]) new int[]{333, 333, 333}; // не работает
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return obj;
    }
}
