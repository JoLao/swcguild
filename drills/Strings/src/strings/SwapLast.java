/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strings;

//Given a string of any length, return a new string where the last 2 chars, 
//if present, are swapped, so "coding" yields "codign". 
//
//SwapLast("coding") -> "codign"
//SwapLast("cat") -> "cta"
//SwapLast("ab") -> "ba"
public class SwapLast {

    public String SwapLast(String str) {
        int len = str.length() - 2;
        
        if (str.length() > 2) {            
            return str.substring(0, len) + 
                   str.substring(str.length() -1 , str.length()) +
                   str.substring(len, len+1);
        } else if (str.length() == 2) {
            return Character.toString(str.charAt(1)) + str.charAt(0);
        }
        return str;
    }
}
