/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package loops;

//Given an array of ints, return true if .. 1, 2, 3, .. appears in the array somewhere. 
//
//Array123({1, 1, 2, 3, 1}) -> true
//Array123({1, 1, 2, 4, 1}) -> false
//Array123({1, 1, 2, 1, 2, 3}) -> true


public class Array123 {
  public boolean array123(int[] numbers) {
      boolean foundOne   = false;
      boolean foundTwo   = false;
      boolean foundThree = false;
      
      for (int i = 0; i < numbers.length; i++) {
          if (numbers[i] == 1) {
              foundOne   = true;
          }
          if (numbers[i] == 2) {
              foundTwo   = true;
          }
          if (numbers[i] == 3) {
              foundThree = true;
          }
      }
      return (foundOne && foundTwo && foundThree ? true : false);
}  
}
