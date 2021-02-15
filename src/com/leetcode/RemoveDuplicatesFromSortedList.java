package com.leetcode;

public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        new RemoveDuplicatesFromSortedList().deleteDuplicates(l1);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(-10);
        dummy.next = head;
        ListNode prev = dummy.next;
        ListNode headTraverse = head;


        while (headTraverse != null) {
            if (headTraverse.next != null && headTraverse.val != headTraverse.next.val) {
                prev.next = headTraverse.next;
                prev = headTraverse.next;
            }
            headTraverse = headTraverse.next;
        }


        return dummy.next;
    }


}
