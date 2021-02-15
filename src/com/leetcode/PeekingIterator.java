package com.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PeekingIterator implements Iterator<Integer> {

    List<Integer> list;
    int index = -1;
    private Iterator<Integer> iterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        list = new ArrayList<>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
    }

    public int peek() {
        return list.get(index + 1);
    }

    @Override
    public boolean hasNext() {
        return index < list.size() - 1;
    }

    @Override
    public Integer next() {
        int result = list.get(index + 1);
        index++;
        return result;
    }
}
