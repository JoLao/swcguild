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
public class FortuneCookie {
    public static void main(String[] args) {
        String[] fortune = {"You will find happiness", "You'll will succeed in your future endeavors",
                        "You will get a raise", "You will won a lottery!",
                        "You will be successful in business", "You will become rich!"};
        Random rGen = new Random();
        int rInt = rGen.nextInt(6) + 1;
        
        System.out.println(fortune[rInt]);
        
        int rInt1;
        
        String dash = "";
        for (int i = 1; i <= 6; i++) {
            rInt1 = rGen.nextInt(54) + 1;
            System.out.print(dash+rInt1);
            dash = "-";
        }
    }
}
