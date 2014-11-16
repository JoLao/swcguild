/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conditionals;

//Given 2 int values, return whichever value is nearest to the value 10, or 
//return 0 in the event of a tie. 
//
//Closer(8, 13) -> 8
//Closer(13, 8) -> 8
//Closer(13, 7) -> 0

public class Closer {
public int closer(int a, int b) {
    
    if (Math.abs(a - 10) < Math.abs(b - 10)) {
        return a;
    }
    if (Math.abs(a - 10) != Math.abs(b - 10)) {
        return b;
    }
    return 0;
}
    
}
