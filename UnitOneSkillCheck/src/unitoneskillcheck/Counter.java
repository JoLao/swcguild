package unitoneskillcheck;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class Counter {
    
//Create a new Java class called Counter (make sure you create a ‘main’ method).

//    Implement a static method called to10 that takes no parameters and returns nothing.  
//    This method should simply print the numbers from 1 to 10 to the screen, one number per line.  
//    Implement this method in the most efficient way you can.
//
//    Implement test code in your main method that calls the toTen method.
//
//    Implement a static method called toN that takes one integer parameter and returns nothing.  
//    This method should simply print the number from 0  to the value of the parameters to the screen, 
//    one number per line.
  public static void main(String[] args) {
      to10();
      toN(3);
      toN(8);
      toN(200);
  }  
    
  public static void to10() {
      for (int i = 1; i < 11; i++) {
          System.out.println(i);
      }
  }
  
  public static void toN(int n) {
      for (int i = 0; i <= n; i++) {
          System.out.println(i);          
      }
  }
}
