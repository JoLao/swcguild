/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProgrammingbyDoing.IfStatements;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class AlphabeticalOrder {
    public static void main(String[] args) {
        Scanner keybd = new Scanner(System.in);
        System.out.print("What's your last name? ");
        String lName = keybd.next(); 
        if (lName.compareTo("Carswell") < 0) {
            System.out.println("you don't have to wait long, "+lName);
        } else if (lName.compareTo("Jones") < 0) {
            System.out.println("that's not bad, "+lName);
        } else if (lName.compareTo("Smith") < 0) {
            System.out.println("looks like a bit of a wait, "+lName);
        } else if (lName.compareTo("Young") < 0) {
            System.out.println("it's gonna be a while, "+lName);
        } else {
            System.out.println("not going anywhere for a while? "+lName);
        }
    }
    
}
