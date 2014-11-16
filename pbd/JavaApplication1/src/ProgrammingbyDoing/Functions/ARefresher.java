/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgrammingbyDoing.Functions;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class ARefresher {
//Just a short program to refresh your memory about how to program. Write a program that prompts 
//the user for a name. Then display that name ten times. You must use a loop. If the name given is 
//"Mitchell", display it only five times.    

    public static void main(String[] args) {
        Scanner keybd = new Scanner(System.in);
        System.out.print("What is your name: ");
        String name = keybd.next();
        
        int times = 10;
        if (name.equalsIgnoreCase("Mitchell")) {
            times = 5;
        }
        
        for (int i = 1; i <= times; i++) {
            System.out.println(name);
        }
    }
}
