/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProgrammingbyDoing.Array;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class ParallelArrays {
    
    public static void main(String[] args) {
//Create three arrays to store data about five people. The first array should be Strings and should hold their 
//last names. The next array should be doubles and should hold a grade average (on a 100-point scale). The last array 
//should be ints, should hold their student id numbers.

//Give each of the arrays values (using array initializers). Then print the values of all three arrays on the screen.

//Finally, ask the user for an ID number to lookup. Search through the ID array until you find that ID, and 
//then print out the values from the same slot number of the other two arrays.        
        String[] lastName     = {"Anderson","Cruise", "Gunn", "Jackson", "Smith"};
        double[] gradeAverage = {80, 90, 75, 60, 55};
        int[]    studentID    = {1010, 4536, 8394, 7284, 9283};
        
        Scanner keybd = new Scanner(System.in);
        
        System.out.println("");
        System.out.println("Values : ");
        for (int i = 0; i < lastName.length; i++) {
            System.out.println(lastName[i]+" "+gradeAverage[i]+" "+studentID[i]);
        }
        
        System.out.print("Id number to find : ");
        int sID = keybd.nextInt();
        
        for (int i = 0; i < studentID.length; i++) {
            if (sID == studentID[i]) {
                System.out.println("Found in slot "+i);
                System.out.println("     Name : "+lastName[i]);
                System.out.println("     Average : "+gradeAverage[i]);
                System.out.println("     ID : "+studentID[i]);
            }
        }
        
    }
}
