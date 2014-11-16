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
public class CopyingArrays {
    public static void main(String[] args) {
//Write a program that creates an array of ten integers. It should put ten random numbers from 1 to 100 in the array. 
//It should copy all the elements of that array into another array of the same size. Then display the contents of both 
//arrays. To get the output to look like mine, you'll need a several for loops.

    //Create an array of ten integers
    //Fill the array with ten random numbers (1-100)
    //Copy the array into another array of the same capacity
    //Change the last value in the first array to a -7
    //Display the contents of both arrays         
        
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];
        Random rGen = new Random();
        int rInt = 0;
        
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = rGen.nextInt(100) + 1;
            arr2[i] = arr1[i];
        }
        arr1[9] = -7;
        String msg = "Array 1: ";
        for (int i = 0; i < arr1.length; i++) {
            msg = msg + arr1[i] + " ";
        }
        System.out.println(msg);
        
        msg = "Array 2: ";
        for (int i = 0; i < arr2.length; i++) {
            msg = msg + arr2[i] + " ";
        }
        System.out.println(msg);
    }
    
}
