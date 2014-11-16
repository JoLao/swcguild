/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProgrammingbyDoing.Array;

import java.util.Random;

/**
 *
 * @author apprentice
 */
public class BasicArrays3 {
    public static void main(String[] args) {
//Create an array that can hold 1000 integers. Fill the array with random numbers in the range 10-99. 
//Then display the contents of the array on the screen. You must use a loop.        
         int[] slots = new int[1000];
        Random rGen = new Random();
        int num = 0;
        
        for (int i = 0; i < slots.length; i++) {
            num = rGen.nextInt(90) + 10;
            slots[i] = num;
            System.out.print(slots[i]+" ");
        }
    }
}
