/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepByStep.step4Four;

import java.util.Comparator;

/**
 *
 * @author MartyMcAir
 */
public class implComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        // Приортет сначала Четные, а потом не четные _ не работает
//        if ((o1 % 2) !== 0) {
//            return o1;
//        } else {
//            return o2;
//        }
            return o1.compareTo(o2); // сортировка по порядку
//            return o2.compareTo(o1); // сортировка в обратном порядке
    }

//    @Override
//    public Comparator reversed() {
//        return Comparator.super.reversed(); //To change body of generated methods, choose Tools | Templates.
//    }
}
