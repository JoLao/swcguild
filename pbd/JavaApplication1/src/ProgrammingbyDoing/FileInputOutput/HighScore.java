/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProgrammingbyDoing.FileInputOutput;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class HighScore {
    public static void main(String[] args) throws IOException {
//Write a dumb little program that asks the user for their name and a number. 
//Then store that name and that "high score" in a file. The file should be called "score.txt".        
        Scanner keybd = new Scanner(System.in);
        System.out.print("Please enter your score: ");
        int score = keybd.nextInt();
        System.out.print("Please enter your name: ");
        String name = keybd.next();
        PrintWriter out = new PrintWriter(new FileWriter("score.txt"));
        out.println(name);
        out.println(score);
        out.flush();
        out.close();
    }
    
}
