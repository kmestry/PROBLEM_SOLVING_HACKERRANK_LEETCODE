package com.leetcode_restart;

import com.leetcode.ListNode;

public class MergeTwoSortedLinkedList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode senitel = new ListNode();
        ListNode sT = senitel;
        ListNode t1 = l1;
        ListNode t2 = l2;

        while (t1 != null && t2 != null) {
            if (t1.val < t2.val) {
                sT.next = t1;
                t1 = t1.next;
            } else {
                sT.next = t2;
                t2 = t2.next;
            }
            sT = sT.next;
        }

        if (t1 != null) {
            sT.next = t1;
        } else {
            sT.next = t2;
        }

        return senitel.next;

    }
}
