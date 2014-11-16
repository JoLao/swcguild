/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strings;

//Given a string, return true if the first 2 chars in the string also appear at
//the end of the string, such as with "edited". 
//
//FrontAgain("edited") -> true
//FrontAgain("edit") -> false
//FrontAgain("ed") -> true
public class FrontAgain {

    public boolean frontAgain(String str) {
        if (str.length() == 2) {
            return true;
        } else {
            if (str.substring(0, 2).equals(str.substring(str.length() - 2 , str.length()))) {
                return true;
            }
        }
        return false;
    }
}
