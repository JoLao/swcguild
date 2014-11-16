/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProgrammingbyDoing.WhileLoops;

import java.util.Scanner;


/**
 *
 * @author apprentice
 */
public class CountingWhile {
    public static void main( String[] args )
	{
		Scanner keyboard = new Scanner(System.in);

		System.out.println( "Type in a message, and I'll display it five times." );
		System.out.print( "Message: " );
		String message = keyboard.nextLine();

		int n = 0;
                System.out.print("How many times? ");
                int numOfTimes = keyboard.nextInt();
                
		while ( n < numOfTimes)
		{
			System.out.println( ((n+1) * 10)+ ". " + message );
			n++;
		}

	}
}
