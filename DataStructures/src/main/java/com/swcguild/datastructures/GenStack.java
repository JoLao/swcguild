package com.swcguild.datastructures;

public interface GenStack <Item> extends Iterable<Item> {
    public boolean isEmpty();
    public int size();
    public void push(Item item);
    public Item pop();
}
