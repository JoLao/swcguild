

package ProgrammingbyDoing.ArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
//Create an ArrayList that can hold Integers, and fill each slot with a different random value from 1-50. 
//Display those values on the screen, and then prompt the user for an integer. Search through the ArrayList, 
//and if the item is present, say so. It is not necessary to display anything if the value was not found. 
//If the item is in the ArrayList multiple times, it's okay if the program prints the message more than once.
public class FindingAValueInAnArraylist {
  public static void main(String[] args) {
      ArrayList<Integer> arrInt = new ArrayList<>();
      Scanner keybd = new Scanner(System.in);
      
      Random rGen = new Random();
      for (int i = 0; i < 10; i++)
          arrInt.add(rGen.nextInt(50)+1);
      
      System.out.println("ArrayList: "+arrInt);

      System.out.print("Value to find: ");
      int num = keybd.nextInt();
      
      Iterator<Integer> iter = arrInt.iterator();
      while (iter.hasNext()) {
          if (iter.next() == num) {
              System.out.println(num+" is in the ArrayList.");
          }
      }
  }  
}
