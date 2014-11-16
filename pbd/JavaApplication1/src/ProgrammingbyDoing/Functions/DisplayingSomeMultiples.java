/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProgrammingbyDoing.Functions;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class DisplayingSomeMultiples {
//Write a program to calculate the multiples of a given number. Have the user enter a number, 
//and then use a for loop to display all the multiples of that number from 1 to 12. It is not 
//necessary to use a function.    
  public static void main(String[] args) {
      Scanner keybd = new Scanner(System.in);
      System.out.print("Enter a number : ");
      int num = keybd.nextInt();
      
      for (int i=1; i < 13; i++)
          System.out.println(num+"x"+i+" = "+(num *i));
  }  
}
