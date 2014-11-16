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
public class CollatzSequence {
    public static void main(String[] args) {
        
    //If n is even, divide it by 2 to get n / 2.
    //If n is odd, multiply it by 3 and add 1 to get 3n + 1.
    //Repeat the process indefinitely. 
    
        Scanner keybd = new Scanner(System.in);
        System.out.print("Starting number: ");
        int n = keybd.nextInt();
        int steps = 0;
        int largest = 0;
        
        while (n != 1)  {
            System.out.print(n+" ");
            
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = n * 3 + 1;
            }
            if (n > largest) {
                largest = n;
            }
            steps++;
        } 
        System.out.println(n);
        System.out.println("Terminated after "+steps+" steps. The largest value was "+largest);
    }
    
}
