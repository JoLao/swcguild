/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strings;

//Given a string and an int n, return a string made of the first and last n chars from the string. 
//The string length will be at least n. 
//
//FrontAndBack("Hello", 2) -> "Helo"
//FrontAndBack("Chocolate", 3) -> "Choate"
//FrontAndBack("Chocolate", 1) -> "Ce"
public class FrontAndBack {

    public String frontAndBack(String str, int n) {
        return str.substring(0, n)+str.subSequence(str.length()-n, str.length());
    }
}
