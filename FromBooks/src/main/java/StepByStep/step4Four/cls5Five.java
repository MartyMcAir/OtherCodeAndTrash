/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepByStep.step4Four;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author MartyMcAir
 */
public class cls5Five {

    public static void main(String[] args) {
        // Каркас коллекций
        // Comparator Comparable
        ArrayList<zcompA> arr = new ArrayList<zcompA>();
        zcompA zA = new zcompA(3, 2);
        arr.add(zA);
        arr.add(new zcompA(1, 3));
        arr.add(new zcompA(2, 1));
        System.out.println(arr.get(0).getClass().getName());
        System.out.println(arr.toString());

        arr.sort(null);
        System.out.println("Сортировкаp по порядку: ");
        System.out.println("arr.sort(null) по порядку: " + arr.toString());

        arr.sort(new Comparator<zcompA>() {
            @Override
            public int compare(zcompA x, zcompA y) {
                if (x.getY() > y.getY()) {
                    return 1;
                }
                if (x.getY() < y.getY()) {
                    return -1;
                }
                return 0;
            }
        });
        System.out.println("\nчерез анонимный класс new Comparator<zcompA>"
                + " по Y возрастанию\n: " + arr.toString());

        arr.sort(new zcompReverse());
        System.out.println("\nчерез new zcompReverse() _ implements Comparator<zcompA>"
                + " по X возрастанию\n: "
                + arr.toString());

        arr.sort(new Comparator<zcompA>() {
            @Override
            public int compare(zcompA o1, zcompA o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println("\nчерез new Comparator<zcompA>"
                + " по X убыванию\n: "
                + arr.toString());
        
        
    }

}
