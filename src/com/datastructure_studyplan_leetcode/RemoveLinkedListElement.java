package com.datastructure_studyplan_leetcode;

import com.leetcode.ListNode;

public class RemoveLinkedListElement {

    public ListNode removeElements(ListNode head, int val) {

        ListNode sentinel = new ListNode();
        sentinel.next = head;

        ListNode curr = head;
        ListNode prev = sentinel;

        while (curr != null) {
            if (curr.val == val) {
                ListNode next = curr.next;
                prev.next = curr.next;
                curr = next;
            } else {
                curr = curr.next;
                prev = prev.next;
            }

        }

        return sentinel.next;
    }
}
