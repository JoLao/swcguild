/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProgrammingbyDoing.RandomNumbers;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class ThreeCardMonte {
    public static void main(String[] args) {
        System.out.println("You slide up to Fast Eddie's card table and plop down your cash.");
        System.out.println("He glances at you out of the corner of his eye and starts shuffling.");
        System.out.println("He lays down three cards.");        
        
        String cup1a = "##";
        String cup1b = "##";
        String cup2a = "##";
        String cup2b = "##";
        String cup3a = "##";
        String cup3b = "##";
        
        System.out.println(cup1a+"  "+cup2a+"  "+cup3a);
        System.out.println(cup1b+"  "+cup2b+"  "+cup3b);
        System.out.println("1   2   3");
        
        Random rGen = new Random();
        int rInt = rGen.nextInt(3)+1;
        
        Scanner keybd = new Scanner(System.in);
        System.out.println("Which one is the ace?");
        int userNum = keybd.nextInt();
        
        if (userNum == rInt) {
            System.out.println("You nailed it! Fast Eddie reluctantly hands over your winnings, scowling.");            
        } else {
            System.out.println("Ha! Fast Eddie wins again! The ace was card number "+rInt);
        }
        
        switch (rInt) {
            case 1:
                cup1a = "AA";
                cup1b = "AA";
                break;
            case 2:
                cup2a = "AA";
                cup2b = "AA";
                break;
            case 3:
                cup3a = "AA";
                cup3b = "AA";
                break;
        }
        System.out.println(cup1a+"  "+cup2a+"  "+cup3a);
        System.out.println(cup1b+"  "+cup2b+"  "+cup3b);
        System.out.println("1   2   3");      
        
    }
    
}
