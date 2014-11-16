/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgrammingbyDoing.Array;

/**
 *
 * @author apprentice
 */
public class GivingAnArrayABunchOfValuesAtOnce {

    public static void main(String[] args) {
        String[] arr1 = {"alpha", "bravo", "charlie", "delta", "echo"};
        int[]    arr2 = {8, 4, 7, 10, 20};

        System.out.print("The first array is filled with the following values:\n\t");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        
        System.out.println("The second array is filled with the following values:\t");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();        
    }

}
