/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package unitoneskillcheck;

/**
 *
 * @author apprentice
 */
public class Adder {
    public static void main(String[] args) {
//Implement a static method called add that takes two integers as parameters and returns 
//an integer that is the sum of the two parameters.        
        System.out.println("1 and 1 "+add(1,1));
        System.out.println("2 and 3 "+add(2,3));
        System.out.println("5 and 8 "+add(5,8));
        System.out.println("95 and 42 "+add(95,42));
    }
    public static int add(int num1, int num2) {
        return num1 + num2;
    }
}
