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
public class Point {
    public int x, y;
    private int xx, yy;
    public static final String MY_CONST="КОНСТАНТА";

//    Point(){}
    
    Point(String str){
        this(25, 33); // вызывает Point(int xx, int yy)
        System.out.println(str);
    }
    
    Point(){
        this.xx=0;
        this.yy=0;
    }

    Point(int xx, int yy){
        this.xx=xx;
        this.yy=yy;
    }
    
    public void setXx(int a){
        this.xx=a;
    }
    public void setYy(int a){
        this.yy=a;
    }
    
    public int getXx(){
        return xx;
    }
    public int getYy(){
        return yy;
    }
    
}
