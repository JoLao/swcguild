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
public class MoreUserInputofData {
    public static void main(String[] args) {
        
    String firstName;
    String lastName;
    int grade;
    String studentID;
    String loginName;
    double GPA;
    
    Scanner keybd = new Scanner(System.in);
    
    System.out.println("Please enter the following information so I can sell it for a profit!");
    System.out.print("First Name : ");
    firstName = keybd.next();
    System.out.print("Last Name : ");
    lastName = keybd.next();
    System.out.print("Grade (9-12) : ");
    grade = keybd.nextInt();
    System.out.print("Student ID: ");
    studentID = keybd.next();
    System.out.print("Login:");
    loginName = keybd.next();
    System.out.print("GPA (0.0-4.0): ");
    GPA = keybd.nextDouble();
    
    System.out.println("Your information:");
    System.out.println("         Login: "+loginName); 
    System.out.println("         ID:    "+studentID);
    System.out.println("         Name:  "+lastName+", "+firstName);
    System.out.println("         GPA:   "+GPA);
    System.out.println("         Grade: "+grade); 
    }
}
