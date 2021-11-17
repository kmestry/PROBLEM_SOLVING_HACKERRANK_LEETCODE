package com.geeksforgeeks.hashing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ImplementationOfChaining {

    int bucketSize;
    List<LinkedList<Integer>> list;

    ImplementationOfChaining(int bucketSize) {
        this.bucketSize = bucketSize;
        list = new ArrayList<>();

        for (int i = 0; i < bucketSize; i++) {
            list.add(new LinkedList<>());
        }
    }

    public static void main(String[] args) {
        ImplementationOfChaining implementationOfChaining = new ImplementationOfChaining(5);
        implementationOfChaining.insert(10);
        implementationOfChaining.insert(22);
        implementationOfChaining.insert(30);

        implementationOfChaining.delete(30);

        System.out.println(implementationOfChaining.search(22));
    }

    void insert(int value) {
        int index = value % bucketSize;
        LinkedList<Integer> linkedList = list.get(index);
        linkedList.add(value);
    }

    void delete(int value) {
        int index = value % bucketSize;
        LinkedList<Integer> linkedList = list.get(index);
        linkedList.remove((Integer) value);
    }

    boolean search(int value) {
        int index = value % bucketSize;
        LinkedList<Integer> linkedList = list.get(index);
        return linkedList.contains(value);
    }

}


