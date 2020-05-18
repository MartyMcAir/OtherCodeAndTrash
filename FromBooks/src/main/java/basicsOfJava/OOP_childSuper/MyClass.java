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
public class MyClass {
    public static void main(String[] args){
        Point p, p2;
        p = p2 = new Point();
        p.x=10;
        p.y=20;
        System.out.println(p.x+" "+p.y);
        p2.x=30;
        p2.y=60;
        System.out.println(p2.x+" "+p2.y);
        
        Rectangle rect = new Rectangle();
        // Обращаемся к полям Point находящиеся внутри класса Rectangle
        // И через все это получаем доступ к полям класса Poin x и y
        rect.topLeft.x=0;
        rect.topLeft.y=0;
        rect.bottomRight.x=100;
        rect.bottomRight.y=100;
        
        System.out.println(rect.topLeft.x+ " "+
                rect.topLeft.y+" "+
                rect.bottomRight.x+" "+
                rect.bottomRight.y);
        
        p.setXx(333);
        p.setYy(666);
        System.out.println(p.getXx() +" "+ p.getYy());
        Point p3 = new Point(888, 999);
        System.out.println(p3.getXx()+" "+p3.getYy());
        
        System.out.println(Point.MY_CONST);
        System.out.println(Point.MY_CONST.toLowerCase());
        
        Point p4 = Rectangle.getInstancePoint();
        p4.setXx(388);
        System.out.println(p4.getXx()
                +" экземпляр класса Работает, через метод фабрику");
        
        // Передаем суперКлассу в его конструктор через подк класс..
        ChildClsForChildcls2 clsEx = new ChildClsForChildcls2(383969);
        System.out.println("значение с поля суперКласса: "+clsEx.getC());
        clsEx.showName();
        System.out.println("строка класса: "+clsEx.className);
        
        System.out.println();
        ChildClass2 cls2 = new ChildClass2(688);
        System.out.println("значение с поля суперКласса: " +cls2.getC() );
        cls2.showName();
        System.out.println("строка класса: "+cls2.className);
    }
}
