/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package strings;

//Given a string, return a "rotated right 2" version where the last 2 chars are 
//moved to the start. The string length will be at least 2. 
//
//RotateRight2("Hello") -> "loHel"
//RotateRight2("java") -> "vaja"
//RotateRight2("Hi") -> "Hi"
public class RotateRight2 {
    public String rotateRight2(String str) {

        return str.substring(str.length() - 2, str.length())+str.substring(0, str.length() - 2);
    }
}
