/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaForWeek._funkLyambd;

import java.util.ArrayList;

/**
 *
 * @author MartyMcAir
 */
public class clsMethods {
    void mult(){
        System.out.println("Пустой метод");
    }

    void mult(int a){
        System.out.println("значение умноженное на 2: "+a*2);
    }
    
    int div2(int a){
        return a/2;
    }
    
    int none(int a){
        return a;
    }
    
    void show(int a){
        System.out.println(a);
    }
    void showList(ArrayList<Integer> a){
        System.out.println(a);
    }
    ArrayList<Integer> getArrAndShow(int a){
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(a);
        return arr;
    }
}
