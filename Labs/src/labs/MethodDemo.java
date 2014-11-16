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
public class MethodDemo {

    public static void main(String[] args) {
        sayHi();
        int sum = add1And1();
        System.out.println(sum);
        System.out.println(add1And1());
        printMessage("Hello, Akron");

        String myMessage = "Hello, Ohio";
        printMessage(myMessage);

        sum = add(3, 5);
        System.out.println(sum);
        int num1 = 10, num2 = 12;
        sum = add(num1, num2);
        System.out.println(sum);

        double num = promptUser("Please enter window height between 1 and 10 ",1,10);
        System.out.println("You entered "+num);
    }

    public static void sayHi() {
        System.out.println("Hi");
    }

    public static int add1And1() {
        return 1 + 1;
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static int add(int a, int b) {
        return a + b;
    }
    
    public static String promptUser(String msg) {
        System.out.println(msg);
        Scanner keybd = new Scanner(System.in);
        return keybd.nextLine();
    }
    
    public static double promptUser(String msg, double min, double max) {        
        Scanner keybd = new Scanner(System.in);
        double input;
        
        do {
            System.out.println(msg);
            input = Double.parseDouble(keybd.nextLine()); //keybd.nextDouble();
        } while (input < min || input > max);
        
        return input;
    }
    
    public static void scopeMethod()  {
        int a = 11;
        
        if (a > 5) {
            System.out.println(a);
            int b = 43;
        }
  
    }
}
