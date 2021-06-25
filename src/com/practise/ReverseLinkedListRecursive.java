package com.practise;

import com.leetcode.ListNode;

public class ReverseLinkedListRecursive {
    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ReverseLinkedListRecursive reverseLinkedListRecursive = new ReverseLinkedListRecursive();
        ListNode reversed = reverseLinkedListRecursive.reverseList(node);
        System.out.println(reversed);
    }

    // 1 -> 2 -> 3 -> 4 -> 5
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode reversedNode = reverseList(head.next);

        head.next.next = head;

        head.next = null;
        return reversedNode;

    }
}
