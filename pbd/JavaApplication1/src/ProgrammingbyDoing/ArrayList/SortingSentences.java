/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProgrammingbyDoing.ArrayList;
//Write a program that creates an ArrayList of Strings. Let the user type in a sentence using 
//keyboard.nextLine(). Using String.split(), break up the sentence into an array of Strings 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//and then put those Strings into an ArrayList. Also, force all the Strings to lowercase.
//
//Then, using the String ArrayList sorting function you already wrote, put the words in 
//alphabetical order and print them out again.
public class SortingSentences {
    public static void main(String[] args) {        
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Sentence: ");
        String sentence = keyboard.nextLine();
        ArrayList<String> arrStr = new  ArrayList<String>(Arrays.asList(sentence.toLowerCase().split(" ")));
        Collections.sort(arrStr);
        System.out.println("Sorted: "+arrStr);
    }
    
}
