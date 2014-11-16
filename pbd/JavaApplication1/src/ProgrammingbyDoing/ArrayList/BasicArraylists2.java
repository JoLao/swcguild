
package ProgrammingbyDoing.ArrayList;

import java.util.ArrayList;


//Create an ArrayList of Integers. Fill up the list with ten random numbers, each from 1 to 100. 
//Then display the contents of the ArrayList on the screen.
//
//You must use a loop to fill up the list. However, you may display it the easy way (no loop needed) like so:
//
//System.out.println( "ArrayList: " + whateverYourArrayListVariableIsCalled );

public class BasicArraylists2 {
     public static void main(String[] args) {
         ArrayList<Integer> arrInt = new ArrayList<>();
         
         for (int i = 1; i <= 100; i++) {
             arrInt.add(i);
         }
         
         System.out.println("ArrayList "+arrInt);
     }
}
