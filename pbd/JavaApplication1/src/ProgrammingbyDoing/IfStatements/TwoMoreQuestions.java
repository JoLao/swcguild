/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProgrammingbyDoing.IfStatements;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class TwoMoreQuestions {
    public static void main(String[] args) {
      
        Scanner keybd = new Scanner(System.in);
        
        System.out.println("Two Questions");
        System.out.println("Think of something and I'll try to guess it!");
        
        System.out.print("Question 1: Does it belong inside or outside or both? ");
        String ans1 = keybd.next();
        
        System.out.print("Question 2: Is it alive? ");
        String ans2 = keybd.next();
        
        if (ans1.equalsIgnoreCase("inside") && ans2.equalsIgnoreCase("alive")) {
            System.out.println("It's a houseplant");
        } else if (ans1.equalsIgnoreCase("inside") && ans2.equalsIgnoreCase("not alive")) {
            System.out.println("It's a shower curtain");
        } else if (ans1.equalsIgnoreCase("outside") && ans2.equalsIgnoreCase("alive")) {
            System.out.println("It's a bison");
        } else if (ans1.equalsIgnoreCase("outside") && ans2.equalsIgnoreCase("not alive")) {
            System.out.println("It's a billboard");
        } else if (ans1.equalsIgnoreCase("both") && ans2.equalsIgnoreCase("alive")) {
            System.out.println("It's a dog");
        } else if (ans1.equalsIgnoreCase("inside") && ans2.equalsIgnoreCase("not alive")) {
            System.out.println("It's a cell phone");
        }
        	
    }
    
}
