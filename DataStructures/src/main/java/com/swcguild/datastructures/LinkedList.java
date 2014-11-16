package com.swcguild.datastructures;

public interface LinkedList {
    // adds to end of list
    void append(Object item);

    Object get(int index);

    // inserts after the given index
    void insert(int index, Object item);

    boolean isEmpty();

    void prepend(Object item);

    Object remove(int index);

    int size();
}
