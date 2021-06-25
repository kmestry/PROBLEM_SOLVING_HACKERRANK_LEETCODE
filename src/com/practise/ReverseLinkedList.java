package com.practise;

import com.leetcode.ListNode;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        reverseLinkedList.reverseList(node);
    }

    // 1->2->3->4->null

    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {

            next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }
}
