/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._a_bk_basicsofjava;

/**
 *
 * @author MartyMcAir
 */
public class clsEnum {
    static int a;
    static final int B = 999;

    enum Cat {
        Leopard, Puma, Lion, Tiger, Manul
    }

    public static void main(String[] args) {
        Cat cat1, cat2;
        String res = "";
        cat1= Cat.Leopard;
        cat2 = Cat.Manul;
        switch(cat2){
            case Tiger:
                res="tiger_res";
                break;
            case Manul:
                res="Manul_res";
                break;
        }
        System.out.println(res);
    }
}
