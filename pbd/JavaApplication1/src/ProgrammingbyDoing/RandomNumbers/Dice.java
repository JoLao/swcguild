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
public class Dice {
    public static void main(String[] args) {

        System.out.println("HERE COMES THE DICE!");
        
        Random rGen1, rGen2;
        int dice1, dice2, sum;

        rGen1 = new Random();
        rGen2 = new Random();
        
        do {
            dice1 = rGen1.nextInt(6) + 1;
            dice2 = rGen2.nextInt(6) + 1;
            System.out.println("Roll #1: "+dice1);
            System.out.println("Roll #2: "+dice2);
            sum = dice1 + dice2;
            System.out.println("The total is "+sum+"!");
        } while (dice1 != dice2);
    }
}
