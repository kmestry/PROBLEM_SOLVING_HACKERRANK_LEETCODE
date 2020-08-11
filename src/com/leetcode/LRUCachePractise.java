package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCachePractise {

    DoubleEndedNode head;
    DoubleEndedNode tail;
    int cacheCapacity;
    Map<Integer, DoubleEndedNode> mapOfDoubleEndedNode = new HashMap<>(); //for fast access to key.

    public LRUCachePractise(int capacity) {

        this.head = new DoubleEndedNode();
        this.tail = new DoubleEndedNode();

        head.next = tail;
        tail.previous = head;

        this.cacheCapacity = capacity;

    }

    public static void main(String[] args) {

        LRUCachePractise cache = new LRUCachePractise(2 /* capacity */);


        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }

    public int get(int key) {
        DoubleEndedNode doubleEndedNode = mapOfDoubleEndedNode.get(key);
        if (doubleEndedNode != null) {
            removeNode(doubleEndedNode);
            addNode(doubleEndedNode);
            return doubleEndedNode.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        DoubleEndedNode doubleEndedNode = mapOfDoubleEndedNode.get(key);

        if (doubleEndedNode != null) {
            removeNode(doubleEndedNode);
            doubleEndedNode.value = value;
            addNode(doubleEndedNode);
        } else {
            if (mapOfDoubleEndedNode.size() == cacheCapacity) {
                mapOfDoubleEndedNode.remove(tail.previous.key);
                removeNode(tail.previous);

            }
            DoubleEndedNode node = new DoubleEndedNode(key, value);
            addNode(node);
            mapOfDoubleEndedNode.put(key, node);
        }


    }

    public void removeNode(DoubleEndedNode doubleEndedNode) {
        DoubleEndedNode tempNode = doubleEndedNode.next;
        DoubleEndedNode tempNodePrevious = doubleEndedNode.previous;

        tempNodePrevious.next = doubleEndedNode.next;
        tempNode.previous = tempNodePrevious;

    }


    //had always to the front of the doubly end linked list. to maintain access order.
    public void addNode(DoubleEndedNode doubleEndedNode) {
        DoubleEndedNode tempNode = head.next;

        head.next = doubleEndedNode;
        doubleEndedNode.next = tempNode;
        doubleEndedNode.previous = head;
        tempNode.previous = doubleEndedNode;
    }


    class DoubleEndedNode {
        DoubleEndedNode next;
        DoubleEndedNode previous;
        int key;
        int value;

        DoubleEndedNode() {

        }

        DoubleEndedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
