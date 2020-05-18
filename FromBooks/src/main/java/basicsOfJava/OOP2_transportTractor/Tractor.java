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
public class Tractor extends Transport {

    String color = "Black", transport = "автобус", fuel = "disel",
            doAny = "собирать урожай", maxSpeed = "30км.ч.";

    Tractor() {
    }

    Tractor(String color, String fuel, String maxSpeed,
            String doAny, String transport) {
        super(color, fuel, maxSpeed,
                doAny, transport);
    }

    @Override
    public void showGo() {
        System.out.println("Едет медленно.");
    }
    
    @Override
    public String toString(){
        return "вызван @Override метод toString() из класса Tractor";
    }
    
}
