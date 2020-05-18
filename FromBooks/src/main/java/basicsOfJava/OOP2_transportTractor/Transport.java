/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava.OOP2_transportTractor;

/**
 *
 * @author MartyMcAir
 */
public class Transport {

    String color, fuel, maxSpeed, doAny, transport;

    Transport(){}
    
    Transport(String color, String fuel, String maxSpeed, 
            String doAny, String transport){
        this.color=color;
        this.fuel=fuel;
        this.maxSpeed=maxSpeed;
        this.doAny=doAny;
        this.transport=transport;
    }
    
    public static void run(){
        System.out.println("Включен");
    }
    
    public String getDoAny() {
        return doAny;
    }
    
    public void showOptions(){
        System.out.println("транспорт называется: "+transport+
                " и его цвет: "+color+
                ", работает на топливе: "+fuel+
                ", и его масимальная скорость: "+maxSpeed);
        System.out.println("Этот транспорт умеет: "+this.getDoAny() );
    }
    
    public void showGo(){
        System.out.println("Обычная скорость");
    }
    
}
