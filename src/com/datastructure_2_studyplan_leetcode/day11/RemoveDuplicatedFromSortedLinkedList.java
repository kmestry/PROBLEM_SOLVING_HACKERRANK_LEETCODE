package com.datastructure_2_studyplan_leetcode.day11;

import com.leetcode.ListNode;

public class RemoveDuplicatedFromSortedLinkedList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3)))));

        ListNode l2 = new ListNode(1, new ListNode(2, new ListNode(2)));

        ListNode l3 = new ListNode(1, new ListNode(1, new ListNode(1)));
        new RemoveDuplicatedFromSortedLinkedList().deleteDuplicates(l3);
    }

    //[1,2,3,3,4,4,5]
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) return head;
        ListNode result = new ListNode(-10);
        result.next = head;

        ListNode prev = result;
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {

            int valToFind = Integer.MIN_VALUE;
            if (slow.val == fast.val) {
                valToFind = slow.val;
                while (fast != null && fast.val == valToFind) {
                    fast = fast.next;
                }
                prev.next = fast;
                if (fast == null) return result.next;
                slow = fast;
                fast = slow.next;
            } else {
                slow = slow.next;
                fast = fast.next;
                prev = prev.next;
            }
        }
        if (slow != null && fast != null && slow.val == fast.val) {
            prev.next = null;
        }

        return result.next;
    }
}
