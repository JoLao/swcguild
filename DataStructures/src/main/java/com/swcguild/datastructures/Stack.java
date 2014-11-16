package com.swcguild.datastructures;

public interface Stack extends Iterable {
    
    public boolean isEmpty();
    public int size();
    public void push(Object item);
    public Object pop();
    
}
