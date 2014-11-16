/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package loops;
//Given an array of ints, return true if one of the first 4 elements in the array is a 9. 
//The array length may be less than 4. 
//
//ArrayFront9({1, 2, 9, 3, 4}) -> true
//ArrayFront9({1, 2, 3, 4, 9}) -> false
//ArrayFront9({1, 2, 3, 4, 5}) -> false


public class ArrayFront9 {
    public boolean arrayFront9(int[] numbers) {
        int len = (numbers.length > 4 ? 4 : numbers.length);
             
        for (int i = 0; i < len; i++) {
           
            if (numbers[i] == 9) {
               
                return true;
            }
        }
        return false;
    }
}
