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
public class WorstNumberGuessingGame {
    public static void main(String[] args) {
        System.out.println("TEH WORST NUBMER GESSING GAME EVAR!!!!!!!1!");
        
        Random rGen = new Random();
        int rInt = rGen.nextInt(10) + 1;
        
        Scanner keybd = new Scanner(System.in);
        
        System.out.print("I'M THKING OF A NBR FROM 1-10.  TRY 2 GUESS! ");
        int guess = keybd.nextInt();
        
        if (guess == rInt) {
            System.out.println("LOL!!! U GOT IT!  I CANT BELEIVE U GESSED IT WAS "+rInt);
        }
        
    }
    
}
