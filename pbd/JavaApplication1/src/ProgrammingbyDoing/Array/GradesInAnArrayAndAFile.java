/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProgrammingbyDoing.Array;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class GradesInAnArrayAndAFile {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
//Prompt the user for a first and last name, and the name for a file. Randomly choose five grades for that person 
//from 1 to 100 and store them in an array that can hold five integers. Then output the first and last name and those
//five grades to the specified file.        
        
        int[] grades = new int[5];
        
        Random rGen = new Random();
        
        String name = promptUser("Name (first last): ");         
        String file = promptUser("Filename: ");
        
        for (int i = 0; i < grades.length; i++) {
            grades[i] = rGen.nextInt(100) + 1;
        }
        
        String msg = "";
        System.out.println("Here are your randomly-selected grades (hope you pass):");
        for (int i = 0; i < grades.length; i++) {
            System.out.println("Grade "+(i + 1)+": "+grades[i]);
            msg = msg + grades[i]+ " ";
        }
        
        PrintWriter writer = new PrintWriter(file, "UTF-8");
        
        writer.println(name);
        writer.println(msg);
        writer.close();
        
    }
    
    public static String promptUser(String message) {
        System.out.print(message);
        Scanner keybd = new Scanner(System.in);
        return keybd.nextLine();
    }
    
}
