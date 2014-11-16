package com.swcguild.flooringmasteryspring.ui;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class ConsoleIO {
    private Scanner read = new Scanner(System.in);
        
     public int integerPrompt(String prompt) {
        int input = 0;
        boolean valid = false;
        do {
            try {
                System.out.println(prompt);
                input = Integer.parseInt(read.nextLine());
                valid = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Must input an integer. Please try again.");
            }
        } while (!valid);
        return input;
    }

    public int intMinMax(String message, int min, int max) {
        int input = 0;
        boolean valid = false;
        do {

            input = integerPrompt(message);
            if (input >= min && input <= max) {
                valid = true;
            } else {
                System.out.println("Input out of range. Must be between " + min + " and " + max + ".");
            }
        } while (!valid);
        return input;

    }

    public String promptString(String prompt) {
        System.out.println(prompt);
        return read.nextLine();
    }

    public String promptStringNotNull(String prompt){
        String input;
        do{
        System.out.println(prompt);
            input=read.nextLine();
            if(!input.equals("")){
                return input;
            }
            else{
                System.out.println("Invalid input! Must enter text!");
            }
        }while(true);
    }
    
    public float promptFloat(String prompt){
        float input = 0;
        boolean valid = false;
        do {
            try {
                System.out.println(prompt);
                input = Float.parseFloat(read.nextLine());
                valid = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Must input a number. Please try again.");
            }
        } while (!valid);
        return input;
    }
    
    public float promptByte(String prompt){
        byte input = 0;
        boolean valid = false;
        do {
            try {
                System.out.println(prompt);
                input = Byte.parseByte(read.nextLine(), 1);
                valid = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Must input a number. Please try again.");
            }
        } while (!valid);
        return input;
    }
    
    public float floatMinMax(String prompt, float min, float max){
        float input = 0;
        boolean valid = false;
        do{
            input = integerPrompt(prompt);
            if(input>=min && input<=max){
                valid = true;
            }
            else{
                System.out.println("Input out of range. Must be between " + min + " and " + max + ".");
            }
        }while(!valid);
        return input;
    }

    public double promptDouble(String prompt){
        double input = 0;
        boolean valid = false;
        do {
            try {
                System.out.println(prompt);
                input = Double.parseDouble(read.nextLine());
                valid = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Must input a number. Please try again.");
            }
        } while (!valid);
        return input;
    }
    
    public double doubleMinMax(String prompt, double min, double max){
        double input = 0;
        boolean valid = false;
        do{
            input = integerPrompt(prompt);
            if(input>=min && input<=max){
                valid = true;
            }
            else{
                System.out.println("Input out of range. Must be between " + min + " and " + max + ".");
            }
        }while(!valid);
        return input;
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
