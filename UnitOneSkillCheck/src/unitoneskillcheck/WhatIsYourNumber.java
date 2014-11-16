/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package unitoneskillcheck;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class WhatIsYourNumber {

//    Asks the user for an integer
//
//    Prints that integer to the screen
//
//    Prints all of the number from 0 to the user’s number to the screen, one number per line
//    Prints “Thank you for playing” to the screen
    
     public static void main(String[] args) {
         Scanner keybd = new Scanner(System.in);
         System.out.print("Enter a number : ");
         int n = keybd.nextInt();
         
         for (int i = 0; i <= n; i++) {
             System.out.println(i);
         }
         System.out.println("Thank you for playing");
     }
}
