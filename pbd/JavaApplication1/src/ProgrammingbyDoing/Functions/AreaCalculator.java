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
public class AreaCalculator {
//Write a program to calculate the area of four different geometric shapes: triangles, squares, 
//rectangles, and circles. You must use functions. Here are the functions you should create:  
//Your program should present a menu for the human to choose which shape to calculate, then ask 
//them for the appropriate values (length, width, radius, etc.). Then it should pass those values 
//to the appropriate function and display the resulting area.
//
//Notice that you must not input the values inside the functions, and you must not display the values inside the functions. All input and output must be in the main(), and values must be passed to the functions and returned from them.public static double area_circle( int radius ) {             // returns the area of a circle

    public static void main(String[] args) {
        int choice = 1;
        int[] sides;
        int r;
        int s;

        displayMenu();
        while (choice >= 1 && choice < 5) {
            System.out.print("Which shape: ");

            Scanner keybd = new Scanner(System.in);
            choice = keybd.nextInt();

            switch (choice) {
                case 1:
                    sides = getTriangleSides(keybd);
                    System.out.println("The area is " + area_triangle(sides[0], sides[1]));
                    break;
                case 2:
                    sides = getRectangleSides(keybd);
                    System.out.println("The area is " + area_rectangle(sides[0], sides[1]));
                    break;
                case 3:
                    s = getSquareSide(keybd);
                    System.out.println("The area is " + area_square(s));
                    break;
                case 4:
                    r = getRadius(keybd);
                    System.out.println("The area is " + area_circle(r));
                    break;
            }
            displayMenu();
        }

    }

    public static void displayMenu() {
        System.out.println("Shape Area Calculator version 0.1 (c) 2005 Mitchell Sample Output, Inc.");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("1) Triangle");
        System.out.println("2) Rectangle");
        System.out.println("3) Square");
        System.out.println("4) Circle");
        System.out.println("5) Quit");
    }

    public static int getRadius(Scanner keybd) {
        int r = 0;

        while (r < 1) {
            System.out.print("Radius: ");
            r = keybd.nextInt();
            if (r < 1) {
                System.out.println("Invalid radius.");
            }
        }

        return r;

    }

    public static int[] getRectangleSides(Scanner keybd) {
        int[] sides = new int[2];
        
        while (sides[0] < 1) {
            System.out.print("Length: ");
            sides[0] = keybd.nextInt();
            if (sides[0] < 1) {
                System.out.println("Invalid value");
            }
        }

        while (sides[1] < 1) {
            System.out.print("Width: ");
            sides[1] = keybd.nextInt();
            if (sides[1] < 1) {
                System.out.println("Invalid value");
            }
        }

        return sides;

    }

    public static int getSquareSide(Scanner keybd) {
        int s = 0;

        while (s < 1) {
            System.out.print("Side: ");
            s = keybd.nextInt();
            if (s < 1) {
                System.out.println("Invalid value");
            }
        }

        return s;

    }

    public static int[] getTriangleSides(Scanner keybd) {
        int[] sides = new int[2];
        System.out.print("Base: ");
        sides[0] = keybd.nextInt();

        System.out.print("Height: ");
        sides[1] = keybd.nextInt();

        return sides;

    }

    public static double area_circle(int radius) { // returns the area of a circle   

        return Math.PI * Math.pow(radius, 2);
    }

    public static int area_rectangle(int length, int width) { // returns the area of a rectangle
        return length * width;
    }

    public static double area_square(int side) {                  // returns the area of a square
        return Math.pow(side, 2);
    }

    public static double area_triangle(int base, int height) { // returns the area of a triangle
        return (base * height) / 2.0;
    }
}
