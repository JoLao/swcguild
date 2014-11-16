/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.datastructures;

import java.util.Iterator;


public class LinkedListStack implements Stack {

    private Node first;
    private int numItems;
        
    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return numItems;
    }

    @Override
    public void push(Object item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        numItems++;
    }

    @Override
    public Object pop() {
        Object ret = first;
        if (ret != null) {
            ret = first.item;
            first = first.next;
            numItems--;
        }
        return ret;
    }

    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }
    
    private class LinkedListIterator implements Iterator {
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
