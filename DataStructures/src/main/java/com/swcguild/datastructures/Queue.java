package com.swcguild.datastructures;

public interface Queue extends Iterable {
    
    public void enqueue(Object object);
    public Object dequeue();
    public boolean isEmpty();
    public int size();
    
}
