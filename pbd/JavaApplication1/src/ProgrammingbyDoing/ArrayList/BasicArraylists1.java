/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProgrammingbyDoing.ArrayList;

import java.util.ArrayList;

//Create an ArrayList that can hold Integers. Add ten copies of the number -113 to the ArrayList. 
//Then display the contents of the ArrayList on the screen.
//
//This time, you must use a loop, both to fill up the ArrayList and to display it.Also, in the 
//condition of your loop, you should not count up to a literal number. Instead you should use 
//the size() of your ArrayList.
public class BasicArraylists1 {
    public static void main(String[] args) {
        ArrayList<Integer> arrInt = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            arrInt.add(-113);
        }
        
        for (int i = 0; i < arrInt.size(); i ++) {
            System.out.println("Slot "+i+" contains a "+arrInt.get(i));
        }
    }
    
}
