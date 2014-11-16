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
public class HowManyTimes {
    public static void main(String[] args) {
//Create an array that can hold ten integers, and fill each slot with a different random value from 1-50. 
//Display those values on the screen, and then prompt the user for an integer. Search through the array, 
//and count the number of times the item is found.        
        int[] arrNum = new int[10];
        Random rGen = new Random();
        Scanner keybd = new Scanner(System.in);
        int rInt = 0;
        int userInt = 0;
        int numTimes = 0;
        
        for (int i = 0; i < arrNum.length; i++) {
            arrNum[i] = rGen.nextInt(50) + 1;
            System.out.print(arrNum[i]+" ");
        }
        System.out.println("");
        System.out.print("Value to find : ");
        userInt = keybd.nextInt();
        for (int i = 0; i < arrNum.length; i++) {
            if (userInt == arrNum[i]) {
                numTimes++;
            }
        }
        System.out.println(userInt+" was found "+numTimes+" time(s)");
    }
    
}
