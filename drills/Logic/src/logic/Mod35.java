
package logic;

//Return true if the given non-negative number is a multiple of 3 or 5, 
//but not both. Use the % "mod" operator
//
//Mod35(3) → true
//Mod35(10) → true
//Mod35(15) → false

public class Mod35 {
  public boolean mod35(int n)  {
      boolean result = false;
      if (n < 0 || (n % 3 == 0 && n % 5 == 0) ) {
          result = false;
      } else if (n % 3 == 0 || n % 5 ==0) {
          result = true;
      }
      return result;
  }
}
