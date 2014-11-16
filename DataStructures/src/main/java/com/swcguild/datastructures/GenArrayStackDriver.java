package com.swcguild.datastructures;

import java.util.Iterator;

public class GenArrayStackDriver {

    public static void main(String[] args) {
        GenStack<String> st = new GenArrayStack<>();
        
        st.push("Joe");
        st.push("Steve");
        st.push("Sally");
        
        System.out.println("pop 1 "+st.pop());
        System.out.println("pop 2 "+st.pop());
        System.out.println("pop 3 "+st.pop());
        
        GenStack<String> stl = new GenLinkedListStack<>();
        
        stl.push("Joe");
        stl.push("Steve");
        stl.push("Sally");
        
        for (Iterator<String> it = stl.iterator(); it.hasNext();) {
            String s = it.next();
            System.out.println("pop"+stl.pop());
        }
                
    }
}
