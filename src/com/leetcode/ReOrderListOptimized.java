package com.leetcode;

public class ReOrderListOptimized {

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        new ReOrderListOptimized().reorderList(node);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    private static void merge(ListNode l1, ListNode l2) {
        while (l2 != null) {
            ListNode next = l1.next;
            l1.next = l2;
            l1 = l2;
            l2 = next;
        }
    }

    public void reorderList(ListNode head) {


        ListNode previous = head;
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            previous = slowPointer;
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }


        previous.next = null;


        ListNode l1 = head;
        ListNode l2 = reverse(slowPointer);

        merge(l1, l2);


    }

    private ListNode reverse(ListNode head) {

        ListNode previous = null;

        while (head != null) {
            ListNode nextNode = head.next;
            head.next = previous;

            previous = head;
            head = nextNode;
        }

        return previous;
    }
}
