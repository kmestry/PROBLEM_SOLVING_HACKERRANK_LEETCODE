package com.blind_list_75.linkedlist;

public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode t = head;

        int size = 0;
        while (t != null) {
            t = t.next;
            size++;
        }

        ListNode prev;
        ListNode curr = head;
        int pos = size - n;
        int counter = 0;

        if (counter == pos) return head.next; // first node to be deleted.

        while (curr != null) {
            prev = curr;
            curr = curr.next;
            counter++;
            if (counter == pos) {
                prev.next = curr.next;
                break;
            }
        }

        return head;
    }
}
