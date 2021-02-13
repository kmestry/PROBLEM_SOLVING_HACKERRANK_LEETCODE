package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CloneLinkedListRandomPointer {

    public Node_RandomPointerClone copyRandomList(Node_RandomPointerClone head) {

        if (head == null) return null;

        Map<Node_RandomPointerClone, Node_RandomPointerClone> map = new HashMap<>();

        Node_RandomPointerClone curr = head;
        while (curr != null) {
            map.put(curr, new Node_RandomPointerClone(curr.val));
            curr = curr.next;
        }
        System.out.println(map);
        for (Node_RandomPointerClone key : map.keySet()) {
            Node_RandomPointerClone newNodeRandomPointerClone = map.get(key);
            newNodeRandomPointerClone.next = map.get(key.next);
            newNodeRandomPointerClone.random = map.get(key.random);
        }

        return map.get(head);
    }
}

class Node_RandomPointerClone {
    int val;
    Node_RandomPointerClone next;
    Node_RandomPointerClone random;

    public Node_RandomPointerClone(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    @Override
    public String toString() {
        return "Node_RandomPointerClone{" +
                "val=" + val +
                ", next=" + next +
                ", random=" + random +
                '}';
    }
}