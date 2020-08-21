package com.leetcode;

public class MergeTwoLinkedLists {


    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        new MergeTwoLinkedLists().mergeTwoLists(node1, node2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-10);
        ListNode head = dummy;

        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }

            head = head.next;

        }

        if (l1 != null) {
            head.next = l1;
        }

        if (l2 != null) {
            head.next = l2;
        }

        return dummy.next;
    }
}
