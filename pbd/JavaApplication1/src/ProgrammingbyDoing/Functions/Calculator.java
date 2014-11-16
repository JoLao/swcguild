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
public class Calculator {
//Write a calculator program. A minimal calculator will support the following functions:
//
//    numbers with decimals (not just integers)
//    addition (1 + 2 is 3)
//    subtraction (12 - 4 is 8)
//    multiplication (33 * 2 is 66)
//    division (3 / 8 is 0.375)
//    exponents (2 ^ 3 is 8)
//    error messages when you do something wrong 
//
//Your calculator should keep on running until explicitly told to quit. I suggest typing 
//a zero as the first operand to cause it to quit, i.e.    
//Programs may support other features if desired. Suggested other functions to add include:
//
//    modulus (10 % 3 is 1)
//    factorials (4 ! is 4*3*2*1, a.k.a. 24)
//    trigonometric functions (sin,cos,tan)
//    square roots
//    negation (- -3 is 3)
//    angles in degrees or radians
//    a help feature to display legal syntax and supported functions
//    previous result used as first operand
//    the ability to store and recall results
//    rounding
//    logarithms
//    arbitrary roots
//    conversion from base 10 to binary (for integers only)     

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        String str1, str2, str3;
        double a, b, c;
        String op;

        do {
            System.out.print("> ");
            str1 = keyboard.next();
            str2 = keyboard.next();
            str3 = keyboard.next();            

            if (isNumeric(str1)) {
                a = Double.valueOf(str1);
                b = Double.valueOf(str3);
                op = str2;
                c = checkSimpleMathFunctions(a, op, b);
            } else {
                c = checkOtherMathFunctions(str1, str2);
            }
//			a  = keyboard.nextDouble();
//			op = keyboard.next();
//			b  = keyboard.nextDouble();

            System.out.println(c);

        } while (!str1.equals("0"));
    }

    public static double checkSimpleMathFunctions(double a, String op, double b) {
        double c;
        switch (op) {
            case "+":
                c = a + b;
                break;
            case "-":
                c = a - b;
                break;
            case "*":
                c = a * b;
                break;
            case "/":
                c = a / b;
                break;
            case "^":
                c = Math.pow(a, b);
                break;
            case "%":
                c = a % b;
                break;
            case "!":
                c = factorial(a);
                break;
            default:
                System.out.println("Undefined operator: '" + op + "'.");
                c = 0;
        }
        return c;
    }

    public static double checkOtherMathFunctions(String str1, String str2) {
        double result = 0;
        switch (str1) {
            case "sin":
                result = Math.sin(Double.valueOf(str2));
                break;
            case "cos":
                result = Math.cos(Double.valueOf(str2));
                break;
            case "tan":
                result = Math.tan(Double.valueOf(str2));
                break;
            case "sqrt":
                result = Math.sqrt(Double.valueOf(str2));
                break;
            case "log":
                result = Math.log(Double.valueOf(str2));
                break;
            case "log10":
                result = Math.log10(Double.valueOf(str2));
                break;
            case "ln":
                result = Math.log1p(Double.valueOf(str2));       
            case "-":
                result = Double.valueOf(str2) * -1;
                break;
            default:
                System.out.println("Undefined operation");
                result = 0;
        }
        return result;
    }

    public static double factorial(double a) {
        double result = 1;
        for (int i = 1; i <= a; i++) {
            result *= i;
        }
        return result;
    }

    public static boolean isNumeric(String s) {
        return (isDouble(s) || isInteger(s));
    }

    public static boolean isDouble(String s) {
        double n = 0;
        try {
            n = Double.valueOf(s);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    public static boolean isInteger(String s) {
        int n = 0;
        try {
            n = Integer.valueOf(s);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

}
