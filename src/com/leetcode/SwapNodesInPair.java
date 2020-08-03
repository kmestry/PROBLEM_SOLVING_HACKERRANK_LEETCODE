package com.leetcode;

public class SwapNodesInPair {
    ListNode node;

    public static void main(String[] args) {
        ListNode node = new SwapNodesInPair().swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
        System.out.println("node = " + node);
    }

    // 0 -> 1 -> 2 -> 3     0->2->1->3
    public ListNode swapPairsIterative(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        //firsSwap
        while (dummyNode != null && dummyNode.next != null) {
            ListNode traverseNode = dummyNode;
            int value = traverseNode.next.val;
            if (traverseNode.next.next == null) return head;
            traverseNode.next.val = traverseNode.next.next.val;
            traverseNode.next.next.val = value;
            System.out.println("value = " + value);
            dummyNode = dummyNode.next.next;

        }
        return head;
    }

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode secondNode = head.next;
        ListNode thirdNode = secondNode.next;

        secondNode.next = head;

        head.next = swapPairs(thirdNode);

        return secondNode;
    }
}
