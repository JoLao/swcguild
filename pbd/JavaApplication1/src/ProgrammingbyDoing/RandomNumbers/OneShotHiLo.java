/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProgrammingbyDoing.RandomNumbers;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class OneShotHiLo {
    public static void main(String[] args) {
        System.out.println("I'm thinking of a number between 1-100.  Try to guess it. ");
        Random rGen = new Random();
        int rInt = rGen.nextInt(100) + 1;
        Scanner keybd = new Scanner(System.in);
        int tries = 0, userNum = 0;
        
        while (userNum != rInt && tries < 7) {
            userNum = keybd.nextInt();
        
            if (userNum == rInt) {
                System.out.println("You guessed it!  What are the odds?!?");
            } else if (userNum < rInt) {
                System.out.println("Sorry, you are too low.");
            } else {
                System.out.println("Sorry, you are too high.");
            }
            tries++;
            System.out.print("Guess #"+tries+" : ");
        }
        if (userNum != rInt) {
            System.out.println("Sorry, you didn't guess it in 7 tries.  You lose.");
        }
    }
    
}
