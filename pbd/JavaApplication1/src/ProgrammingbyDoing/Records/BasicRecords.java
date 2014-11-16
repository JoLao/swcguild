/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProgrammingbyDoing.Records;

//Make a record to store information about a student, which should handle a name, 

import java.util.Scanner;

//a grade classification, and an average.
//
//Create three variables of type Student. Read in values for the three students and print them out again.
//
//Give the average for all three students.
//
//Do not use an array, and do not use any loops.
public class BasicRecords {
    public static void main(String[] args) {
        Scanner keybd = new Scanner(System.in);
        System.out.print("Enter the first student's name: ");
        String name1 = keybd.next();
        System.out.print("Enter the first student's grade: ");
        int    grade1 = keybd.nextInt();
        System.out.print("Enter the first student's average: ");
        double average1 = keybd.nextDouble();
        
        Student student1 = new Student(name1, grade1, average1);
        
        System.out.println("");
        System.out.print("Enter the second student's name: ");
        String name2 = keybd.next();
        System.out.print("Enter the second student's grade: ");
        int    grade2 = keybd.nextInt();
        System.out.print("Enter the second student's average: ");
        double average2 = keybd.nextDouble();
        
        Student student2 = new Student(name2, grade2, average2);
        
        System.out.println("");
        System.out.print("Enter the third student's name: ");
        String name3 = keybd.next();
        System.out.print("Enter the third student's grade: ");
        int    grade3 = keybd.nextInt();
        System.out.print("Enter the third student's average: ");
        double average3 = keybd.nextDouble();
        
        Student student3 = new Student(name3, grade3, average3);
        
        System.out.println("");
        System.out.println("The names are "+student1.getName()+" "+student2.getName()+" "+student3.getName());
        System.out.println("The grades are "+student1.getGrade()+" "+student2.getGrade()+" "+student3.getGrade());
        System.out.println("The averages are "+student1.getAverage()+" "+student2.getAverage()+" "+student3.getAverage());
        
        System.out.println("The average for the three students is: "+
                           ((student1.getAverage() + student2.getAverage() + student3.getAverage())/ 3));
    }
    
}
