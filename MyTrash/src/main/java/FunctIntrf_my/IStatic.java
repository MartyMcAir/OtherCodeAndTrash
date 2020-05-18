/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctIntrf_my;

/**
 *
 * @author MartyMcAir
 */
public interface IStatic {
    String STR ="КОНСТАНТА";
    String STR2 ="КОНСТАНТА2";
    
   String getString();
   static void test() {
      print();
   }
   static void print() {
      System.out.println("Привет");
   }
}
