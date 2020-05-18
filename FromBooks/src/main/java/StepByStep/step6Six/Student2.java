/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepByStep.step6Six;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author MartyMcAir
 */
public class Student2 implements Cloneable {

    private Date d = new Date();
    private SimpleDateFormat sdf = new SimpleDateFormat();
    private DateFormatSymbols dfs = new DateFormatSymbols();
    
    private LocalDate ld = LocalDate.now();
    private ZonedDateTime zdt = ZonedDateTime.now();

    
    private int id = 71;
    private String name;
    private int age;
    private Vector<Integer> v = new Vector<Integer>(); // список изменяемое поле

    int getId() {
        return this.id;
    }

    void setId(int id) {
        this.id = id;
    }

    Integer getElementVector(int v_get) {
        return v.get(v_get);
    }

    void addElementVector(Integer v_int) {
        v.add(v_int);
    }

    Vector<Integer> getVector() {
        return this.v;
    }

    @Override
    public Object clone() {
        Student2 copy = null;
        try {
            copy = (Student2) super.clone();
            copy.v = (Vector<Integer>) v.clone();
            copy.d = (Date) d.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            System.err.println("не реализован интерфейс Cloneable");
        }
        return copy;
    }
}
