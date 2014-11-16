/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strings;

//Given a string, return true if "bad" appears starting at index 0 or 1 in the string, 
//such as with "badxxx" or "xbadxx" but not "xxbadxx". The string may be any length, including 0.
//
//HasBad("badxx") -> true
//HasBad("xbadxx") -> true
//HasBad("xxbadxx") -> false
public class HasBad {

    public boolean HasBad(String str) {
        if (str.length() <= 2) {
            return false;
        }
        if (str.substring(0, 3).equals("bad") || str.substring(1, 4).equals("bad")) {
            return true;
        }
        return false;
    }
}
