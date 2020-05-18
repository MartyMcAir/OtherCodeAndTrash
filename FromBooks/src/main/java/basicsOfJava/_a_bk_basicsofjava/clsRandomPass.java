/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._a_bk_basicsofjava;

import java.util.Random;

/**
 *
 * @author MartyMcAir
 */
public class clsRandomPass {
    public static void main(String[] args){
        // пароль длинной в 8 символов
        System.out.println(passGEn(8));
    }
    
    public static String passGEn(int count_char){
        if(count_char<1) return " ";
        StringBuilder sbld = new StringBuilder();
        Random rnd = new Random();
        char[] arr = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 
            'u', 'v', 'w', 'x', 'y', 'z', 
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z',
            '1', '2', '3', '4', '5', '6', '7', '8','9', '0'};
        
        //  цикл ограничен ровно тем кол-вом запусков, что необходимо 
        // для создания с определенным кол-вом символов паролем 
        for(int i=0;i<count_char;i++){
            // С помощью append() строка "наполняется"
            // в массив arr отправляется в качестве случайного 
            //номера индекса число сгенерированное классом Random, и 
            // число это ограниченно длинной массива arr.length
            sbld.append( arr[ rnd.nextInt(arr.length) ] );
        }
        return sbld.toString();
    }
}
