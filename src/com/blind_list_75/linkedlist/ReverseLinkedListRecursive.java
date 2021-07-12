package com.blind_list_75.linkedlist;

import com.leetcode.ListNode;

public class ReverseLinkedListRecursive {

    public static void main(String[] args) {
        ListNode node = new ReverseLinkedListRecursive().reverseList(
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
        System.out.println("node = " + node);
    }

    public ListNode reverseList(ListNode head) {

        if (head.next == null) {
            return head;
        }

        ListNode reversed = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return reversed;
    }


}
