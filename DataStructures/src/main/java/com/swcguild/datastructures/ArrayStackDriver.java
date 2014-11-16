package com.swcguild.datastructures;

public class ArrayStackDriver {
  
    public static void main(String[] args) {
        Stack st = new ArrayStack();
        String a = "a";
        String b = "b";
        String c = "c";
        String d = "d";
        
        System.out.println("Pushing a "+ a);
        st.push(a);
        
        System.out.println("Pushing b "+ b);
        st.push(b);
        
        System.out.println("Pushing c "+ c);
        st.push(c);
        
        System.out.println("Pushing d "+ d);
        st.push(d);
        
        for (Object o : st) {
            System.out.println(o);
        }
        
        Stack stl = new LinkedListStack();
        
        System.out.println("Pushing a "+ a);
        stl.push(a);
        
        System.out.println("Pushing b "+ b);
        stl.push(b);
        
        System.out.println("Pushing c "+ c);
        stl.push(c);
        
        System.out.println("Pushing d "+ d);
        stl.push(d);
        
        for (Object o : stl) {
            System.out.println(o);
        }
    }
}
