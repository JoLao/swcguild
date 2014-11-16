/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strings;

//Given a String, return a "rotated left 2" version where the first 2 chars are 
//moved to the end. The String length will be at least 2. 
//
//Rotateleft2("Hello") -> "lloHe"
//Rotateleft2("java") -> "vaja"
//Rotateleft2("Hi") -> "Hi"
public class Rotateleft2 {

    public String rotateleft2(String str) {
        
        return str.substring(2, str.length())+str.substring(0, 2);
    }
}
