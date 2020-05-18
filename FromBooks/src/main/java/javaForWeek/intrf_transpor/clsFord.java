/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaForWeek.intrf_transpor;

/**
 *
 * @author MartyMcAir
 */
public class clsFord extends clsCars{
    
    public clsFord(String carBrend, String carEngine, String carColor) {
        super(carBrend, carEngine, carColor);
    }
    
    @Override
    public void show(){
        System.out.println("это класс Ford и её движок: "+carEngine);
    }
    
}
