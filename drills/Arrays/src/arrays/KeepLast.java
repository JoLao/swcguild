/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;
//Given an int array, return a new array with double the length where its last element is 
//the same as the original array, and all the other elements are 0. The original array 
//will be length 1 or more. Note: by default, a new int array contains all 0's. 
//
//KeepLast({4, 5, 6}) -> {0, 0, 0, 0, 0, 6}
//KeepLast({1, 2}) -> {0, 0, 0, 2}
//KeepLast({3}) -> {0, 3}

public class KeepLast {
    int[] result;
    public int[] keepLast(int[] numbers) {        
        
        if (numbers.length > 0) {
            result = new int[numbers.length * 2];
            result[result.length-1] = numbers[numbers.length-1];
        }
        return result;
    }
}
