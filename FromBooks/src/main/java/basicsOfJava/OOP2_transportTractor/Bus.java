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
public class Bus extends Transport {

    String color = "Yellow", transport = "автобус", fuel = "бензин",
            doAny = "перевозить пасажиров", maxSpeed = "80км.ч.";

    Bus() {
    }

    Bus(String color, String fuel, String maxSpeed,
            String doAny, String transport) {
        super(color, fuel, maxSpeed,
                doAny, transport);
    }

}
