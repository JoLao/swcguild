/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgrammingbyDoing.ArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
//Write a program that creates an ArrayList of Integers. It should put ten random numbers from 1 to 100 
//in the ArrayList. It should copy all the elements of that ArrayList into another ArrayList of the same 
//size. Then display the contents of both ArrayLists in any way you like.
//
//    Create an ArrayList of Integers
//    Fill the ArrayList with ten random numbers (1-100)
//    Copy each value from the ArrayList into another ArrayList of the same capacity
//    Change the last value in the first ArrayList to a -7
//    Display the contents of both ArrayLists 

public class CopyingArraylists {

    public static void main(String[] args) {
        ArrayList<Integer> arrIntFrom = new ArrayList<>();
        ArrayList<Integer> arrIntTo = new ArrayList<>();

        Random rGen = new Random();
        int rInt = 0;

        for (int i = 0; i < 100; i++) {
            rInt = rGen.nextInt(100) + 1;
            arrIntFrom.add(rInt);
        }

        Iterator<Integer> iter = arrIntFrom.iterator();
        while (iter.hasNext()) {
            arrIntTo.add(iter.next());
        }

//        for (Integer i : arrIntFrom) {
//            arrIntTo.add(i);
//        }
//        
//        for (int i = 0; i < arrIntFrom.size(); i++) {
//            arrIntTo.add(arrIntFrom.get(i));
//        }
        arrIntFrom.set(99, -7);

        System.out.println("ArrayList From : "+arrIntFrom);
//        iter = arrIntFrom.iterator();
//        while (iter.hasNext()) {
//            System.out.print(iter.next() + ", ");
//        }

        System.out.println("");
        System.out.println("ArryList To :"+arrIntTo);
//        for (Integer i : arrIntTo) {
//            System.out.print(i+", ");
//        }
//        System.out.println("");
        
    }

}
