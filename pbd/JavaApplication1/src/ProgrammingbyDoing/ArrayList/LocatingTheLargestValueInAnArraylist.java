/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProgrammingbyDoing.ArrayList;
//Write a program that creates an ArrayList of Integers. Fill the ArrayList with random numbers from 1 to 100. 
//Display the values in the ArrayList on the screen. Then use a linear search to find the largest value in the 

import java.util.ArrayList;
import java.util.Random;

//ArrayList, and display that value and its slot number.
public class LocatingTheLargestValueInAnArraylist {
    public static void main(String[] args) {
        ArrayList<Integer> arrInt = new ArrayList<>();
        Random rGen = new Random();
        int largest = 0;
        int slot    = 0;
        for (int i = 0; i < 10; i++) {
            arrInt.add(rGen.nextInt(100)+1);
        }
        
        System.out.println("ArrayList: "+arrInt);
        System.out.println("");
        
        for (int i = 0; i < arrInt.size(); i++) {
            if (arrInt.get(i) > largest) {
                largest = arrInt.get(i);
                slot    = i;
            }
        }
        System.out.println("The largest value is "+largest+" which is in slot "+slot);
    }
    
}
