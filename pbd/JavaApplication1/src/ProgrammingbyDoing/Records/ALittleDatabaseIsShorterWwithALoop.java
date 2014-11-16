/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProgrammingbyDoing.Records;

//Make a record to store information about a student, which should handle a name, a grade classification, 

import java.util.Scanner;

//and an average.
//
//Create an array of type Student with three slots. Read in values for the three students and print them 
//out again.
//
//You must use a for loop.
public class ALittleDatabaseIsShorterWwithALoop {
     public static void main(String[] args) {
        Student[] students = new Student[3];
        
        Scanner keybd = new Scanner(System.in);
        String name    = "";
        int    grade   = 0;
        double average = 0;
        
        for (int i = 0; i < students.length; i++) {
            System.out.println("");
            System.out.print("Enter student "+(i+1)+"'s name: ");
            name = keybd.next();
            System.out.print("Enter student "+(i+1)+"'s grade: ");
            grade = keybd.nextInt();
            System.out.print("Enter student "+(i+1)+"'s average: ");
            average = keybd.nextDouble();

            students[i] = new Student(name, grade, average);
        }
        
        System.out.println("");
        
        System.out.print("The names are: ");
        for (int i = 0; i < students.length; i++) {
            System.out.print(students[i].getName() + " ");
        }
                
        System.out.println("");
        
        System.out.print("The grades are: ");
        for (int i = 0; i < students.length; i++) {
            System.out.print(students[i].getGrade() + " ");
        }
                
        System.out.println("");
        
        System.out.print("The averages are: ");
        for (int i = 0; i < students.length; i++) {
            System.out.print(students[i].getAverage() + " ");
        }
        
        System.out.println("");
     }
}
