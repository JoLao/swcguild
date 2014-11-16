/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProgrammingbyDoing.RandomNumbers;

import java.util.Random;

/**
 *
 * @author apprentice
 */
public class BabyBlackjack {
    
    public static void main(String[] args) {
    //Write a program that allows a human user to play a single hand of "blackjack" against a dealer.
    //Pick two values from 1-10 for the player. These are the player's "cards".
    //Pick two more values from 1-10 for the dealer.
    //Whoever has the highest total is the winner.
    //There is no betting, no busting, and no hitting. Save that for real blackjack. 
        System.out.println("Baby Blackjack!");
        
        Random rGen1 = new Random();
        Random rGen2 = new Random();
        Random rGen3 = new Random();
        Random rGen4 = new Random();
        
        int playerNum1 = rGen1.nextInt(10)+1;
        int playerNum2 = rGen2.nextInt(10)+1;
        
        int dealerNum1 = rGen3.nextInt(10)+1;
        int dealerNum2 = rGen4.nextInt(10)+1;
        
        int player = playerNum1 + playerNum2;
        int dealer = dealerNum1 + dealerNum2;
        
        System.out.println("You drew "+playerNum1+" and "+playerNum2);
        System.out.println("You total is "+player);
        System.out.println("Dealer drew "+dealerNum1+" and "+dealerNum2);
        System.out.println("Dealer's total is "+dealer);
        if (player > dealer) {
            System.out.println("You Win!");
        } else if (player < dealer) {
            System.out.println("You Lose!");
        } else {
            System.out.println("It's a draw!");
        }
    }
    
}
