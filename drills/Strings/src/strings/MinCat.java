/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strings;

//Given two strings, append them together (known as "concatenation") and return the result. 
//However, if the strings are different lengths, omit chars from the longer string so it is 
//the same length as the shorter string. So "Hello" and "Hi" yield "loHi". The strings may 
//be any length. 
//
//MinCat("Hello", "Hi") -> "loHi"
//MinCat("Hello", "java") -> "ellojava"
//MinCat("java", "Hello") -> "javaello"
public class MinCat {

    public String MinCat(String a, String b) {
        int sub = Math.abs(a.length() - b.length());
        if (a.length() == b.length()) {
            return a + b;
        } else if (a.length() > b.length()) {
            return a.substring(sub) + b;
        } else {
            return a + b.substring(sub);
        }
    }
}
