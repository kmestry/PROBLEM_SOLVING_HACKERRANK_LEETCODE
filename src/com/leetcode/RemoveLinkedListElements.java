package com.leetcode;

public class RemoveLinkedListElements {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2, new ListNode(3));
        ListNode listNode2 = new ListNode(1, listNode1);
        removeElements(listNode2, 3);
    }

    //Input:  1->2->6->3->4->5->6, val = 6
    //Output: 1->2->3->4->5
    // 1 val=1
    public static ListNode removeElements(ListNode head, int val) {

        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode prevPointer = sentinel;
        ListNode currPointer = head;

        while (currPointer != null) {
            if (currPointer.val == val) {
                prevPointer.next = currPointer.next;
            } else {
                prevPointer = currPointer;
            }
            currPointer = currPointer.next;
        }

        return sentinel.next;

    }
}
