/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProgrammingbyDoing.KeyboardInput;
    import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class AskingQuestions {



	public static void main( String[] args )
	{
		Scanner keyboard = new Scanner(System.in);

		int age;
		String height1, height2;
		double weight;

		System.out.print( "How old are you? " );
		age = keyboard.nextInt();

		System.out.print( "How feet tall are you? " );
		height1 = keyboard.next();
                
                System.out.print("And how many inches? ");
                height2 = keyboard.next();
                
		System.out.print( "How much do you weigh? " );
		weight = keyboard.nextDouble();

		System.out.println( "So you're " + age + " old, " + height1 +"'"+ height2+"\"" + " tall and " + weight + " heavy." );
	}
}
