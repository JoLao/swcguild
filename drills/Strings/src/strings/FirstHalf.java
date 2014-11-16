/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strings;

//Given a String of even length, return the first half. So the String "WooHoo" yields "Woo". 
//
//FirstHalf("WooHoo") -> "Woo"
//FirstHalf("HelloThere") -> "Hello"
//FirstHalf("abcdef") -> "abc"
public class FirstHalf {

    public String firstHalf(String str) {
        return str.substring(0, str.length() / 2);
    }
}
