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
public class SummingThreeNumbersFromAnyFile {
    public static void main(String[] args) throws Exception {
//Create several more files in Notepad containing three integers separated by some whitespace. 
//Save them in your home directory as "3nums1.txt", "3nums2.txt", "3nums3.txt", etc.
//
//Then write a program that asks the user which file to open. Then it should open that file, 
//and read the three integers from the file. It should then display (on the screen) the total of the integers.        
        Scanner keybd = new Scanner(System.in);
        System.out.print("Which file would you like to read numbers from: ");
        String inputFile = keybd.nextLine();
        System.out.println("Reading numbers from file "+inputFile);
        
        Scanner in = new Scanner(new BufferedReader(new FileReader(inputFile)));
        int sum = 0, num = 0;
        String plus = "";
        while (in.hasNext()) {  //when hasNextLine() was used, I am getting java.lang.NumberFormatException: For input string: ""
            num = Integer.parseInt(in.nextLine());
            sum += num;
            System.out.print(plus+num);
            plus = " + ";
        }
        System.out.println(" = "+sum);
        in.close();
    }
    
}
