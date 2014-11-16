/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conditionals;

//Return true if the given string contains between 1 and 3 'e' chars. 
//
//GotE("Hello") -> true
//GotE("Heelle") -> true
//GotE("Heelele") -> false


public class GotE {
    public boolean gotE(String str) {
        int result = 0;
        
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'e') {
                result++;
            }
        }
        if (result <= 3) {
            return true;
        }
        return false;
}
}
