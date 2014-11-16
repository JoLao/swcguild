/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgrammingbyDoing.ArrayList;

//Create an ArrayList that can hold Integers, and fill each slot with a different random value from 1-50. 
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//Display those values on the screen, and then prompt the user for an integer. Search through the ArrayList, 
//and if the item is present, give the slot number where it is located. If the value is not in the ArrayList, 
//display a single message saying so. If the value is present more than once, you may either display the 
//message as many times as necessary, or display a single message giving the last slot number in which it 
//appeared.
public class ArraylistWhereIsIt {

    public static void main(String[] args) {
        ArrayList<Integer> arrInt = new ArrayList<>();
        Scanner keybd = new Scanner(System.in);
        Random rGen = new Random();
        for (int i = 0; i < 10; i++) {
            arrInt.add(rGen.nextInt(50) + 1);
        }

        System.out.println("ArrayList: " + arrInt);
        System.out.print("Value to find: ");
        int num = keybd.nextInt();
        boolean isFound = false;
        for (int i = 0; i < arrInt.size(); i++) {
            if (num == arrInt.get(i)) {
                System.out.println(num+" is in slot "+i);
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.println(num+" is not in the ArrayList.");
        }

    }
}
