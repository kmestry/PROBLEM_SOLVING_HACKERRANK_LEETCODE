package com.geeksforgeeks.hashing;

import java.util.Arrays;

// Open Addressing Hashing technique Implementation
public class MyHash {

    int[] arr;
    int hashTableSize;

    MyHash(int capacity) {
        this.arr = new int[capacity];
        this.hashTableSize = capacity;

        Arrays.fill(arr, -1);

    }

    public static void main(String[] args) {
        MyHash myHash = new MyHash(7);
        myHash.insert(49);
        myHash.insert(50);
        myHash.insert(51);
        myHash.insert(63);
        myHash.insert(68);
        myHash.insert(75);
        //myHash.insert(63);

        myHash.delete(50);
        myHash.delete(63);
        myHash.delete(64);

    }

    public int hashFunction(int key) {
        return key % hashTableSize;
    }

    private boolean search(int key) {

        int indexOfKey = hashFunction(key);
        int initialIndex = indexOfKey;
        while (arr[indexOfKey] != -1) {
            if (arr[indexOfKey] == key) {
                return true;
            }
            indexOfKey = (indexOfKey + 1) % hashTableSize; // due to circular nature of search.

            if (indexOfKey == initialIndex) {
                return false;
            }
        }
        return false;
    }

    private boolean insert(int key) {

        int indexOfKey = hashFunction(key);
        int initialIndex = indexOfKey;
        while (arr[indexOfKey] != -1 && arr[indexOfKey] != -2 && arr[indexOfKey] != key) {

            indexOfKey = (indexOfKey + 1) % hashTableSize; // due to circular nature of search.

            if (indexOfKey == initialIndex) {
                return false;
            }
        }
        if (arr[indexOfKey] == -1 || arr[indexOfKey] == -2 && arr[indexOfKey] != key) {
            arr[indexOfKey] = key;
            return true;
        }
        return false;

    }

    private boolean delete(int key) {
        int indexOfKey = hashFunction(key);

        while (arr[indexOfKey] != key && arr[indexOfKey] != -1) {

            indexOfKey = (indexOfKey + 1) % hashTableSize;

        }
        if (arr[indexOfKey] == key) {
            arr[indexOfKey] = -2;
            return true;
        }
        return false;
    }
}
