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
public class DumbCalculator {
    public static void main(String[] args) { 
        Scanner keybd = new Scanner(System.in);
        
        System.out.print("What is your first number? ");
        double firstNum = keybd.nextDouble();
        
        System.out.print("What is your second number? ");
        double secondNum = keybd.nextDouble();
        
        System.out.print("What is your third number? ");
        double thirdNum = keybd.nextDouble();        
     
        double total = (firstNum + secondNum + thirdNum) / 2;
        
        System.out.println("( "+firstNum+" + "+secondNum+" + "+thirdNum+" ) / 2 is... "+total);
    }    
}
