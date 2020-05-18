/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepByStep.step4Four;


/**
 *
 * @author MartyMcAir
 */
public class implComparable implements Comparable<Integer>{

    @Override
    public int compareTo(Integer o) {
        return o.intValue();
    }
    
}
