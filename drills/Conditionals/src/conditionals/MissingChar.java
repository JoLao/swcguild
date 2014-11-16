/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conditionals;

//Given a non-empty string and an int n, return a new string where the char at 
//index n has been removed. The value of n will be a valid index of a char in 
//the original string (Don't check for bad index). 
//
//MissingChar("kitten", 1) -> "ktten"
//MissingChar("kitten", 0) -> "itten"
//MissingChar("kitten", 4) -> "kittn"
public class MissingChar {

    public String missingChar(String str, int n) {
        
        return str.substring(0, n)+str.substring(n+1);
    }
}
