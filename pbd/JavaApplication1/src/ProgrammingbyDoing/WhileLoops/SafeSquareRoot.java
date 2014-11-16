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
public class SafeSquareRoot {
    public static void main(String[] args) {
        System.out.println("SQUARE ROOT!");
        
        Scanner keybd = new Scanner(System.in);
        double num = 0;
        
        while (num < 1) {
            System.out.print("Enter a number : ");
            num = keybd.nextDouble();
        }    
        double sqRoot = Math.sqrt(num);
        System.out.println("The square root of "+num+" is "+sqRoot);
        
    }
}
