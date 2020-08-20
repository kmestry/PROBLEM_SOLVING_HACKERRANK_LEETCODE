package com.leetcode;

public class MiddleOfLinkedList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode nodeAnswer = new MiddleOfLinkedList().middleNodeOptimized(node);
        System.out.println("nodeAnswer = " + nodeAnswer);
    }

    public ListNode middleNode(ListNode head) {


        if (head == null || head.next == null) return head;

        int lengthOfList = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            lengthOfList++;
        }

        int mid = lengthOfList / 2;
        //System.out.println(mid);
        ListNode node = new ListNode(0);
        while (head != null) {
            // System.out.println(head.val);
            if (mid == 0) {
                System.out.println(head.val);
                node.next = head;
                break;
            } else {
                head = head.next;
                mid--;
            }
        }

        return node.next;
    }

    public ListNode middleNodeOptimized(ListNode head) {

        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {

            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return slowPointer;
    }
}
