package com.leetcode;

public class SwapNodesInPairDecChallenge {

    public static void main(String[] args) {
        ListNode node = new SwapNodesInPairDecChallenge().
                swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
        System.out.println("node = " + node);
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-10);

        dummy.next = head;
        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            ListNode cur = prev.next;
            ListNode forward = cur.next;
            ListNode temp = forward.next;

            prev.next = forward;
            forward.next = cur;
            cur.next = temp;

            prev = cur;

        }

        return dummy.next;
    }
}
