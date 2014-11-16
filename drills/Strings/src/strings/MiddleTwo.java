/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strings;

//Given a String of even length, return a String made of the middle two chars, 
//so the String "String" yields "ri". The String length will be at least 2. 
//
//MiddleTwo("String") -> "ri"
//MiddleTwo("code") -> "od"
//MiddleTwo("Practice") -> "ct"
public class MiddleTwo {

    public String MiddleTwo(String str) {
        return str.substring( (str.length()/2)-1 , (str.length()/2));
    }
}
