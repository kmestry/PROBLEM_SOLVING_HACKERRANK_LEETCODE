package com.leetcode;

public class LinkedListCycle2 {


    public ListNode detectCycle(ListNode head) {

        if (head == null) return null;
        ListNode tempHead = head;
        ListNode slow = head;
        ListNode fast = head;


        //INCREMENT FAST 2x times SLOW .
        while (fast != null && fast.next != null) {

            slow = slow.next;       //this is the x
            fast = fast.next.next;  // this is the 2x
            if (fast == slow) break;
        }
        if (fast == null || fast.next == null)
            return null;  // no cycle detected as we reached to tail which points to null.. return null


        //if cycle present; start the tempHead which points to head of original list, and slow which is the pointer which tells that there
        //is cycle from the above while loop.
        //THIS TIME INCREMENT ONLY ONCE.
        while (tempHead != null && slow != null) {

            if (tempHead == slow) return slow;

            tempHead = tempHead.next;
            slow = slow.next;
        }
        return null;
    }
}
