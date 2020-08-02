package com.leetcode;

import java.util.LinkedList;

public class MyHashSetSeperateChaining {


    LinkedList<Integer>[] bucketList;
    int filledCapacity = 0;
    int initialCapacity = 1000;

    /**
     * Initialize your data structure here.
     */
    public MyHashSetSeperateChaining() {
        this.bucketList = new LinkedList[initialCapacity];
    }

    public static void main(String[] args) {
        MyHashSetSeperateChaining obj = new MyHashSetSeperateChaining();

        obj.add(1000);
        obj.add(0);
        obj.remove(1000);


    }

    public void add(int key) {
        /*if(filledCapacity > bucketList.length/2){
            reHash(filledCapacity,bucketList);
        }*/

        if (contains(key) == false) {
            int index = hashValue(key, bucketList.length);
            if (bucketList[index] == null) {
                LinkedList<Integer> integerLinkedList = new LinkedList<>();
                integerLinkedList.add(key);
                bucketList[index] = integerLinkedList;

            } else {
                //collision
                LinkedList<Integer> bucket = bucketList[index];
                bucket.addLast(key);

            }
            filledCapacity++;
        } else {
            System.out.println("key is already present in Bucket= " + key);
        }
    }

    public void remove(int key) {
        int index = hashValue(key, bucketList.length);
        if (bucketList[index] != null) {
            bucketList[index].removeFirstOccurrence(key);

            filledCapacity--;
        } else {
            System.out.println("key notremove present + key remove+" + key);
        }

    }

   /* private void reHash(int filledCapacity, List<Integer>[] bucketList) {
        //50% bucket filled . early rehash.
        int capacity = bucketList.length  * 2;

        for



    }*/


    private int hashValue(int key, int bucketSize) {
        return key % bucketSize;
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int index = hashValue(key, bucketList.length);
        if (bucketList[index] == null) {
            return false;
        } else {
            LinkedList<Integer> linkedList = bucketList[index];
            return linkedList.contains(key);
        }

    }
}
