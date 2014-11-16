/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simplecalculator;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class CalculatorUI {
    private double a, b, c;
    private String op;
    private int    choice;
    
    public void displayMenu() {
        System.out.println("Calculator Menu");
        System.out.println("1) Add two numbers");
        System.out.println("2) Subtract two numbers");
        System.out.println("3) Multiply two numbers");
        System.out.println("4) Divide two numbers");
        System.out.println("5) Quit");
    }
    
    public void askInput() {
        displayMenu();
        Scanner keybd = new Scanner(System.in);
        while (choice != 5) {
            choice = keybd.nextInt();
            if (choice > 0 && choice < 5) {
                System.out.print("Enter first number : ");
                a  = keybd.nextDouble();
                System.out.print("Enter second number : ");
                b  = keybd.nextDouble();
            }
            switch (choice) {
                    case 1:                        
			op = "+";                        
                        break;
                    case 2:
                        op = "-";
                        break;                        
                    case 3:
                        op = "*";
                        break;
                    case 4:
                        op = "/";
                        break;
                    case 5 :
                        op = "";
                        break;
                    default:
                        op = "error";                        
                        System.out.println("Invalid Choice");
            }
        }
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public void setC(double c) {
        this.c = c;
    }
    
    public String getOp() {
        return op;
    }    
    
    public void displayResult() {
        System.out.println(a+" "+op+" "+" = "+c);
    }
}
