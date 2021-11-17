package com.datastructure_studyplan_leetcode;

import com.leetcode.ListNode;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow)
                return true;
        }

        return false;
    }
}
