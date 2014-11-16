/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProgrammingbyDoing.Functions;

import java.util.Scanner;

public class BabyCalculator
{
//Write a calculator program that allows the user to add, subtract, multiply or divide two numbers. 
//(This is sometimes called a "four-function" calculator.)
//
//The program must loop until they enter a zero as the first number.    
	public static void main( String[] args )
	{
		Scanner keyboard = new Scanner(System.in);

		double a, b, c;
		String op;

		do
		{
			System.out.print("> ");
			a  = keyboard.nextDouble();
			op = keyboard.next();
			b  = keyboard.nextDouble();

//			if ( op.equals("+") )
//				c = a + b;
//			else
//			{
//				System.out.println("Undefined operator: '" + op + "'.");
//				c = 0;
//			}
                        switch (op) {
                            case "+":
                                c = a + b;
                                break;
                            case "-":
                                c = a - b;
                                break;
                            case "*":
                                c = a * b;
                                break;
                            case "/":
                                c = a / b;
                                break;
                            default:
                                System.out.println("Undefined operator: '" + op + "'.");
                                c = 0;
                        }
			System.out.println(c);

		} while ( a != 0 );
	}
}

