/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProgrammingbyDoing.ArrayList;

//Write a program that creates an ArrayList of Strings. Make up ten or more random words (all lowercase) 

import java.util.ArrayList;
import java.util.Collections;

//and put them in the ArrayList in any way you choose. Display them on the screen. Then, using the sort 
//of your choice, arrange the words in alphabetical order and display them again.
//
//Just like last time, you must put the sorting code in its own function.
public class SortingAnArraylistOfStrings {
    
    public static void main(String[] args) {
        ArrayList<String> arrStr = new ArrayList<>();
        arrStr.add("ask");
        arrStr.add("not");
        arrStr.add("what");
        arrStr.add("your");
        arrStr.add("country");
        arrStr.add("can");
        arrStr.add("do");
        arrStr.add("for");
        arrStr.add("you");
        arrStr.add("but");
        System.out.println("ArrayList before: "+arrStr);
        Collections.sort(arrStr);
        System.out.println("ArrayList  after: "+arrStr);
        
    }
    
}
