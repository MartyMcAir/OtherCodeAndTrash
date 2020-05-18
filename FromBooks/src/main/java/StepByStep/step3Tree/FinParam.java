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
@FunctionalInterface
public interface FinParam {

    boolean isBl(int n);

    default void showEvenOdd(int[] arr) {
        System.out.print("arr[i])==true Even: ");
        for (int i = 0; i < arr.length; i++) {
            if (isBl(arr[i]) == true) {
                System.out.print(arr[i] + ", ");
            }
        }
        
        System.out.println("\narr[i])!=true Odd: " );
        for(int a :  arr){
            if(isBl(a)!=true){
                System.out.print(a+", ");
            }
        }
    }
}
