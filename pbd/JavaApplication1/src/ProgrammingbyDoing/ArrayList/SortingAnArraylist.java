

package ProgrammingbyDoing.ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


//Write a program that creates an ArrayList of Integers. Fill the ArrayList with random numbers from 10 to 99. 
//Display the values in the ArrayList on the screen. Then using the sort of your choice, arrange the values
//from largest to smallest and display them again.
//
//You must put the sorting code in its own function.
public class SortingAnArraylist {
     public static void main(String[] args) {
         ArrayList<Integer> arrInt = new ArrayList<>();
         Random rGen = new Random();
         
         for (int i = 0; i < 10; i++) {
             arrInt.add(rGen.nextInt(90)+10);
         }
         System.out.println("ArrayList before: "+arrInt);
         Collections.sort(arrInt);
         System.out.println("ArrayList  after: "+arrInt);
     }
    
}
