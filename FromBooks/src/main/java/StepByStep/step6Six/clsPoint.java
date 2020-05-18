/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepByStep.step6Six;

/**
 *
 * @author MartyMcAir
 */
public class clsPoint {

    private int x, y;

    clsPoint() {
    }

    clsPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        clsPoint p = (clsPoint) obj;
        return this.x == p.x && this.y == p.y;
    }
}
