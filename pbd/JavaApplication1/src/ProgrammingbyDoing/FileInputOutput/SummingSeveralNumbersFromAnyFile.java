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
public class SummingSeveralNumbersFromAnyFile {
    public static void main(String[] args) throws Exception {
//Create a few more files in Notepad containing some integers separated by some whitespace. 
//Save them in your home directory as "4nums.txt", "5nums.txt", "6nums.txt", etc.
//
//Then write a program that asks the user which file to open. Then it should open that file, 
//and read in and total up all the integers from that file.
//
//You won't be able to store each number in its own variable anymore. Instead, you'll need to 
//use a loop, and reuse the same variable over and over. You'll have to add up the numbers as you go. 
//You've done this before.        
        Scanner keybd = new Scanner(System.in);
        System.out.print("Which file would you like to read numbers from:");
        String inputFile = keybd.nextLine();
        System.out.println("Reading numbers from file "+inputFile);
        
        Scanner in = new Scanner(new BufferedReader(new FileReader(inputFile)));
        int sum = 0, num = 0;
        while (in.hasNext()) {
            num = in.nextInt();
            sum += num;
        } 
        System.out.println("Total is "+sum);
        in.close();
    }
    
}
