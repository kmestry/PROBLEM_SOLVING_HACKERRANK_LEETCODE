package com.leetcode;

public class InsertionSortListOptimized {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(8, new ListNode(2, new ListNode(4, new ListNode(1, new ListNode(3)))));
        new InsertionSortListOptimized().insertionSortList(l1);
    }


    //explanation : https://www.youtube.com/watch?v=-0w2uswTST8
    public ListNode insertionSortList(ListNode head) {

        ListNode dummy = new ListNode();

        ListNode current = head;

        while (current != null) {

            ListNode previous = dummy;
            ListNode next = dummy.next;

            while (next != null) {
                if (current.val < next.val) {
                    break;
                }
                previous = previous.next;
                next = next.next;
            }

            ListNode temp = current.next;
            current.next = next;
            previous.next = current;


            current = temp;
        }

        return dummy.next;


    }
}
