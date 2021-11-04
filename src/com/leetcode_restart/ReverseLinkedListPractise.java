package com.leetcode_restart;

import com.leetcode.ListNode;

public class ReverseLinkedListPractise {

    public static void main(String[] args) {
        new ReverseLinkedListPractise().reverseList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));


    }


    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode senitel = new ListNode();
        senitel.next = head;

        ListNode traverseST = senitel;
        ListNode traverse = head;

        int i = 0;
        while (traverse != null) {
            ListNode next = traverse.next;

            traverse.next = traverseST;

            traverseST = traverse;
            traverse = next;
            if (i == 0) {
                traverseST.next = null;
            }
            i++;
        }

        return traverseST;
    }
}
