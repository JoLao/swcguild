/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProgrammingbyDoing.FileInputOutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class SimpleFileInput {
    public static void main(String[] args) throws Exception {
//Start by creating a text file in Notepad (or Textpad) containing your first and last name, separated by whitespace. 
//Save it as "name.txt".
//
//Then write a program that opens that file and displays the two names on the screen, with no input from the keyboard.
//
//Then try changing the name in the file, saving it again, and running the program again with no changes to confirm 
//that it works.        
        Scanner in = new Scanner(new BufferedReader(new FileReader("name.txt")));
        String name = "";
        
        while (in.hasNext()) {
            name = in.nextLine();
        }
        name = "J. Lao";
        PrintWriter out = new PrintWriter(new FileWriter("name.txt"));
        out.println(name);
        out.flush();
        out.close();
    }               
}
