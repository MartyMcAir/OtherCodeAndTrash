/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepByStep.step6Six;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author MartyMcAir
 */
public class cloneListTime implements Cloneable{

    private String field = "Значение по умолчанию";
    private ArrayList<String> arrL = new ArrayList<String>();
    
    private Date d = new Date();
    private SimpleDateFormat sdf = new SimpleDateFormat();
    private DateFormatSymbols dfs = new DateFormatSymbols();
    
//    private LocalDate ld = LocalDate.now();
//    private ZonedDateTime zdt = ZonedDateTime.now();

    cloneListTime() {
    }

    DateFormatSymbols getDFS(){
        return this.dfs;
    }
    
    void setDFS(DateFormatSymbols dfs){
        this.dfs=dfs;
    }
    
    void DFSsetWeekDays(String[] arr){
        this.dfs.setShortWeekdays(arr);
    }
    
    String[] getDFSWeekDays(){
        return this.dfs.getShortWeekdays();
    }
    
    SimpleDateFormat getSDF(){
        return this.sdf;
    }
    
    void setSDF(SimpleDateFormat a){
        this.sdf=a;
    }
    
    void patternOnSDF(String str){
        this.sdf.applyPattern(str);
    }
    
    Date getDate(){
        return this.d;
    }
    
    void setDate(Date d){
        this.d = d;
    }
    
    void setDateMonth(int a){
        d.setMonth(a);
    }
    
    void setField(String a) {
        this.field = a;
    }

    String getField() {
        return this.field;
    }

    ArrayList<String> getArrL() {
        return this.arrL;
    }

    void setArrList(ArrayList<String> arrL) {
        this.arrL = arrL;
    }

    void addElementArrL(String str) {
        this.arrL.add(str);
    }
    
//    ZonedDateTime getZDT(){
//        return this.zdt;
//    }
//    
//    void setZDT(ZonedDateTime zdt){
//        this.zdt=zdt;
//    }
//    
//    void zdtMinusMonth(Long a){
//        this.zdt.minusMonths(a);
//    }

    @Override
    public Object clone() {
        cloneListTime obj = null;
        try {
            obj = (cloneListTime) super.clone();
            obj.arrL = (ArrayList<String>) arrL.clone();
            obj.d = (Date) this.d.clone();
            obj.sdf = (SimpleDateFormat) this.sdf.clone();
            obj.dfs = (DateFormatSymbols) this.dfs.clone();
            
            // нет метода clone
//            obj.zdt = (ZonedDateTime) this.zdt.
//            obj.ld= (LocalDate) this.ld.
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            System.err.println("Ошибка: " + e.getMessage());
        } catch (Exception e){
            System.err.println("Ошибка: " + e.getMessage());
        }
        return obj;
    }
    // альтернативный путь копирования объекта
    cloneListTime getCopyObj(){
        return new cloneListTime();
    } 
}
