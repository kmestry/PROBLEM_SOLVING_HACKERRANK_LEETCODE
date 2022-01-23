package com.datastructure_2_studyplan_leetcode.day11;

import com.leetcode.ListNode;

public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lengthA = length(headA);
        int lengthB = length(headB);

        while (lengthA > lengthB) {
            headA = headA.next;
            lengthA--;
        }

        while (lengthB > lengthA) {
            headB = headB.next;
            lengthB--;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;

    }

    private int length(ListNode node) {

        int length = 0;

        while (node != null) {
            node = node.next;
            length++;
        }

        return length;
    }
}
