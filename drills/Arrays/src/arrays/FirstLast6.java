
package arrays;
//Given an array of ints, return true if 6 appears as either the first or last element in the array. 
//The array will be length 1 or more. 
//
//FirstLast6({1, 2, 6}) -> true
//FirstLast6({6, 1, 2, 3}) -> true
//FirstLast6({13, 6, 1, 2, 3}) -> false
public class FirstLast6 {

    public boolean firstLast6(int[] num) {
        if (num[0] == 6 || num[num.length - 1] == 6) {
            return true;
        }
        return false;
    }

}
