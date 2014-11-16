
package loops;

//Given an array of ints, return the number of 9's in the array. 
//
//Count9({1, 2, 9}) -> 1
//Count9({1, 9, 9}) -> 2
//Count9({1, 9, 9, 3, 9}) -> 3
public class Count9 {

    public int count9(int[] numbers) {
        int result = 0;
        
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 9) {
                result++;
            }
        }
        return result;
    }
    
}
