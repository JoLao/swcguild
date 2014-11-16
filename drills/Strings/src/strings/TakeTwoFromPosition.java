/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strings;

//Given a string and an index, return a string length 2 starting at the given index. 
//If the index is too big or too small to define a string length 2, use the first 2 chars. 
//The string length will be at least 2. 
//
//TakeTwoFromPosition("java", 0) -> "ja"
//TakeTwoFromPosition("java", 2) -> "va"
//TakeTwoFromPosition("java", 3) -> "ja"
public class TakeTwoFromPosition {

    public String takeTwoFromPosition(String str, int n) {
        if (n  > str.length()- 2) {
            return str.substring(0, 2);
        }
        return str.substring(n, n + 2);
    }
}
