
package arrays;
//Given an array of ints, return true if the array is length 1 or more, 
//and the first element and the last element are equal. 
//
//SameFirstLast({1, 2, 3}) -> false
//SameFirstLast({1, 2, 3, 1}) -> true
//SameFirstLast({1, 2, 1}) -> true
public class SameFirstLast {
  public boolean sameFirstLast(int[] num)   {
      if (num.length > 0 && num[0] == num[num.length - 1]) {
          return true;
      }
      return false;
  }
}
