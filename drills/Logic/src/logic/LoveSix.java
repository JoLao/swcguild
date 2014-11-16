/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

//The number 6 is a truly great number. Given two int values, a and b, 
//return true if either one is 6. Or if their sum or difference is 6.
//
//LoveSix(6, 4) → true
//LoveSix(4, 5) → false
//LoveSix(1, 5) → true
public class LoveSix {
    
    public boolean loveSix(int a, int b) {
        if (a == 6 || b == 6 || (a+b) == 6 || Math.abs(a-b) == 6) {
            return true;
        } 
        return false;
    }
}
