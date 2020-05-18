/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RND_SingleFiles;

import java.util.Random;

/**
 *
 * @author MartyMcAir
 */
public class passw_gener {
   public static void main(String[] args) {
      System.out.println(passGen(6)); // qbycyG
      System.out.println(passGen(6)); // VPfU5c
      System.out.println(passGen(8)); // pzayi9JU
   }
   
   public static String passGen(int count_char) {
      if (count_char < 1) return "";
      StringBuilder s = new StringBuilder();
      Random r = new Random();
      char[] arr = {'a','b','c','d','e','f','g','h','i','j',
         'k','l','m','n','p','q','r','s','t','u','v','w','x','y','z',
         'A','B','C','D','E','F','G','H','I','J','K','L',
         'M','N','P','Q','R','S','T','U','V','W',
         'X','Y','Z','1','2','3','4','5','6','7','8','9','0'};
      for (int i = 0; i < count_char; i++) {
         s.append(arr[r.nextInt(arr.length)]);
      }
      return s.toString();
   }
}
