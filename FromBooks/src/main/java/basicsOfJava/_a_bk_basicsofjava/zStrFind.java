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
public class zStrFind {
    public static void main(String[] args) {
        String str1 = "Java Easy Man!";
        String str2 = "SQL Easy Man!";
        String str3 = "XML Easy Man!";
        String str4 = "Android Java Master!";
        String[] strArr = {str1, str2, str3, str4};
        System.out.println(Arrays.toString(strArr));
        
        findInArr(strArr, "Java");
    }

    public static void findInArr(String[] arr, String need_str) {
        System.out.println("Вы искали: " + need_str);
        int res;
        for(int i=0; i<arr.length; i++){
            res= arr[i].indexOf(need_str);
            if (res != -1) {
                System.out.println("Найдено в строке #: "+ (i+1)
                        +" под индексом №: "+res );
            }        
        }
    } 
}
