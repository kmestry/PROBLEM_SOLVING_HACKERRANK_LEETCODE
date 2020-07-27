package com.leetcode;

import java.util.LinkedList;
import java.util.List;

public class DesignHashSet {


    /**
     * Initialize your data structure here.
     */
    int[] bucket;
    List<Integer> collisionList = new LinkedList<>();

    public DesignHashSet() {
        this.bucket = new int[1000001];

    }

    public static void main(String[] args) {

        DesignHashSet obj = new DesignHashSet();
        //obj.add(1000000);
        obj.add(0);
        obj.contains(0);
        obj.remove(0);
        obj.contains(0);


    }

    public void add(int key) {

        int bucketIndex = hashFunction(key);
        if (bucketIndex == 1) bucket[bucketIndex] = 1000002;
        else bucket[bucketIndex] = key;

    }

    public void remove(int key) {
        int bucketIndex = hashFunction(key);
        if (bucketIndex == 1) {
            bucket[bucketIndex] = -1000002;
        } else {
            bucket[bucketIndex] = 0;
        }

    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int bucketIndex = hashFunction(key);
        if (bucketIndex == 1) {
            return bucket[bucketIndex] > 0;
        }
        return bucket[bucketIndex] != 0;
    }

    private int hashFunction(int key) {
        int hashResult = key + 1;
        return hashResult;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

