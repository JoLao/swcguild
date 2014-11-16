/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strings;

//Given a string, return a string length 2 made of its first 2 chars. If the string 
//length is less than 2, use '@' for the missing chars. 
//
//AtFirst("hello") -> "he"
//AtFirst("hi") -> "hi"
//AtFirst("h") -> "h@"
public class AtFirst {

    public String AtFirst(String str) {
     
        if (str.length() < 2) {
            return str.substring(0, str.length()) + "@";
        }
        return str.substring(0, 2);
    }
}
