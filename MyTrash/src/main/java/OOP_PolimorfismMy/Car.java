/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OOP_PolimorfismMy;

/**
 *
 * @author MartyMcAir
 */
public class Car {
    private String maker;
    private String color;
    private String bodyType;

    Car() { }
    Car(String brand, String paint, String style){
        maker=brand;
        color=paint;
        bodyType=style;
    }
    
    private String accelerate(){
        String motion="Ускоряется";
        return motion;
    }
    
    public void setCar(String brand, String paint, String style){
        maker=brand;
        color=paint;
        bodyType=style;
    }
    
    public void getCar(){
        System.out.println(maker+ " color "+color);
        System.out.println(maker+" body Type "+bodyType);
        System.out.println(maker+" "+accelerate()+"\n");
    }
    
    // For Example
    public static void main(String[] args) {
        Car Porshe = new Car();
        Porshe.setCar("Porshe", "Red", "coupe");
        Porshe.getCar();
        
        Car Bently = new Car();
        Bently.setCar("Bently", "Green", "Sedan");
        Bently.getCar();
        
        // Создаем объект Emobile с использованием конструктора Car класса
        Car Emobile = new Car("EAudi", "Yellow", "moto");
        Emobile.getCar();
    }
    
}
