/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProgrammingbyDoing.ForLoops;

/**
 *
 * @author apprentice
 */
public class XsAndYs {
    public static void main(String[] args) {
        //Write another program that uses a for loop. With the loop, 
        //make the variable x go from -10 to 10, counting by 0.5. (This means that x can't be an int.)
        //Inside the body of the loop, make another variable y become the current value of x squared. 
        //Then display the current values of both x and y.
        //To get your output to line up like mine, use a tab.
        double y = 0;
        System.out.println(" x      y");
        System.out.println("-----------------");
        
        for (double n = -10; n <= 10; n = n + 0.5)
        {
            y = n * n;
            System.out.println(n+"  "+y);
        }
    }
    
}
