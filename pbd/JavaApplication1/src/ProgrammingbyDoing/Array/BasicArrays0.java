/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProgrammingbyDoing;

import java.util.Random;

/**
 *
 * @author apprentice
 */
public class BasicArrays0 {
    public static void main(String[] args) {
        //Create an array that can hold ten integers. Fill up each slot of the array with the number -113. 
        //Then display the contents of the array on the screen.
        int[] slots = new int[10];
        
        slots[0] = -113;
        slots[1] = -113;
        slots[2] = -113;
        slots[3] = -113;
        slots[4] = -113;
        slots[5] = -113;
        slots[6] = -113;
        slots[7] = -113;
        slots[8] = -113;
        slots[9] = -113;
        
        System.out.println("Slot 0 contains a "+ slots[0]);
        System.out.println("Slot 1 contains a "+ slots[1]);
        System.out.println("Slot 2 contains a "+ slots[2]);
        System.out.println("Slot 3 contains a "+ slots[3]);
        System.out.println("Slot 4 contains a "+ slots[4]);
        System.out.println("Slot 5 contains a "+ slots[5]);
        System.out.println("Slot 6 contains a "+ slots[6]);
        System.out.println("Slot 7 contains a "+ slots[7]);
        System.out.println("Slot 8 contains a "+ slots[8]);
        System.out.println("Slot 9 contains a "+ slots[9]);
        
        System.out.println("--- Using For Loop ---");
        Random rGen = new Random();
        int num = 0;
        
        for (int i = 0; i < slots.length; i++) {
            num = rGen.nextInt(100) + 1;
            slots[i] = num;
            System.out.println("Slot "+i+" contains a "+slots[i]);
        }
    }
    
}
