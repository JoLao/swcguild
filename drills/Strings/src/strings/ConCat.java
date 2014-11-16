/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strings;

//Given two strings, append them together (known as "concatenation") and return 
//the result. However, if the concatenation creates a double-char, then omit one 
//of the chars, so "abc" and "cat" yields "abcat". 
//
//ConCat("abc", "cat") -> "abcat"
//ConCat("dog", "cat") -> "dogcat"
//ConCat("abc", "") -> "abc"
public class ConCat {

    public String conCat(String a, String b) {

        if (a.length() > 0 && b.length() > 0) {
            if (a.charAt(a.length() - 1) == b.charAt(0)) {
                return a.substring(0, a.length()) + b.substring(1, b.length());
            }
        }
        return a + b;
    }
}
