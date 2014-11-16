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
public class GenderGame {
    public static void main(String[] args) {
        Scanner keybd = new Scanner(System.in);
        
        System.out.print("What is your gender (M or F): ");
        String gender = keybd.next();
        
        System.out.print("First name: ");
        String fName = keybd.next();
        
        System.out.print("Last name: ");
        String lName = keybd.next();
        
        System.out.print("Age: ");
        int age = keybd.nextInt();
        
        String maritalStatus;
        
        if (gender.equals("F") && age > 20) {
            System.out.print("Are you married (y/n)? ");
            maritalStatus = keybd.next();
            if (maritalStatus.equals("Y")) {
                System.out.println("Then I shall call you Mrs "+lName);
            } else {
                System.out.println("Then I shall call you "+fName+" "+lName);
            }
        } else if (gender.equals("M") && age > 20) {
            System.out.println("Then I shall call you Mr "+lName);
        } else {
            System.out.println("Then I shall call you "+fName+" "+lName);
        }
                    
        
    }
    
}
