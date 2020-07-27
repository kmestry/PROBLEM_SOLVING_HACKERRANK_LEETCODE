package com.leetcode;

import java.util.LinkedList;
import java.util.List;

public class MyHashSetDesign {


    Object[] bucket;

    public MyHashSetDesign() {
        this.bucket = new Object[10];
    }

    /**
     * Initialize your data structure here.
     */

    public static void main(String[] args) {
        MyHashSetDesign myHashSetDesign = new MyHashSetDesign();
        myHashSetDesign.add(40);
        myHashSetDesign.add(0);
        myHashSetDesign.add(10);

        myHashSetDesign.contains(40);
    }

    public void add(int key) {
        int bucketLocation = hashFunction(key);
        //System.out.println("bucket = " + bucket);
        if (bucket[bucketLocation] instanceof Integer && bucket[bucketLocation].equals(key)) {
            return;
        }
        if (bucket[bucketLocation] == null)
            bucket[bucketLocation] = key;
        else {
            Object value = bucket[bucketLocation];
            bucket[bucketLocation] = null;
            if (value instanceof Integer) {
                List collisionList = new LinkedList<>();
                collisionList.add(value);
                collisionList.add(key);
                bucket[bucketLocation] = collisionList;
            }
            if (value instanceof List) {
                if (!((List) value).contains(key)) {
                    ((List) value).add(key);
                }
                bucket[bucketLocation] = value;
            }


        }


    }

    public void remove(int key) {
        int bucketLocation = hashFunction(key);
        Object value = bucket[bucketLocation];
        if (value != null) {
            if (value instanceof Integer) {
                bucket[bucketLocation] = null;
            }
            if (value instanceof List) {

                for (Object elementOfList : (List) value) {
                    if (elementOfList.equals(key)) {
                        ((List) value).remove(elementOfList);
                        break;
                    }
                }
                //bucket.add(bucketLocation, value);

            }
        }


    }

    private int hashFunction(int key) {
        return (key) % 10;
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {

        int bucketLocation = hashFunction(key);
        Object value = bucket[bucketLocation];
        if (value != null) {
            if (value instanceof Integer) {
                return value.equals(key);
            }
            if (value instanceof List) {
                for (Object elementOfList : (List) value) {
                    if (elementOfList.equals(key)) {
                        return true;
                    }
                }
            }

        }
        return false;
    }
}
