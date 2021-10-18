package com.leetcode_restart;

import com.leetcode.ListNode;

public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode first = head;
        ListNode second = head.next;

        while (second != null) {
            if (first.val == second.val) {

                ListNode nextNode = second.next;
                second = second.next;
                first.next = nextNode;

            } else {
                first = first.next;
                second = second.next;
            }
        }

        return head;
    }
}
