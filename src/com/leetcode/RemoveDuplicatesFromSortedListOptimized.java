package com.leetcode;

public class RemoveDuplicatesFromSortedListOptimized {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(3, new ListNode(3)))));
        new RemoveDuplicatesFromSortedListOptimized().deleteDuplicates(l1);
    }

    public ListNode deleteDuplicates(ListNode head) {

        ListNode curr = head;

        while (curr != null && curr.next != null) {

            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }


        return head;
    }
}
