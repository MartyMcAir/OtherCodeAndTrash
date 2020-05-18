/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepByStep.step4Four;

/**
 *
 * @author MartyMcAir
 */
public class zcompA implements Comparable<zcompA>{
    private int x;
    private int y;
    zcompA(){}
    zcompA(int x, int y){
        this.x=x;
        this.y=y;
    }
    
    void setX(int x){
        this.x=x;
    }
    void setY(int Y){
        this.y=y;
    }
    
    int getX(){
        return this.x;
    }
    int getY(){
        return this.y;
    }

    @Override
    public int compareTo(zcompA oth) {
        if(this.x>oth.x)return 1;
        if(this.x<oth.x)return -1;
        return 0;
    }
    
    @Override
    public String toString(){
        return("x: "+this.x+" _ y: "+this.y);
    }
}
