/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepByStep.step6Six.clon3;

import java.text.SimpleDateFormat;

/**
 *
 * @author MartyMcAir
 */
public class clsRunner {
    public static void main(String[]args){
        Book thor = new Book("Thor shtorm Apokalipsis", "Maik Vasovski");
        thor.setContents(new String[]{"step1 Thor Bigine","step2..","step3.."});
//        thor.displayBookName();
        
//        Book thanos = clone(); // 
        Book thanos = thor.clone();
        thanos.setName("Thanos incredible Titan");
        thanos.setAuthor("AikiChan");
        thanos.setContents(new String[]{"step1 Thanos Bigine","step2..","step3.."});
        System.out.println("Clone thanos.displayBookName(): ");
        thanos.displayBookName();
        
        System.out.println("\nOriginal thor.displayBookName(): ");
        thor.displayBookName();
        
        System.out.println(thor.changeDatePattern("dd.MM.y"));
        
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("dd.MM.yyyy");
        System.out.println("\n _ "+sdf.get2DigitYearStart());
        
    }
    
}
