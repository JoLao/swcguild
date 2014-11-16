/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fileioexample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;


/**
 *
 * @author apprentice
 */
public class FileIOExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
        out.println("this is line 1");
        out.println("this is line 2");
        out.flush();
        out.close();
        
        Scanner in = new Scanner(new BufferedReader(new FileReader("output.txt")));
        String currentLine = "";
        while (in.hasNextLine()) {
            currentLine = in.nextLine();
            System.out.println(currentLine);
        }
    }
    
}