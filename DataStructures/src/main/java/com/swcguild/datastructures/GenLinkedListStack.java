package com.swcguild.datastructures;

import java.util.Iterator;

public class GenLinkedListStack<Item> implements GenStack <Item> {
    private Node<Item>  first;
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
    public void push(Item item) {
        Node<Item> prevFirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = prevFirst;
        numItems++;
    }

    @Override
    public Item pop() {
        Item item = first.item;
        first = first.next;
        numItems--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedListIterator<Item>();
    }
    
    private class LinkedListIterator<Item> implements Iterator<Item> {
        Node<Item> current = (Node<Item>) first;
        
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (current == null) {
                return null;
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
        
    }
    
    private class Node<Item> {
        Item item;
        Node next;
    }
}
