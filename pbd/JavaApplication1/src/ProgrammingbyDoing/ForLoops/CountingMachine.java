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
public class CountingMachine {
    public static void main( String[] args )
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.print( "Enter a number : " );
        int numTimes = keyboard.nextInt();

        for ( int n = 0 ; n <= numTimes ; n = n+1 )
        {
            System.out.print( n + " ");
        }

    }
    
}
