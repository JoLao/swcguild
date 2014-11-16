/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strings;

//Given a string, if the first or last chars are 'x', return the string without 
//those 'x' chars, and otherwise return the string unchanged. 
//
//StripX("xHix") -> "Hi"
//StripX("xHi") -> "Hi"
//StripX("Hxix") -> "Hxi"
public class StripX {

    public String stripX(String str) {
        int a = 0;
        int b = str.length();
        
        if (str.charAt(0) == 'x') {
            a = 1;
        }
        if (str.charAt(str.length() - 1) == 'x') {
            b = b - 1;
        }
        
        return str.substring(a, b);
    }
}
