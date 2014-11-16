/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgrammingbyDoing.Records;
//Make a record to store information about a student, which should handle a name, a grade classification, 
//and an average.

import java.util.Scanner;

//
//Create an array of type Student with three slots. Read in values for the three students and print them 
//out again.
//
//You may not use a loop.
public class ALittleDatabase {

    public static void main(String[] args) {
        Student[] students = new Student[3];
        
        Scanner keybd = new Scanner(System.in);
        System.out.print("Enter the first student's name: ");
        String name = keybd.next();
        System.out.print("Enter the first student's grade: ");
        int grade = keybd.nextInt();
        System.out.print("Enter the first student's average: ");
        double average = keybd.nextDouble();

        students[0] = new Student(name, grade, average);

        System.out.println("");
        System.out.print("Enter the second student's name: ");
        name = keybd.next();
        System.out.print("Enter the second student's grade: ");
        grade = keybd.nextInt();
        System.out.print("Enter the second student's average: ");
        average = keybd.nextDouble();

        students[1] = new Student(name, grade, average);

        System.out.println("");
        System.out.print("Enter the third student's name: ");
        name = keybd.next();
        System.out.print("Enter the third student's grade: ");
        grade = keybd.nextInt();
        System.out.print("Enter the third student's average: ");
        average = keybd.nextDouble();

         students[2] = new Student(name, grade, average);


        System.out.println("");
        System.out.println("The names are " + students[0].getName() + " " + students[1].getName() + " " + students[2].getName());
        System.out.println("The grades are " + students[0].getGrade() + " " + students[1].getGrade() + " " + students[2].getGrade());
        System.out.println("The averages are " + students[0].getAverage() + " " + students[1].getAverage() + " " + students[2].getAverage());

    }

}
