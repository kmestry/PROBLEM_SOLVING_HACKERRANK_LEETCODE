package com.leetcode_restart;

import com.leetcode.ListNode;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode node = new ReverseLinkedList().reverseList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
    }

    public ListNode reverseList(ListNode head) {

        if (head == null) return null;
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
