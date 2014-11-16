/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.datastructures;

/**
 *
 * @author apprentice
 */
public interface Queue extends Iterable {
    
    public void enqueue(Object item);
    public Object dequeue();
    public boolean isEmpty();
    public int size();
    
}
