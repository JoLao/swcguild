/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgrammingbyDoing.ArrayList;

//Write a program that creates an ArrayList which can hold Integers. Fill the ArrayList with 

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

//random numbers from 1 to 100. Display the values in the ArrayList on the screen. Then use 
//a linear search to find the largest value in the ArrayList, and display that value.
public class GettingTheLargestValueInAnArraylist {

    public static void main(String[] args) {
        ArrayList<Integer> arrInt = new ArrayList<>();
        
        Random rGen = new Random();
        int largest = 0;
        
        for (int i = 0; i < 10; i++) {
            arrInt.add(rGen.nextInt(100)+1);
        }
        System.out.println("ArrayList: "+arrInt);
        System.out.println("");
        Iterator<Integer> iter = arrInt.iterator();
        int num = 0;
        while (iter.hasNext()) {
            if ((num = iter.next()) > largest) {
                largest = num;
            }
        }
        System.out.println("The largest value is "+largest);
    }
}
