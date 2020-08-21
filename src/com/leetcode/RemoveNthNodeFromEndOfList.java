package com.leetcode;

public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        ListNode node1 = new ListNode(1, new ListNode(2));
        new RemoveNthNodeFromEndOfList().removeNthFromEndOptimized(node1, 2);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode temp = head;
        int lengthOfList = 0;
        while (head != null) {
            head = head.next;
            lengthOfList++;
        }
        System.out.println("--" + lengthOfList);

        ListNode previous = new ListNode(0);
        previous.next = temp;
        ListNode previousTraversal = previous;

        int position = lengthOfList - n;

        while (temp != null) {
            System.out.println("----");
            if (position == 0) {
                previousTraversal.next = temp.next;
                break;
            }

            ListNode nextNode = temp.next;
            previousTraversal = temp;
            temp = nextNode;

            position--;
        }

        return previous;
    }

    public ListNode removeNthFromEndOptimized(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slowPointer = dummy;
        ListNode fastPointer = dummy;

        int counter = 0;

        while (fastPointer != null) {

            if (counter == n + 1) break;
            fastPointer = fastPointer.next;
            counter++;
        }

        while (fastPointer != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }


        slowPointer.next = slowPointer.next.next;

        return dummy.next;
    }
}
