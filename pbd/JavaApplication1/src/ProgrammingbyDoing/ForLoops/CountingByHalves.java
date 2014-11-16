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
public class CountingByHalves {
    public static void main(String[] args) {
        //Write a program that uses a for loop. With the loop, make the variable x go from -10 to 10, 
        //counting by 0.5. (This means that x can't be an int.)
        for (double n = -10; n <= 10; n = n + 0.5)
        {
            System.out.println( n);
        }
    }
    
}
