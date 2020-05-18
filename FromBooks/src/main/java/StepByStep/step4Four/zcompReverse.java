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
public class zcompReverse implements Comparator<zcompA>{

    @Override
    public int compare(zcompA o1, zcompA o2) {
        return o1.compareTo(o2);
    }
}
