package com.leetcode;

public class MergeTwoSortedListJanChallenge {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        new MergeTwoSortedListJanChallenge().mergeTwoLists(l1, l2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-10);
        ListNode prev = dummy;
        ListNode first = l1;
        ListNode second = l2;


        while (first != null && second != null) {
            if (first.val <= second.val) {
                prev.next = new ListNode(first.val);
                prev = prev.next;
                prev.next = new ListNode(second.val);
            } else {
                prev.next = new ListNode(second.val);
                prev = prev.next;
                prev.next = new ListNode(first.val);
            }
            first = first.next;
            second = second.next;
            prev = prev.next;

        }

        while (first != null) {
            prev.next = new ListNode(first.val);
            prev = prev.next;
            first = first.next;
        }
        while (second != null) {
            prev.next = new ListNode(second.val);
            prev = prev.next;
            second = second.next;
        }

        return dummy.next;

    }
}
