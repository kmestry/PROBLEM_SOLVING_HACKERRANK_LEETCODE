package com.leetcode;

public class SortListOptimized {

    public static void main(String[] args) {
        ListNode node = new ListNode(3, new ListNode(4, new ListNode(2, new ListNode(1))));

        new SortListOptimized().sortList(node);
    }

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);


    }

    private ListNode merge(ListNode left, ListNode right) {

        ListNode dummy = new ListNode(Integer.MIN_VALUE);

        ListNode dummyTraverse = dummy;
        ListNode leftTraverse = left;
        ListNode rightTraverse = right;

        while (leftTraverse != null && rightTraverse != null) {

            if (leftTraverse.val <= rightTraverse.val) {
                dummyTraverse.next = leftTraverse;
                leftTraverse = leftTraverse.next;
            } else {
                dummyTraverse.next = rightTraverse;
                rightTraverse = rightTraverse.next;
            }
            dummyTraverse = dummyTraverse.next;
        }

        if (leftTraverse != null) {
            dummyTraverse.next = leftTraverse;
        } else if (rightTraverse != null) {
            dummyTraverse.next = rightTraverse;
        }

        return dummy.next;

    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;  // slow is reference to head.
        // when we point slow.next to null, head also points to null.
        //so mid will have right half
        //head will have left half.
        slow.next = null;

        return mid;
    }
}
