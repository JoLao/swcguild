

package logic;
//Return true if the given non-negative number is 1 or 2 more than a multiple of 20. 
//See also: Introduction to Mod 
//
//Mod20(20) → false
//Mod20(21) → true
//Mod20(22) → true
public class Mod20 {
  public boolean mod20(int num)   {
      boolean result = false;
      if (num > 0 && (((num - 1) % 20) == 0 || ((num - 2) % 20) == 0)) {
          result = true;
      } else {
          result = false;
      }
      return result;
  }
}
