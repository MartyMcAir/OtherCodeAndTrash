/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepByStep.step3Tree;

/**
 *
 * @author MartyMcAir
 */
public class clsImplForGen implements interfForGen1, interfForGen2 {

    private String str;

    clsImplForGen() {
    }

    clsImplForGen(String str) {
        this.str = str;
    }

    @Override
    public void showForGen1(Object obj) {
        System.out.println("showForGen1 obj: " + obj);
    }

    @Override
    public void showForGen2() {
        System.out.println("showForGen2");
    }

}
