/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zzz;

/**
 *
 * @author MartyMcAir
 */
public class ClcImplGetx implements IntrfGetx {

    public static void main(String[] args) {
        IntrfGetx intrfV = new ClcImplGetx();
        System.out.println(intrfV.getInt());

        IntrfGetx intrfV2 = new ClcImplGetx(6);
        System.out.println(intrfV2.getInt());

        int numt1 = 999;
        IntrfGetx intrfV3 = () -> {
            return numt1;
        };
        System.out.println(intrfV3.getInt());

        int[] arrN = new int[]{7, 8, 9, 13};
        IntrfGetx intrfV4 = () -> {
            int z = 0;
            for (int i = 0; i < arrN.length; i++) {
                z = arrN[i] <13 ? 777 : 666;
            }
            return z;
        };
        System.out.println(intrfV4.getInt());

    }
    private int number = 3;

    @Override
    public int getInt() {
        return number;
    }

    public ClcImplGetx(int number) {
        this.number = number;
    }

    public ClcImplGetx() {
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
