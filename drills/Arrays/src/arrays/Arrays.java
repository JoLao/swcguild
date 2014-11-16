/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arrays;


public class Arrays {

    public static void main(String[] args) {
        MakePi test1 = new MakePi();
        
        int[] digits = test1.makePi(4);
        System.out.println(digits[0]+" "+ digits[1]+" "+digits[2]+" "+digits[3]);
        
        Reverse test2 = new Reverse();
        int[] a = {1, 2, 3, 4};        
        int[] b = test2.reverse(a);
        System.out.println(b[0]+" "+b[1]+" "+b[2]+" "+b[3]);
        
        HigherWins test = new HigherWins();
        int[] c = {2, 11, 3};
        b = test.higherWins(c);
        System.out.println(b[0]+" "+b[1]+" "+b[2]);
        
    }

}
