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
public class PrimeNumbers {

    public static void main(String[] args) {
              
        Scanner keybd = new Scanner(System.in);
        String answer;

        do {
            System.out.print("Please enter a number : ");
            int num = keybd.nextInt();
            //boolean isPrime = true;

            for (int i = 1; i <= num; i++) {
           //     for (int j = 2; j < i; j++) {
           //         if (i % j == 0) {
           //             isPrime = false;
           //             break;
           //         }
           //     }                
           //     if (isPrime) {
                if (isPrimeNbr(i)) {
                    System.out.println(i);
                }
            //    isPrime = true;
            }
            System.out.print("Do you want to do another number? ");
            answer = keybd.next();
        } while (answer.equalsIgnoreCase("Y"));
    }

    public static boolean isPrimeNbr(int num) {
        for (int j = 2; j < num; j++) {
            if (num % j == 0) {
                return false;                
            }
        }
        return true;
    }
   
}
