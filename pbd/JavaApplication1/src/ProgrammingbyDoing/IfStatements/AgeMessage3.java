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
public class AgeMessage3 {
    public static void main(String[] args) {
        Scanner keybd = new Scanner(System.in);
        
        System.out.print("Your name : ");
        String name = keybd.next();
        
        System.out.print("Your age  : ");
        int age = keybd.nextInt();
        String msg;
        
        if (age < 16) {
            msg = "You can't drive, "+name;
        } else if (age < 18) {
           msg = "You can drive but not vote, "+name;
        } else if (age < 25) {
           msg = "You can vote but not rent a car, "+name;
        } else {
           msg = "You can do pretty much anything, "+name;
        }
        System.out.println(msg);
    }
    
}
