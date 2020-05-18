/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base_SingleArray;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.stream.Stream;

/**
 *
 * @author MartyMcAir
 */
public class Z_FileReadWr {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception {

	      Path p = Paths.get("C:\\z_n\\GoogleChromePortable\\Other");
	      try (Stream<Path> stream = Files.walk(p, 3)) {
	         stream.forEachOrdered(
	            (path) -> System.out.println(path.toString())
	         );
	      }
	      System.out.println();
	      try (Stream<Path> stream2 = Files.walk(p)) {
	         stream2.sorted(Collections.reverseOrder()).forEachOrdered(
	            (path) -> System.out.println(path.toString())
         );     } } 
    
}
