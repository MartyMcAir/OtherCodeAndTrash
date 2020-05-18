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
abstract class clsCars {
    String carBrend, carEngine, carColor;
    
    clsCars(String brend,String engine,String color){
        this.carBrend=brend;
        this.carEngine=engine;
        this.carColor=color;
    }
    
    public void show(){
        System.out.println("это супер класс всех тачек");
    }
}
