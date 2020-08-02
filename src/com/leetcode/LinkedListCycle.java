package com.leetcode;


public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {


        if (head == null || head.next == null)
            return false;

        ListNode slowNode = head;
        ListNode fastNode = head;


        while (fastNode != null && fastNode.next != null && slowNode != null) {
            slowNode = slowNode.next;

            fastNode = fastNode.next.next;

            if (slowNode == fastNode) {
                return true;
            }

        }
        return false;


    }
}

