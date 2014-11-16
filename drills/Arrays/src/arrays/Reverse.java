/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

//Given an array of ints length 3, return a new array with the elements in reverse order, 
//o for example {1, 2, 3} becomes {3, 2, 1}. 
public class Reverse {
    public int[] result;
    public int[] reverse(int[] numbers) {
        int j = 0;      

        if (numbers.length > 0) {
            result = new int[numbers.length];
            j = numbers.length - 1;
            for (int i = 0; i < numbers.length; i++) {
                result[j] = numbers[i];
                j--;
            }
        }
        return result;

    }
}
