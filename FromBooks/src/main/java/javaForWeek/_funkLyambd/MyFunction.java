/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaForWeek._funkLyambd;

/**
 *
 * @author MartyMcAir
 */
@FunctionalInterface
interface MyFunction {
    default void doit(int n){
        System.out.println("result: "+calc(n));
    }
    
    double calc(int n);
}
