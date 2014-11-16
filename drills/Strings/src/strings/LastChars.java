/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strings;

//Given 2 strings, a and b, return a new string made of the first char of a and the 
//last char of b, so "yo" and "java" yields "ya". If either string is length 0, 
//use '@' for its missing char. 
//
//LastChars("last", "chars") -> "ls"
//LastChars("yo", "mama") -> "ya"
//LastChars("hi", "") -> "h@"
public class LastChars {

    public String lastChars(String a, String b) {
        String result = "";
        
        if (a.length() == 0) {
            result = "@";
        } else {
            result = a.substring(0, 1);
        }
        
        if (b.length() == 0) {
            result += "@";
        } else {
            result += b.substring(b.length() - 1, b.length());
        }
        return result;
    }
}
