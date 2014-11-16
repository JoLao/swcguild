package labs;

import java.util.Scanner;

public class ConsoleIO {
//Design a class (no main method) that has methods to ask for and retrieve keyboard input 
//from the user and to print information out to the console.  You must have methods that 
//do the following: 
// 
//1. Display a prompt to the user and read in an integer.  The prompt value should be passed 
//in as a parameter and the value that is read in should be the return value of the method. 
//2. Display a prompt to the user and read in an integer between max val and min val. The 
//prompt value, min, and max should be passed in as parameter.  The value read in from 
//the console should be the return value of the method.  This method must keep asking the 
//user for input until the value is in range. 
//3. Display a prompt to the user and read in a String. The prompt value should be passed in 
//as a parameter and the value that is read in should be the return value of the method. 
//4. Display a prompt to the user and read in a float. The prompt value should be passed in 
//as a parameter and the value that is read in should be the return value of the method. 
//5. Display a prompt to the user and read in a float between max val and min val. The prompt 
//value, min, and max should be passed in as parameter.  The value read in from the 
//console should be the return value of the method.  This method must keep asking the 
//user for input until the value is in range. 
//6. Display a prompt to the user and read in a double. 
//7. Display a prompt to the user and read in a double between max val and min val. The 
//prompt value, min, and max should be passed in as parameter.  The value read in from 
//the console should be the return value of the method.  This method must keep asking the 
//user for input until the value is in range.
//  
//8. Print a given String to the console. The prompt value should be passed in as a 
//parameter. 

    private Scanner keybd = new Scanner(System.in);

    public int promptForInteger(String message) {
        printString(message);
        String input = keybd.nextLine();
        int num = 0;
        if (isNumeric(input)) {
            num = Integer.parseInt(input);
        }
        return num;
    }

    public int promptForIntegerWithRange(String message, int min, int max) {
        printString(message);

        int num = 0;
        while (num <= min || num >= max) {
            num = keybd.nextInt();
        }
        return num;
    }

    public String promptForString(String message) {
        printString(message);
        return keybd.nextLine();
    }

    public float promptForFloat(String message) {
        printString(message);
        return keybd.nextFloat();
    }

    public float promptForFloatWithRange(String message, float min, float max) {
        printString(message);

        float num = 0;
        while (num <= min || num >= max) {
            num = keybd.nextFloat();
        }
        return num;
    }

    public double promptForDouble(String message) {
        printString(message);
        return keybd.nextDouble();
    }

    public double promptForDoubleWithRange(String message, double min, double max) {
        printString(message);

        double num = 0;
        while (num <= min || num >= max) {
            num = keybd.nextDouble();
        }
        return num;
    }

    public void printString(String message) {
        System.out.print(message);
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
