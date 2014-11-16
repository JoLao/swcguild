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
public class ChooseYourOwnAdventure {
    public static void main(String[] args) {
        
        Scanner keybd = new Scanner(System.in);
        
        System.out.println("WELCOME TO MITCHELL'S TINY ADVENTURE!");
        System.out.print("You are in a creepy house!  Would you like to go \"upstairs\" or into the\n" +
"\"kitchen\"?");
        
        String location = keybd.next();
        String location1;
        if (location.equals("kitchen")) {
            System.out.print("There is a long countertop with dirty dishes everywhere.  Off to one side\n" +
"there is, as you'd expect, a refrigerator. You may open the \"refrigerator\"\n" +
"or look in a \"cabinet\".");
            location1 = keybd.next();
            if (location1.equals("refrigerator")) {
                System.out.print("Inside the refrigerator you see food and stuff.  It looks pretty nasty.\n" +
"Would you like to eat some of the food? (\"yes\" or \"no\")");
                String eatFood = keybd.next();
                if (eatFood.equals("N")) {
                    System.out.println("You die of starvation... eventually.");
                }
            }
        } else if (location.equals("upstairs")) {
            System.out.print("Upstairs you see a hallway.  At the end of the hallway is the master\n" +
"\"bedroom\".  There is also a \"bathroom\" off the hallway.  Where would you like\n" +
"to go?");
            location1 = keybd.next();
            if (location1.equals("bedroom")) {
                System.out.println("You are in a plush bedroom, with expensive-looking hardwood furniture.  The\n" +
"bed is unmade.  In the back of the room, the closet door is ajar.  Would you\n" +
"like to open the door? (\"yes\" or \"no\")");
                String openDoor = keybd.next();
                if (openDoor.equals("N")) {
                    System.out.println("Well, then I guess you'll never know what was in there.  Thanks for playing,\n" +
"I'm tired of making nested if statements.");
                }
            }
        }
    }
    
}
