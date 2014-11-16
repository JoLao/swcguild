
package simplecalculator;

import java.util.Scanner;


public class Calculator {

    private    double a, b, c;
    private    String op;



    public double doSimpleMathFunctions(double a, String op, double b) {
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

    public double doOtherMathFunctions(String str1, String str2) {
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
