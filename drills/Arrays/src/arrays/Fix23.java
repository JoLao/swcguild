package arrays;

//Given an int array length 3, if there is a 2 in the array immediately followed by a 3, 
//set the 3 element to 0. Return the changed array. 
//
//Fix23({1, 2, 3}) ->{1, 2, 0}
//Fix23({2, 3, 5}) -> {2, 0, 5}
//Fix23({1, 2, 1}) -> {1, 2, 1}
public class Fix23 {

    public int[] Fix23(int[] numbers) {
             
        if (numbers[0] == 2 && numbers[1] == 3) {
            numbers[1] = 0;
        } else if (numbers[1] == 2 && numbers[2] == 3) {
            numbers[2] = 0;
        }
        
        return numbers;
    }
}