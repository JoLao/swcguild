/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProgrammingbyDoing.ForLoops;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class CountingMachineRevisited {
     public static void main( String[] args )
    {
        //Write a program that gets three integers from the user. 
        //Count from the first number to the second number in increments of the third number. 
        //Use a for loop to do it.
        Scanner keyboard = new Scanner(System.in);

        System.out.print( "Count from: " );
        int from = keyboard.nextInt();
        
        System.out.print( "Count to  : " );
        int to = keyboard.nextInt();
        
        System.out.print( "Count by  : " );
        int by = keyboard.nextInt();
        
        for ( int n = from ; n <= to; n = n+by )
        {
            System.out.print( n + " ");
        }

    }
}
