package com.leetcode_restart;

import com.leetcode.ListNode;

public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode traverse = head;

        int length = 0;

        while (traverse != null) {
            traverse = traverse.next;
            length++;
        }
        System.out.println("==" + length);
        ListNode senitel = new ListNode();
        senitel.next = head;

        ListNode sT = senitel;
        ListNode hT = head;

        int lT = 0;

        while (hT != null) {

            if (lT == length - n) {
                ListNode nextN = hT.next;
                sT.next = nextN;
            }
            hT = hT.next;
            sT = sT.next;
            lT++;
        }

        return senitel.next;

    }
}
