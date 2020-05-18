/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava.OOP_childSuper;

/**
 *
 * @author MartyMcAir
 */
public class Rectangle {
    public Point topLeft = new Point();
    public Point bottomRight = new Point();
    
    // Инициализационный блок (анонимный)
    {
        topLeft = new Point();
        bottomRight = new Point(2, 3);
    }
    
    // Метод фабрика возвращает экземпляр или значение
    // текущего или другого класса
    public static Point getInstancePoint(){
        return new Point();
    }
}
