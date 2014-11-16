/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProgrammingbyDoing.KeyboardInput;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class BMICalculator {
    public static void main(String[] args) {
        Scanner keybd = new Scanner(System.in);
        
        System.out.println("Your height : ");
        System.out.print("         Feet : ");
        int height1 = keybd.nextInt();
        
        float height3 = (float) height1 * 12f * 0.0254f;
        
        System.out.print("       Inches : ");
        int height2 = keybd.nextInt();
        float height4 = (float) height2 * 0.0254f;
        
        float height = height3 + height4;
        
        System.out.print("Your weight in lbs: ");
        int wt = keybd.nextInt();
        float weight = (float) wt * 0.453592f;
         
        float bmi = 0;
        bmi = (float) weight / (height * height);
        
        System.out.println("Your BMI is "+bmi);
    }
    
}
