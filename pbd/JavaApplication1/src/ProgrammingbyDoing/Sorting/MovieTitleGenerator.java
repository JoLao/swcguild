/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgrammingbyDoing.Sorting;

import java.net.URL;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class MovieTitleGenerator {
//Download the following code, and get it to compile. It fills up an array with a bunch of random adjectives and 
//another array with a bunch of random nouns.

//It is intended to create a random movie title by picking a random adjective and noun out of the arrays.
//Make it so that the adjective and noun are chosen randomly out of their respective arrays. 
    public static void main(String[] args) throws Exception {

        String[] adjectives = arrayFromUrl("https://cs.leanderisd.org/txt/adjectives.txt");
        String[] nouns = arrayFromUrl("https://cs.leanderisd.org/txt/nouns.txt");
        Random rGen1 = new Random();
        Random rGen2 = new Random();
        
        int rInt1 = rGen1.nextInt(adjectives.length) + 1;
        int rInt2 = rGen2.nextInt(nouns.length) + 1;

        System.out.println("Mitchell's Random Movie Title Generator\n");

        System.out.print("Choosing randomly from " + adjectives.length + " adjectives ");
        System.out.println("and " + nouns.length + " nouns (" + (adjectives.length * nouns.length) + " combinations).");

        String adjective = adjectives[rInt1]; //"Cool";
        String noun      = nouns[rInt2]; //"Mitchell";

        System.out.println("Your movie title is: " + adjective + " " + noun);
    }

    /**
     * @param url - the URL to read words from
     * @return An array of words, initialized from the given URL
     * @throws java.lang.Exception
     */
    public static String[] arrayFromUrl(String url) throws Exception {
        String[] words;
        //try (Scanner fin = new Scanner((new URL(url)).openStream())) {
            Scanner fin = new Scanner((new URL(url)).openStream());        
            int count = fin.nextInt();            
            
            words = new String[count];
            for (int i = 0; i < words.length; i++) {
                words[i] = fin.next();
            }
        //}

        return words;
            
    }

}
