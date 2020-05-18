/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava.Collections;

import java.util.Comparator;

/**
 *
 * @author MartyMcAir
 */
public class CompImplReverse implements Comparator<CompImplA>{

    @Override
    public int compare(CompImplA o1, CompImplA o2) {
        return o2.compareTo(o1);
    }
    
}
