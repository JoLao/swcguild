/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProgrammingbyDoing.FileInputOutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class SummingThreeNumbersFromAFile {
    public static void main(String[] args) throws Exception
    {
//First, create a file in Notepad containing three integers separated by some whitespace. Save it as "3nums.txt" 
//in the same folder as your code.      
//Then write a program that reads three integers from the file 3nums.txt and displays (on the screen) the total 
//of the integers.        
        Scanner in = new Scanner(new BufferedReader(new FileReader("3nums.txt")));
        int sum = 0, num = 0;
        String plus = "";
        while (in.hasNext()) {
            num = Integer.parseInt(in.nextLine());
            sum += num;
            System.out.print(plus+num);
            plus = " + ";
        }
        System.out.println(" = "+sum);
        in.close();
    }
    
}
