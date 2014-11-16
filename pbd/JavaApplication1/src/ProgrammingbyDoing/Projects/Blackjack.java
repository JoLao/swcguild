/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgrammingbyDoing.Projects;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class Blackjack {

    public static void main(String[] args) {
    //Write a program that allows a human user to play a simplified version of Blackjack against a computer opponent.

        //Don't worry about suits or face cards; "cards" will have values from 2-11, and all values are equally 
        //likely (that is, unlike a real blackjack game, there's no greater chance of drawing a card with value 10).
        //Draw two cards for the player and display them.
        //Draw two cards for the "dealer" and display one of them, keeping the other one hidden.
        //Allow the player to "hit" as many times as he would like.
        //If the player "busts" (gets a total over 21), the dealer automatically wins.
        //Allow the dealer to hit as many times as he would like. Dealer should probably hit on sixteen or lower.
        //If the dealer busts, the player automatically wins.
        //Assuming no one has busted, the player with the highest total wins. Dealer wins all ties. 
        System.out.println("Welcome to Mitchell's blackjack program!");

        Random rGen1 = new Random();
        Random rGen2 = new Random();
        Random rGen3 = new Random();
        Random rGen4 = new Random();

        int playerNum1, playerNum2, player;
        int dealerNum1, dealerNum2, dealer;

        boolean hit = true;
        String play = "";

        playerNum1 = rGen1.nextInt(10) + 1;
        playerNum2 = rGen2.nextInt(10) + 1;

        dealerNum1 = rGen3.nextInt(10) + 1;
        dealerNum2 = rGen4.nextInt(10) + 1;

        player = playerNum1 + playerNum2;
        dealer = dealerNum1 + dealerNum2;

        System.out.println("You drew " + playerNum1 + " and " + playerNum2);
        System.out.println("You total is " + player);
        System.out.println("The Dealer has a " + dealerNum1 + " showing and a hidden card");
        System.out.println("His total is hidden, too.");

        Scanner keybd = new Scanner(System.in);

        while (hit) {
            System.out.println(" ");
            System.out.print("Would you like to \"hit\" or \"stay\"? ");
            play = keybd.next();
            if (play.equalsIgnoreCase("hit")) {
                hit = true;
                playerNum2 = rGen2.nextInt(10) + 1;
                System.out.println("You drew a " + playerNum2);
                player += playerNum2;
                System.out.println("Your total is " + player);
            } else {
                hit = false;
            }
            if (player > 21) {
                System.out.println("Busts. The dealer automatically wins. ");
                hit = false;
            }
        }

        System.out.println("");
        System.out.println("Okay, dealer's turn.");
        System.out.println("His hidden card was a " + dealerNum2);
        System.out.println("His total was " + dealer);
        hit = true;

        while (hit && dealer < player) {
            dealerNum2 = rGen2.nextInt(10) + 1;
            System.out.println("He draws a " + dealerNum2);
            dealer += dealerNum2;
            System.out.println("His total is " + dealer);
            System.out.println("");
            if (dealer < player && dealer < 21) {
                System.out.println("Dealer chooses to hit");
            } else {
                System.out.println("Dealer stays");
                hit = false;
            }
        }
        System.out.println("Dealer total is " + dealer);
        System.out.println("Your total is " + player);
        System.out.println("");

        if (player <= 21) {
            if (player > dealer || dealer > 21) {
                System.out.println("You win!");
            }
        } 
        if (dealer > player && dealer <= 21) {
            System.out.println("Dealer wins!");
        }
    }
}
