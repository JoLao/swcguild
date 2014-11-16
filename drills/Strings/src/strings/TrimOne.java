/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strings;

//Given a String, return a version without the first and last char, so "Hello" 
//yields "ell". The String length will be at least 2. 
//
//TrimOne("Hello") -> "ell"
//TrimOne("java") -> "av"
//TrimOne("coding") -> "odin"
public class TrimOne {

    public String TrimOne(String str) {
        return str.substring(1, str.length()-1);
    }
}
