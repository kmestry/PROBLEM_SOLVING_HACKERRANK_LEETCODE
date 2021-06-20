package com.frosty;

import com.leetcode.ListNode;

public class ReverseLinkedListRecursive {
    public static void main(String[] args) {
        ListNode node = new ReverseLinkedListRecursive().reverseList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
        System.out.println("node = " + node);
    }

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode reversedList = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return reversedList;
    }
}
