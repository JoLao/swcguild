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
public class TwentyQuestions {
    public static void main(String[] args) {
        Scanner keybd = new Scanner(System.in);
        
        System.out.println("Twenty Questions");
        System.out.println("Think of an object, and I'll try to guess it.");
        
        System.out.print("Question 1) animal, vegetable, or mineral? ");
        String ans1 = keybd.next();
        
        System.out.print("Question 2) is it bigger than a breadbox?");
        String ans2 = keybd.next();
        
        switch(ans1) {
        case "animal" :
            if (ans2.equals("Y")) {
                System.out.println("It's a squirrel");
            } else {
                System.out.println("Must be a moose");
            }
            break;
    
        case "vegetable" :
           if (ans2.equals("Y")) {
                System.out.println("It's a carrot");
            } else {
                System.out.println("Must be a watermelon");
            }
            break;
        case "mineral" :
            if (ans2.equals("Y")) {
                System.out.println("It's a paper clip");
            } else {
                System.out.println("Must be a Camaro");
            }
            break;
        }
        
    }
}
