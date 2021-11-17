package com.datastructure_studyplan_leetcode;

import com.leetcode.ListNode;

public class DeleteDuplicateNode {
    public ListNode deleteDuplicates(ListNode head) {

        //consider 2nd node as curr.
        if (head == null) return head;
        ListNode prev = head;
        ListNode curr = prev.next;


        while (curr != null) {
            if (curr.val == prev.val) {
                ListNode next = curr.next;
                prev.next = curr.next;
                curr = next;
            } else {
                curr = curr.next;
                prev = prev.next;
            }
        }

        return head;
    }
}
