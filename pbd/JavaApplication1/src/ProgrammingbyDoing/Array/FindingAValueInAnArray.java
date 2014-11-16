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
public class FindingAValueInAnArray {
    public static void main(String[] args) {
//Create an array that can hold ten integers, and fill each slot with a different random value from 1-50. 
//Display those values on the screen, and then prompt the user for an integer. Search through the array, and 
//if the item is present, say so. It is not necessary to display anything if the value was not found. If the
//item is in the array multiple times, it's okay if the program prints the message more than once.        
        int[] arrNum = new int[10];
        Random rGen = new Random();
        Scanner keybd = new Scanner(System.in);
        int rInt = 0;
        int userInt = 0;
        
        for (int i = 0; i < arrNum.length; i++) {
            arrNum[i] = rGen.nextInt(50) + 1;
            System.out.print(arrNum[i]+" ");
        }
        System.out.println("");
        System.out.print("Value to find : ");
        userInt = keybd.nextInt();
        for (int i = 0; i < arrNum.length; i++) {
            if (userInt == arrNum[i]) {
                System.out.println("Value is found in array element "+i);
            }
        }
    }
    
}
