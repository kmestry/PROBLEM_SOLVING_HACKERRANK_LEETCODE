package com.leetcode_restart;

import com.leetcode.ListNode;

public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {

        ListNode prev = new ListNode();
        prev.next = head;
        ListNode t = prev;
        ListNode curr = head;

        while (curr != null) {
            if (curr.val == val) {
                ListNode nextNode = curr.next;
                curr = curr.next;
                t.next = nextNode;
            } else {
                ListNode n1 = curr;
                curr = curr.next;
                t = n1;
            }
        }

        return prev.next;
    }
}
