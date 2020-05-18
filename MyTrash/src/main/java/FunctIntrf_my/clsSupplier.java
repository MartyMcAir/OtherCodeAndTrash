/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctIntrf_my;

import java.util.function.Supplier;

/**
 *
 * @author MartyMcAir
 */
public class clsSupplier {

    public static void main(String[] args) {
        Supplier<clsSupplier> f = clsSupplier::new;
        clsSupplier obj = f.get();
        System.out.println(obj.getX());        // 10
        f = () -> new clsSupplier();
        obj = f.get();
        System.out.println(obj.getX());        // 10
    }
    private int x;

    public clsSupplier() {
        this.x = 10;
    }

    public int getX() {
        return this.x;
    }
}
