/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package refactorintoobjects;


import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class Factorizer {
    private int inputNum;
    
    public void execute() {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("What number would you like to factor? ");
        inputNum = sc.nextInt();
        int addNum = 0;
        
        System.out.println("The factors of "+inputNum+" are ");
        for (int i = 1; i < inputNum; i++) {
            if ((inputNum % i == 0)) {
                System.out.println(i);
                addNum += i;
            }
        }
        if (addNum == inputNum) {
            System.out.println(inputNum+" is a perfect number.");
        }
        if (addNum > 1) {
            System.out.println(inputNum+" is not a prime number.");
        }
    }
    
}

