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
public class VowelCapitalization {
    public static void main(String[] args) throws Exception {
//Open a file specified by the user. Read in each line from the file, one at a time. Then use charAt() 
//and a loop to process that line one character at a time.
//
//If the character is a consonant, simply display it as-is on the screen. If the character is a lower-case 
//vowel (a,e,i,o,u), display it as a CAPITAL LETTER instead. This is going to take some if statements.
//
//You can try the sample input file vowels.txt to see what your program does. You could also test it on any 
//other file you like.
        Scanner keybd = new Scanner(System.in);
        System.out.print("Open which file: ");
        String inputFile = keybd.nextLine();
        
        Scanner in = new Scanner(new BufferedReader(new FileReader(inputFile)));
        String record = "";
        char byChar;
        while (in.hasNext()) {
            record = in.nextLine();
            
            for (int i = 0; i < record.length(); i++) {
                byChar = record.charAt(i);
                switch (byChar) {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                        System.out.print(Character.toUpperCase(byChar));
                        break;
                    default:
                        System.out.print(byChar);
                }
            }
            System.out.println("");
        }
    }
    
}
