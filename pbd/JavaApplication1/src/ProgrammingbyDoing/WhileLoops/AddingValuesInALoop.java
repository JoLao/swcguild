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
public class AddingValuesInALoop {
    public static void main(String[] args) {
        Scanner keybd = new Scanner(System.in);
        int num = 0, total = 0;
        
        do {
            System.out.print("Please enter a number : ");
            num = keybd.nextInt();
            total += num;
            System.out.println("Total so far is "+total);
        } while (num !=0);
        
    }
    
}
