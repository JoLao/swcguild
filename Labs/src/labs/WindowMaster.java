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
public class WindowMaster {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc;
        sc = new Scanner(System.in);

        
        //glass $3.50/sq foot
        //frame $2.25/ft
        double glassUnitCost = (3.5/12);
        double woodUnitCost = (2.25/12);
        
        double height;
        double width;
        double frameWidth;
        
        double totalCost;
        double area;
        double perimeter;
        
        String stringHeight = "";
        String stringWidth = "";
        String stringFrameWidth = "";
        
        final double MIN = 6;
        final double MAX = (12*25);
    
        // prompt for height
        System.out.println("Enter window height in inches:");
        stringHeight = sc.nextLine();
        height = Double.parseDouble(stringHeight);
        
        // check height
        while ((height<MIN)||(MAX<height)) {
            System.out.println("Your window be between "+MIN+" inches and "+MAX+" inches tall, Please enter window height within these parameters. ");
            stringHeight = sc.nextLine();
            height = Double.parseDouble(stringHeight);
         }
        
        // prompt for width
        System.out.println("Enter window width in inches:");
        stringWidth = sc.nextLine();
        width = Double.parseDouble(stringWidth);
        
        // check width
        while ((width<MIN)||(MAX<width)) {
            System.out.println("Your window be between "+MIN+" inches and "+MAX+" inches wide, Please enter window width within these parameters. ");
            stringWidth = sc.nextLine();
            width = Double.parseDouble(stringWidth);
         }
        
        System.out.println("Enter frame width in inches:");
        stringFrameWidth = sc.nextLine();
        frameWidth = Double.parseDouble(stringFrameWidth);
        
        // calculate area and perimeter
        area = height*width;
        perimeter = 2*height + 2*width;
        
        // calculate total cost
        totalCost = glassUnitCost*area + perimeter*woodUnitCost
                + 8*frameWidth*woodUnitCost;
        
        // print total cost
        System.out.println("Final Cost is $" +totalCost+".");
        
        
    
    }
 
}
