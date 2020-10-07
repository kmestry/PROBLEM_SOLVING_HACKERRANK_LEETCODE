package com.leetcode;

public class RotateList {

    //[1,2,3]
    //2000000000
    public static void main(String[] args) {
        //ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode node = new ListNode(0, new ListNode(1, new ListNode(2)));
        ListNode listNode = new RotateList().rotateRight(node, 4);
        System.out.println("listNode = " + listNode);
    }

    //brute force initial solution accepted
    public ListNode rotateRight(ListNode head, int k) {

        if (k == 0 || head == null || head.next == null) return head;

        int sizeOfOriginalList = 0;

        ListNode sizeNodeHelper = head;
        while (sizeNodeHelper != null) {
            sizeNodeHelper = sizeNodeHelper.next;
            sizeOfOriginalList++;
        }
        if (k > sizeOfOriginalList + 10000) {
            while (sizeOfOriginalList > 1) {
                if (k % sizeOfOriginalList == 0) {
                    k = sizeOfOriginalList;
                    break;
                } else {
                    sizeOfOriginalList--;
                }
            }
        }

        ListNode dummy = new ListNode(-10);
        dummy.next = head;

        ListNode dummyTraversal = dummy;

        ListNode traverseNode = head;

        while (k > 0) {
            while (traverseNode.next != null) {
                dummyTraversal = traverseNode;
                traverseNode = traverseNode.next;
            }
            dummyTraversal.next = null;
            traverseNode.next = head;
            head = traverseNode;
            k--;
        }


        return traverseNode;
    }
}
