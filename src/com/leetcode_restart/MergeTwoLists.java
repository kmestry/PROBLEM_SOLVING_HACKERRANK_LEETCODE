package com.leetcode_restart;

import com.leetcode.ListNode;

public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode senitel_P = new ListNode();
        senitel_P.next = l1;

        ListNode senitel = senitel_P;
        ListNode l1T = l1;
        ListNode l2T = l2;

        while (l1T != null && l2T != null) {

            if (l1T.val < l2T.val) {
                senitel.next = l1T;
                senitel = senitel.next;
                l1T = l1T.next;
            } else {
                senitel.next = l2T;
                senitel = senitel.next;
                l2T = l2T.next;
            }
        }

        if (l1T != null) {
            senitel.next = l1T;
        } else if (l2T != null) {
            senitel.next = l2T;
        }

        return senitel_P.next;
    }
}
