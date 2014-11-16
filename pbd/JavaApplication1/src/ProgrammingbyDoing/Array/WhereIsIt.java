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
public class WhereIsIt {
    public static void main(String[] args) {
//Create an array that can hold ten integers, and fill each slot with a different random value from 1-50. 
//Display those values on the screen, and then prompt the user for an integer. Search through the array, 
//and if the item is present, give the slot number where it is located. If the value is not in the array, 
//display a single message saying so. If the value is present more than once, you may either display the 
//message as many times as necessary, or display a single message giving the last slot number in which it appeared.   
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
                System.out.println(userInt+" is in slot "+i);
                numTimes++;
            }
        }
        if (numTimes == 0) {
            System.out.println(userInt+" is not in the array.");
        }
    }
    
}
