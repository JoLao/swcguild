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
public class AddingValuesWithAForLoop {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print( "Number: " );
        int num = keyboard.nextInt();
        int sum = 0;
        for ( int n = 1 ; n <= num ; n = n+1 )
        {
            System.out.print( n + " ");
            sum += n;
        }
        System.out.println("\nThe sum is "+sum);
    }
    
}
