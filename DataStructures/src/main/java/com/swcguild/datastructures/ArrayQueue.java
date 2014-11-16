package com.swcguild.datastructures;

import java.util.Iterator;

public class ArrayQueue implements Queue {
    
    private static int DEFAULT_INITIAL_SIZE = 4;
    private Object[] items;
    private int numItems = 0;
    private int head = 0;
    private int tail = -1;

    public ArrayQueue() {
        this(DEFAULT_INITIAL_SIZE);
    }

    public ArrayQueue(int newSize) {
        this.items = new Object[newSize];
    }
    
    
    @Override
    public void enqueue(Object object) {
        if (numItems == items.length) {
            resize(2 * items.length);
        }
        tail = (tail + 1) % (items.length);
        items[tail] = object;
        numItems++;
    }

    @Override
    public Object dequeue() {
        if (numItems == 0) {
            resize(items.length / 2);
        }
        Object object = items[head];
        items[head] = null;
        head = (head + 1) % (items.length);
        numItems--;
        if (numItems == 0 && items.length > DEFAULT_INITIAL_SIZE) {
            resize(DEFAULT_INITIAL_SIZE);
        } else if (numItems > 0 && numItems == items.length / 4) {
            resize(items.length / 2);
        }
        return object;
    }

    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }

    @Override
    public int size() {
        return numItems;
    }

    private void resize(int newSize) {
        Object[] temp = items;
        items = new Object[newSize];
        int j = head;
        
        for (int i = 0; i < items.length; i++) {
            items[i] = temp[j];
            j = (j + 1) % temp.length;
        }
        head = 0;
        tail = numItems - 1;
    }
    
    @Override
    public Iterator iterator() {
        return new InOrderArrayIterator();
    }
    
    private class InOrderArrayIterator implements Iterator {
        int i = numItems;
        int h = head - 1;
        
        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Object next() {
            h = (h + 1) % items.length;
            i--;
            return items[h];
        }
        
    }
}
