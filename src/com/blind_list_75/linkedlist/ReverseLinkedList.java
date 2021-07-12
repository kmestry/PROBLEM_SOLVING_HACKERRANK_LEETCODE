package com.blind_list_75.linkedlist;

import com.leetcode.ListNode;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode node = new ReverseLinkedList().reverseList(
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
        System.out.println("node = " + node);
    }

    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while (curr != null) {
            next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }
}
