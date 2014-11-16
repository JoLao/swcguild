
package logic;

//Given three ints, a b c, return true if two or more of them have the same rightmost digit. 
//The ints are non-negative. 
//
//LastDigit(23, 19, 13) → true
//LastDigit(23, 19, 12) → false
//LastDigit(23, 19, 3) → true

public class LastDigit {
  public boolean lastDigit(int a, int b, int c)   {
      boolean result = false;
      
      if ((a > 0 && b > 0 & c > 0) &&
          (a % 10) == (b % 10) || (a % 10) == (c % 10) || (b % 10) == (c % 10)) {
          result = true;
      } else {
          result = false;
      }
      return result;
  }
}
