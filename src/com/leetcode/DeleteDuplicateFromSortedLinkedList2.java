package com.leetcode;

public class DeleteDuplicateFromSortedLinkedList2 {


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3)))));
        new DeleteDuplicateFromSortedLinkedList2().deleteDuplicates(l1);
    }

    public ListNode deleteDuplicates(ListNode head) {


        ListNode dummy = new ListNode(-10);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode headT = head;

        while (headT != null) {

            if (headT.next != null && headT.val == headT.next.val) {
                while (headT.next != null && headT.val == headT.next.val) {
                    headT = headT.next;
                }
                prev.next = headT.next;
            } else {
                prev = prev.next;

            }
            headT = headT.next;
        }

        return dummy.next;

    }
}
