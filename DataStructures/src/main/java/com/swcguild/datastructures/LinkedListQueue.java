package com.swcguild.datastructures;

import java.util.Iterator;
import javax.xml.soap.Node;

public class LinkedListQueue implements Queue {

    private Node first;
    private Node last;
    private int numItems;

    @Override
    public void enqueue(Object item) {
        Node oldLast = last;

        last = new Node();
        last.item = item;
        oldLast = last;
        
        if (first == null) {
            first = last;
        } 

        numItems++;
    }

    @Override
    public Object dequeue() {
        Object ret = first;

        if (ret != null) {
            ret = first.item;
            first = first.next;
            numItems--;
        }
        return ret;

    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return numItems;
    }

    @Override
    public Iterator iterator() {
        return new LinkedListQIterator();
    }

    private class LinkedListQIterator implements Iterator {

        Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Object next() {
            if (current == null) {
                return null;
            }
            Object ret = current.item;
            current = current.next;
            return ret;
        }

    }

    private class Node {

        Object item;
        Node next;
    }
}
