/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loops;

//Given an array of ints, we'll say that a triple is a value appearing 3 times in 
//a row in the array. Return true if the array does not contain any triples. 
//
//NoTriples({1, 1, 2, 2, 1}) -> true
//NoTriples({1, 1, 2, 2, 2, 1}) -> false
//NoTriples({1, 1, 1, 2, 2, 2, 1}) -> false
public class NoTriples {

    public boolean noTriples(int[] numbers) {

        int times = 1;

        for (int i = 2; i < numbers.length; i++) {

            if (numbers[i-2] == numbers[i-1] && numbers[i-1] == numbers[i]) {
             
                return false;
            }
        }
        return true;
    }
}
