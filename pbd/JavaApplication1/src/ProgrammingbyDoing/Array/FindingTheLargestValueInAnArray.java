/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProgrammingbyDoing.Array;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class FindingTheLargestValueInAnArray {
    public static void main(String[] args) {
//Write a program that creates an array which can hold ten values. Fill the array with random numbers from 1 to 100. 
//Display the values in the array on the screen. Then use a linear search to find the largest value in the array, and 
//display that value        
        int[] arrNum = new int[10];
        Random rGen = new Random();

        int largestNum = 0;
        
        for (int i = 0; i < arrNum.length; i++) {
            arrNum[i] = rGen.nextInt(100) + 1;
            System.out.print(arrNum[i]+" ");
            if (arrNum[i] > largestNum) {
                largestNum = arrNum[i];
            }
        }
        System.out.println("");
        System.out.println("The largest number in the array is "+largestNum);
    }
    
}
