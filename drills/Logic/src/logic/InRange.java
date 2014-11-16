/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;
//Given a number n, return true if n is in the range 1..10, inclusive. 
//Unless "outsideMode" is true, in which case return true 
//if the number is less or equal to 1, or greater or equal to 10. 
//
//InRange(5, false) → true
//InRange(11, false) → false
//InRange(11, true) → true

public class InRange {
    public boolean inRange(int a, boolean outsideMode) {
        if (outsideMode) {
            if (a <= 1 || a >= 10) {
                return true;
            } else {
                return false;
            }
        } else if (a >= 1 && a <= 10) {
            return true;
        }
        return false;
    }
}
