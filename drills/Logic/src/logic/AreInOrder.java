package logic;
//Given three ints, a b c, return true if b is greater than a, and c is greater than b. 
//However, with the exception that if "bOk" is true, b does not need to be greater than a. 
//
//AreInOrder(1, 2, 4, false) → true
//AreInOrder(1, 2, 1, false) → false
//AreInOrder(1, 1, 2, true) → true
public class AreInOrder {
  public boolean areInOrder(int a, int b, int c, boolean bOk)  {
      boolean result = false;
      
      if (bOk) {
          if (c > b) {
              result = true;
          }
      } else if (b > a && c > b) {
          result = true;
      } else {
          result = false;
      }
      return result;
  }
}
