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
public class Run3 {

    // Java за неделю ~240-260стр
    
    public static void main(String[] args) {
        MyFunc3 intrf;
        clsMethods methods = new clsMethods();
        int[] nums = {2, 3, 4, 5, 6, 7, 8, 9};

        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        for (int i : nums) {
            if (i % 2 == 0) {
                intrf = methods::div2;
                arr1.add(i);
//                System.out.println(intrf.calc(i)); // выводит хз что
                // System.out.println(i); // выводит четные
            } 
            else {
                intrf = methods::none;
                arr2.add(i);
                //System.out.println(intrf.calc(i));  // выводит не четные
                // System.out.println(i);  // выводит не четные
            }
            //System.out.println(intrf.calc(i));
            // если просто выводить то результат 
            // будет не тот, что ожидаем
            //System.out.println(i); 
        }
        //System.out.println("Четные: "+arr1);
        //System.out.println("Не четные: "+arr2);
    }
}
