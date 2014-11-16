/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.datastructures;

import java.util.Iterator;

/**
 *
 * @author apprentice
 */
public class GenArrayStackDriver {
    
    public static void main(String[] args) {
        GenStack<String> st = new GenLinkedListStack<>();
        st.push("Joe");
        st.push("Steve");
        st.push("Sally");
        
//        System.out.println(st.pop());
//        System.out.println(st.pop());
//        System.out.println(st.pop());
        
        Iterator<String> iter = st.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        
        for (String s : st) {
            System.out.println(s);
        }
        

            
        
    }
    
}
