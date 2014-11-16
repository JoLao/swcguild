/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conditionals;

//Given a non-empty string and an int N, return the string made starting with char 0, 
//and then every Nth char of the string. So if N is 3, use char 0, 3, 6, ... and so on. 
//N is 1 or more. 
//
//EveryNth("Miracle", 2) -> "Mrce"
//EveryNth("abcdefg", 2) -> "aceg"
//EveryNth("abcdefg", 3) -> "adg"
public class EveryNth {

    public String everyNth(String str, int n) {
        String result = "";

        for (int i = 0; i < str.length(); i += n) {
            result += str.charAt(i);
        }
        return result;
    }

}
