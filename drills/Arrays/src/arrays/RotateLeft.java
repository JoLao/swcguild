/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;
//Given an array of ints, return an array with the elements "rotated left" so {1, 2, 3} yields {2, 3, 1}. 
//
//RotateLeft({1, 2, 3}) -> {2, 3, 1}
//RotateLeft({5, 11, 9}) -> {11, 9, 5}
//RotateLeft({7, 0, 0}) -> {0, 0, 7}

public class RotateLeft {

    public int[] rotateLeft(int[] numbers) {
        int temp = 0;

        if (numbers.length > 0) {
            temp = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                numbers[i - 1] = numbers[i];
            }
            numbers[numbers.length - 1] = temp;
        }
        return numbers;
    }
}
