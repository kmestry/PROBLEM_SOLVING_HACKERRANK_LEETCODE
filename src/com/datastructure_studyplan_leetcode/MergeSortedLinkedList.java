package com.datastructure_studyplan_leetcode;

import com.leetcode.ListNode;

public class MergeSortedLinkedList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode senitel = new ListNode();
        senitel.next = l1;
        ListNode res = senitel;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                res.next = l1;
                l1 = l1.next;
                res = res.next;
            } else {
                res.next = l2;
                l2 = l2.next;
                res = res.next;
            }
        }

        if (l1 != null) {
            res.next = l1;
        }
        if (l2 != null) {
            res.next = l2;
        }

        return senitel.next;

    }
}
