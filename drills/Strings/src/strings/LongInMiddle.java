/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strings;

//Given 2 Strings, a and b, return a String of the form short+long+short, with 
//the shorter String on the outside and the longer String on the inside. The 
//Strings will not be the same length, but they may be empty (length 0). 
//
//LongInMiddle("Hello", "hi") -> "hiHellohi"
//LongInMiddle("hi", "Hello") -> "hiHellohi"
//LongInMiddle("aaa", "b") -> "baaab"
public class LongInMiddle {

    public String longInMiddle(String a, String b) {
        String result = "";
        
        if (a.length() > b.length()) {
            result = b+a+b;
        } else {
            result = a+b+a;
        }
        return result;
    }
}
