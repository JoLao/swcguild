/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProgrammingbyDoing.KeyboardInput;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class NameAgeSalary {
    public static void main(String[] args) {
        Scanner keybd = new Scanner(System.in);
        
        System.out.print("Hello. What is your name? ");
        String name = keybd.next();
        
        System.out.print("Hi, "+name+"!  How old are you? ");
        int age = keybd.nextInt();
        
        System.out.println("So you're "+age+", eh?  That's not old at all!");
        System.out.print("How much do you make, "+name+"? ");
        double salary = keybd.nextDouble();
        System.out.print(salary+"!  I hope that's per hour and not per year! LOL!");
        
        
    }
}
