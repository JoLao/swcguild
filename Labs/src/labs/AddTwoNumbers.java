/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package labs;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        Scanner keybd = new Scanner(System.in);
        
        String cont = "Y";
        int num1 = 0, num2 = 0; 
        int sum = 0;
        
        while (cont.toUpperCase().equals("Y")) {
            
            System.out.print("Please enter a number : ");
            num1 = keybd.nextInt();
            
            System.out.print("Please enter another number : ");
            num2 = keybd.nextInt();
            
            sum = num1 + num2;
            
            System.out.println(num1 + " + "+num2+" = "+sum);
            System.out.print("Would you like to continue (Y/N)? ");
            
            cont = keybd.next();
            System.out.println(cont);
        }
    }
}