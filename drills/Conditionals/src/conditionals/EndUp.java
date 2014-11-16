/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conditionals;

//Given a string, return a new string where the last 3 chars are now in upper case. 
//If the string has less than 3 chars, uppercase whatever is there. 
//
//EndUp("Hello") -> "HeLLO"
//EndUp("hi there") -> "hi thERE"
//EndUp("hi") -> "HI"
public class EndUp {

    public String endUp(String str) {
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            if (i < (str.length() - 3)) {
                result += str.charAt(i);
            } else {
                result += Character.toUpperCase(str.charAt(i));
            }

        }
        return result;
    }
}
