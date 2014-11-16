/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conditionals;

//We'll say that a number is "teen" if it is in the range 13..19 inclusive. 
//Given 2 int values, return true if one or the other is teen, but not both. 
//
//SoAlone(13, 99) -> true
//SoAlone(21, 19) -> true
//SoAlone(13, 13) -> false
public class SoAlone {

    public boolean soAlone(int a, int b) {
        boolean result = false;
        
        if (a > 12 && a < 20) {
            if (b > 12 && b < 20) {
                result = false;
            } else {
                result = true;
            }
        } else if (b > 12 && b < 20) {
                result = true;
        }
        return result;
    }
}
