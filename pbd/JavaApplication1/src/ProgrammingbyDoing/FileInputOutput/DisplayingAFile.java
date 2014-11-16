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
public class DisplayingAFile {
    public static void main(String[] args) throws Exception {
//Ask the user for the name of a file to open. Open that file, and display the entire contents 
//of the file on the screen.
//
//You must do this a line at a time using nextLine() and a loop that checks hasNext().        
        Scanner keybd = new Scanner(System.in);
        System.out.print("Open which file: ");
        String inputFile = keybd.nextLine();
        
        Scanner in = new Scanner(new BufferedReader(new FileReader(inputFile)));
        while (in.hasNext()) {
            System.out.println(in.nextLine());
        }
        in.close();
    }
    
}
