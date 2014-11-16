
package arrays;

//Given an int array, return true if the array contains 2 twice, or 3 twice. 
//
//Double23({2, 2, 3}) -> true
//Double23({3, 4, 5, 3}) -> true
//Double23({2, 3, 2, 2}) -> false
public class Double23 {

    public boolean double23(int[] numbers) {
        boolean result = false;
        int     count2 = 0;
        int     count3 = 0;
        
        for (int i=0; i<numbers.length; i++) {
            if (numbers[i] == 2) {
                count2++;
            } else if (numbers[i] == 3) {
                count3++;
            }
        }
        if (count2 == 2 || count3 == 2) {
            result = true;
        }
        return result;
    }
}
