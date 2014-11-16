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
public class NumberGuessingGame {
    public static void main(String[] args) {
        
        Random rGen = new Random();
        int rInt = rGen.nextInt(10) + 1;
        int guess = 0;
        int tries = 0;
        
        Scanner keybd = new Scanner(System.in);
        
        //while (guess != rInt) {
        do {
            System.out.print("I'M THKING OF A NBR FROM 1-10.  TRY 2 GUESS! ");
            guess = keybd.nextInt();
            tries++;
            if (guess == rInt) {
                System.out.println("LOL!!! U GOT IT!  I CANT BELEIVE U GUESSED IT WAS "+rInt);
                System.out.println("It only took you "+tries+" tries");
            } else {
                System.out.println("That is incorrect. Guess again.");
            }
        } while (guess != rInt);
        
    }
}
