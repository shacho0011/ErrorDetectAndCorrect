/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisproject;

import java.util.Random;

/**
 *
 * @author Shadhin
 */
public class RandomInteger {
    public static final void main(String... aArgs){
    log("Generating random integers in range 0..99.");
    
    //note a single Random object is reused here
    Random randomGenerator = new Random();
//    for (int idx = 1; idx <= 10; ++idx){
      int randomInt = randomGenerator.nextInt(100);
      log("Generated : " + randomInt);
    //}
    
    log("Done.");
  }
  
  private static void log(String aMessage){
    System.out.println(aMessage);
  }
}
