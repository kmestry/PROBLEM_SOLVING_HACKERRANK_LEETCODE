package com.leetcode;


public class DeleteNodeLinkedList237 {

    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;

    }
}
