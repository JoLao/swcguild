/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;
//Given an array of ints, figure out which is larger between the first and last elements in the array, 
//and set all the other elements to be that value. Return the changed array. 
//
//HigherWins({1, 2, 3}) -> {3, 3, 3}
//HigherWins({11, 5, 9}) -> {11, 11, 11}
//HigherWins({2, 11, 3}) -> {3, 3, 3}

public class HigherWins {

    public int[] higherWins(int[] numbers) {
        int largest = 0;
        
        if (numbers[0] > numbers[numbers.length-1]) {
            largest = numbers[0];
        } else {
            largest = numbers[numbers.length-1];
        }        
        for (int i=0; i<numbers.length; i++) {            
                numbers[i] = largest;
        }
        return numbers;
    }
}
