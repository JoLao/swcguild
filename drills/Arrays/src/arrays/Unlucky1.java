package arrays;
//We'll say that a 1 immediately followed by a 3 in an array is an "unlucky" 1. 
//Return true if the given array contains an unlucky 1 in the first 2 or last 2 positions in the array. 
//
//Unlucky1({1, 3, 4, 5}) -> true
//Unlucky1({2, 1, 3, 4, 5}) -> true
//Unlucky1({1, 1, 1}) -> false

public class Unlucky1 {

    public boolean unlucky1(int[] numbers) {
        boolean result = false;
        
        if ((numbers[0] == 1 && numbers[1] == 3 ||
            (numbers[numbers.length-2] == 1 && numbers[numbers.length-1] == 3)) ) {
            result = true;
        } else if (numbers.length > 2) {
            if (numbers[1] == 1 && numbers[2] == 3) {
                result = true;
            }
        }
        return result;
    }
}
