/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProgrammingbyDoing.ForLoops;

/**
 *
 * @author apprentice
 */
public class FizzBuzz {
    public static void main(String[] args) {
    //Write a program that prints the numbers from 1 to 100. But for multiples of three print "Fizz" 
    //instead of the number and for the multiples of five print "Buzz". For numbers which are multiples 
    //of both three and five print "FizzBuzz".
    
        String message = "";
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) {
                message = "Fizz";             
            }
            if (i % 5 == 0) {
                message = message +"Buzz";
            }
            if (!message.equalsIgnoreCase("")) {
                System.out.println(message);
                message = "";
            } else {
                System.out.println(i);
            }
        }
    }
}
