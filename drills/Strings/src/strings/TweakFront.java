/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strings;

//Given a string, return a version without the first 2 chars. Except keep the 
//first char if it is 'a' and keep the second char if it is 'b'. The string 
//may be any length.
//
//TweakFront("Hello") -> "llo"
//TweakFront("away") -> "aay"
//TweakFront("abed") -> "abed"
public class TweakFront {

    public String tweakFront(String str) {
        String result = "";
        
        if (str.length() > 0) {
            if (str.charAt(0) == 'a') {
                result = "a";
                if (str.charAt(1) == 'b') {
                    result += "b";
                }
            } 
            result += str.substring(2);            
        }
        return result;
    }
}
