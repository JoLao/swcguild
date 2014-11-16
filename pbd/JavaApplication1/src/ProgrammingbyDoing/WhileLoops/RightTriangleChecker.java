/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProgrammingbyDoing.WhileLoops;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class RightTriangleChecker {
    public static void main(String[] args) {
        Scanner keybd = new Scanner(System.in);
        
        int s1 = 0, s2 = 0, s3 = 0;
        boolean correctSW = false;
        
        while (!correctSW) {
            System.out.println("Enter three integers: ");
        
            System.out.print("Side 1: ");
            s1 = keybd.nextInt();
            System.out.print("Side 2: ");
            s2 = keybd.nextInt();
            System.out.print("Side 3: ");
            s3 = keybd.nextInt();
            
            if (s1 < s2) {
                if (s2 < s3) {
                    correctSW = true;
                } else {
                    System.out.println(s3 + " is smaller than "+s2);
                }
            } else if (s1 > s2) {
                System.out.println(s2+" is smaller than "+s1 );
            } else if (s1 > s3) {
                System.out.println(s3+" is smaller than "+s1);
            } else correctSW = true;
        }
        
        System.out.println("Your three sides are "+s1+", "+s2+", "+s3);
        double rightTriangle = Math.sqrt((s1*s1 + s2*s2));
        
        if (s3 == rightTriangle) {
            System.out.println("These sides *do* make a right triangle.  Yippy-skippy!");
        } else {
            System.out.println("NO!  These sides do not make a right triangle!");
        }
        
    }
    
}
