/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamebot.domain;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class Hangman implements Game {
    private final  String name = "Hangman";
    private static String[] words = {"leviathan", "promethius", "congregation", "victory", "international"};
    private static char[] letters;

    @Override
    public String getNameOfGame() {
        return this.name;
    }

    
    @Override
    public void execute() {
        //Write a program to play a word-guessing game like Hangman.

        //  It must randomly choose a word from a list of words.
        //  It must stop when all the letters are guessed.
        //  It must give them limited tries and stop after they run out.
        //  It must display letters they have already guessed (either only the incorrect guesses or all guesses).         
        Random rGen = new Random();
        int rInt = rGen.nextInt(5);

        String play = "again";
        boolean guessed = false;
        boolean letterFound = false;
        int numOfGuess = 0;
        String misses = "";
        char letter = ' ';
        int wordLength = 0;
        Scanner keyboard = new Scanner(System.in);

        int tries = 0;
        int triesAllowed = 0;

        //char ch = 'J';	 
        //String string1 = Character.toString(ch);
        //String string2 = String.valueOf(ch);
        //String string = "JavaCodeGeeks";
        //char[] charArray = string.toCharArray();
        //System.out.println("String is:" + string + " Character Array : "
        //      + Arrays.toString(charArray));
        do {
            rInt = rGen.nextInt(5);
            guessed = false;
            letterFound = false;
            numOfGuess = 0;
            misses = "";
            tries = 0;

            wordLength = words[rInt].length();
            //System.out.println("words[" + rInt + "] : " + words[rInt]);
            triesAllowed = wordLength + 5;

            initializeLettersArray(wordLength);
            printWord(wordLength, misses);

            while (!guessed && tries <= triesAllowed) {               

                System.out.print("Guess:	");
                letter = (char) keyboard.next().charAt(0);
                numOfGuess++;

                letterFound = false;
                for (int i = 0; i < wordLength; i++) {
                    if (words[rInt].charAt(i) == letter) {
                        letters[i] = letter;
                        letterFound = true;
                    }
                }
                if (!letterFound) {
                    misses += letter;
                }
                printWord(wordLength, misses);
                guessed = checkIfGuessed(letters);                
                tries++;
            }
            if (tries > triesAllowed && !guessed) {
                System.out.println("Maximum tries reached..");
                System.out.println("The word is " + words[rInt]);
            }
            if (guessed) {
                System.out.println("You got it!");
            }
            System.out.println("Play \"again\" or \"quit\"?");
            play = keyboard.next();

        } while (play.equalsIgnoreCase("again"));

    }

    public static boolean checkIfGuessed(char[] let) {

        for (int i = 0; i < let.length; i++) {
            if (let[i] == '-') {
                return false;
            }
        }
        return true;
    }

    public static void initializeLettersArray(int wordLength) {
        letters = new char[wordLength];
        for (int i = 0; i < wordLength; i++) {
            letters[i] = '-';
        }
    }

    public static void printWord(int wordLength, String misses) {
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.print("Word:");

        for (int i = 0; i < wordLength; i++) {
            if (letters[i] != '-') {
                System.out.print(letters[i]);
            } else {
                System.out.print("-");
            }
        }
        System.out.println("");
        System.out.println("Misses:	" + misses);
    }
}
