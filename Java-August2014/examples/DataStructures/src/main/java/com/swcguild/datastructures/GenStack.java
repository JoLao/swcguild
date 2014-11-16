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
public interface GenStack <Item> extends Iterable<Item> {
    public boolean isEmpty();
    public int size();
    public void push(Item item);
    public Item pop();
}
