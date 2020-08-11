package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    int cacheCapacity;
    ListNode head;
    ListNode tail;
    Map<Integer, ListNode> nodeMap;

    public LRUCache(int capacity) {
        this.cacheCapacity = capacity;
        this.head = new ListNode();
        this.tail = new ListNode();
        head.next = tail;
        tail.previous = head;
        this.nodeMap = new HashMap<>(cacheCapacity);

    }

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2 /* capacity */);


        cache.put(10, 5);
        cache.put(10, 11);
        cache.get(10);
    }

    public int get(int key) {

        int result = -1;

        ListNode listNode = nodeMap.get(key);
        if (listNode != null) {
            remove(listNode);
            addNode(listNode);
            result = listNode.value;
        }
        return result;

    }

    public void put(int key, int value) {
        ListNode node = nodeMap.get(key);
        if (node != null) {
            remove(node);
            node.value = value;
            addNode(node);
        } else {
            if (cacheCapacity == nodeMap.size()) {
                nodeMap.remove(tail.previous.key);
                remove(tail.previous);
            }// remove last node i.e. least recently used node.
            ListNode listNode = new ListNode();
            listNode.key = key;
            listNode.value = value;
            nodeMap.put(key, listNode);
            addNode(listNode);
        }
    }

    public void remove(ListNode node) {
        ListNode nodeNext = node.next;
        ListNode nodePrevious = node.previous;

        nodePrevious.next = nodeNext;
        nodeNext.previous = nodePrevious;

    }

    public void addNode(ListNode newNode) {
        ListNode tempNode = head.next;
        tempNode.previous = newNode;
        newNode.next = tempNode;
        head.next = newNode;
        newNode.previous = head;

    }


    class ListNode {
        ListNode previous;
        ListNode next;
        int key;
        int value;
    }
}
