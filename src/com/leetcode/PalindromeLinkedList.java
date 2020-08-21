package com.leetcode;

public class PalindromeLinkedList {


    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));

        new PalindromeLinkedList().isPalindrome(node);
    }

    //without extra space.
    public boolean isPalindrome(ListNode head) {

        //traverse till middle
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        //fast pointer reaches end and slow pointer reaches middle.
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        fastPointer = head;

        ListNode reversedSlowPointer = reverse(slowPointer);

        while (reversedSlowPointer != null) {

            if (reversedSlowPointer.val != fastPointer.val) return false;

            reversedSlowPointer = reversedSlowPointer.next;
            fastPointer = fastPointer.next;
        }


        return true;

    }

    private ListNode reverse(ListNode midNode) {

        ListNode previous = null;

        while (midNode != null) {
            ListNode nextNode = midNode.next;
            midNode.next = previous;

            previous = midNode;
            midNode = nextNode;
        }

        return previous;
    }
}

