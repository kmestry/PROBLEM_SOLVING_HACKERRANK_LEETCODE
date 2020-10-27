package com.leetcode;

public class LinkedListCycle2OctoberChallenge {

    public static void main(String[] args) {
     /*   ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);

        node1.next = node2;
        node2.next = node1;
        new LinkedListCycle2OctoberChallenge().detectCycle(node1);*/

        new LinkedListCycle2OctoberChallenge().detectCycle(new ListNode(1));
    }

    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) return null;
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (slowPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if (fastPointer == null) {
                return null;
            }
            if (slowPointer == fastPointer) {
                break;
            }
        }


        fastPointer = head;

        if (slowPointer == fastPointer) {
            return slowPointer;
        }

        while (slowPointer != null && fastPointer != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;

            if (slowPointer == fastPointer) {
                break;
            }
        }

        return slowPointer;

    }
}
