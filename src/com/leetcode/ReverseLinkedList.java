package com.leetcode;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode node = new ReverseLinkedList().reverseListIterative(new ListNode(1, new ListNode(2, new ListNode(3))));
        System.out.println("node = " + node);
    }

    public ListNode reverseList(ListNode head) {

        return reverseHelper(head, null);

    }

    private ListNode reverseHelper(ListNode head, ListNode newHead) {

        if (head == null) {
            return newHead;
        }

        ListNode next = head.next;
        head.next = newHead;
        newHead = head;
        head = next;

        return reverseHelper(head, newHead);
    }


    private ListNode reverseListIterative(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {

            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;

        }
        return prev;
    }
}
