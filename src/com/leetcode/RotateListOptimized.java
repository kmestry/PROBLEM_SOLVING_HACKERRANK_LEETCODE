package com.leetcode;

public class RotateListOptimized {

    public static void main(String[] args) {
        ListNode node = new ListNode(0, new ListNode(1, new ListNode(2)));
        ListNode listNode = new RotateListOptimized().rotateRight(node, 2);
    }

    //1 - 2 - 3 - 4 - 5-null
    // 0 1 2
    // 2 0 1
    // 1 2 0
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) return head;
        int sizeOfList = 0;

        ListNode sizeTraverseHead = head;
        while (sizeTraverseHead != null) {
            sizeTraverseHead = sizeTraverseHead.next;
            sizeOfList++;
        }

        if (k > sizeOfList) {
            k = k % sizeOfList;
        }

        ListNode traverseHead = head;
        ListNode prev = head;

        while (k > 0) {

            while (traverseHead.next != null) {
                prev = traverseHead;
                traverseHead = traverseHead.next;
            }

            prev.next = null;  // as both prev and traverseHead are pointers to head. once we reach this step
            //our head removes one node as we pointing prev.next to null.
            traverseHead.next = head;

            head = traverseHead;//imp step!!. for next iteration we need this step;
            //we are reassigning head to traverseHead which is the new head. and looping.


            k--; // as k will be not be more than size of list we can afford the while loop for k;
            //its far inutitive than other solutions, and we need not remember the tricky solutions in
            //interview.
        }


        return traverseHead;
    }
}
