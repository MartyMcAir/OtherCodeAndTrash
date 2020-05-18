
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC_my2;

import java.util.Arrays;

/**
 *
 * @author MartyMcAir
 */
public class clsView {
  public void printName(String name){
    System.out.println(name);
  }
  
  public void printArrCh(char[] arr){
    System.out.println(Arrays.toString(arr));
  }
  
  public void printOptionaly(Object... arr){
      System.out.println(Arrays.toString(arr));
  }

  public void printIntOptionaly(int... arr){
      System.out.println(Arrays.toString(arr));
  }
  
}
