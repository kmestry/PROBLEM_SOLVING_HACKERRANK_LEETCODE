package com.datastructure_studyplan_leetcode;

import com.leetcode.ListNode;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode node = new com.datastructure_studyplan_leetcode.ReverseLinkedList().reverseList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
        System.out.println("node = " + node);
    }

    public ListNode reverseList(ListNode head) {

        ListNode sentinel = null;

        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = sentinel;
            sentinel = curr;
            curr = next;
        }

        return sentinel;

    }
}
