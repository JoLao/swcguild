/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strings;

//Given a String, return true if it ends in "ly". 
//
//EndsWithLy("oddly") -> true
//EndsWithLy("y") -> false
//EndsWithLy("oddy") -> false
public class EndsWithLy {

    public boolean endsWithLy(String str) {
        if (str.length() > 1 && str.substring(str.length()-2, str.length()).equals("ly")) {
            return true;
        }
        return false;
    }
}
