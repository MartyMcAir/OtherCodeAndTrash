/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._a_bk_basicsofjava;

import java.util.Arrays;

/**
 *
 * @author MartyMcAir
 */
public class clsVarible {
    public static void main(String[] args){
        int[] numbers={333, 6, 8, 13};
        System.out.println(sum(1,2,3));
        System.out.println(sum(1,2,3,4,5,6));
        
        String strArr = Arrays.toString(numbers);
        System.out.println(strArr.substring(1, 12));
        String new_Arr = strArr.substring(1, 12);
        // НЕ РАБОТАЕТ
//        System.out.println( Integer.parseInt(Arrays.toString(numbers)) );
//        System.out.println(sum(Integer.parseInt (new_Arr)) );
        
        variable(3, "15", "text", 34);
        for(int i=0;i<numbers.length;i++){
            variable( numbers[i] );
        }
        System.out.println();
        variable2( numbers );
        
    }
    // Передача произвольного кол-ва значений любого типа
    public static void variable(Object... a){
        for(Object b : a){
            System.out.print(b+", ");
        }
    }
    public static void variable2(int[] arr){
        for(Object b : arr){
            System.out.print(b+", ");
        }
    }
    
    // суммирование произвольного кол-ва чисел
    public static int sum(int... a){
        int result = 0;
        System.out.println("Значений: " +a.length);
        for(int b : a){
            result+=b;
        }
        return result;
    }
    
    
}
