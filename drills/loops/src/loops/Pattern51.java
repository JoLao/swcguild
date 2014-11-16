/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loops;

//Given an array of ints, return true if it contains a 2, 7, 1 pattern -- a value, 
//followed by the value plus 5, followed by the value minus 1.
//
//Pattern51({1, 2, 7, 1}) -> true
//Pattern51({1, 2, 8, 1}) -> false
//Pattern51({2, 7, 1}) -> true
public class Pattern51 {

    public boolean pattern51(int[] numbers) {
        for (int i = 2; i < numbers.length; i++) {
            if (numbers[i] == (numbers[i-2]-1) &&
                numbers[i-1] == (numbers[i-2]+5)) {
                return true;
            }
        }
        return false;
    }
}
