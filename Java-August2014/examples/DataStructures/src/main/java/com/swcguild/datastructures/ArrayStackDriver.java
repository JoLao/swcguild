/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.datastructures;

/**
 *
 * @author apprentice
 */
public class ArrayStackDriver {
    
    public static void main (String [] args) {
        Stack st = new LinkedListStack();
        String a = "a";
        String b = "b";
        String c = "c";
        String d = "d";
        
        System.out.println("Pushing " + a);
        st.push(a);
        System.out.println("Pushing " + b);
        st.push(b);
        System.out.println("Pushing " + c);
        st.push(c);
        System.out.println("Pushing " + d);
        st.push(d);
        
        for (Object o : st) {
            System.out.println((String) o);
        }
        
    }
    
}
