

package ProgrammingbyDoing.ArrayList;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


//Create an ArrayList of Integers, and fill each slot with a different random value from 1-50. 
//Display those values on the screen, and then prompt the user for an integer. Search through
//the ArrayList, and if the item is present, say so. If the value is not in the ArrayList, 
//display a single message saying so. Just like the previous assignment, if the value is present 
//more than once, you may display the message as many times as necessary.

public class ArraylistThereOrNot {
      public static void main(String[] args) {
          ArrayList<Integer> arrInt = new ArrayList<>();
          Scanner keybd = new Scanner(System.in);
          Random rGen = new Random();
          
          for (int i = 0; i < 10; i++) {
              arrInt.add(rGen.nextInt(50)+1);
          }
          
          System.out.println("ArrayList: "+arrInt);
          System.out.print("Value to find: ");
          int num = keybd.nextInt();
          boolean isFound = false;
          for (Integer i : arrInt) {
              if (i == num) {
                  System.out.println(num+" is in the ArrayList.");
                  isFound = true;
              }
          }
          if (!isFound) {
              System.out.println(num+" is not in the ArrayList.");
          }
          
      }
}
