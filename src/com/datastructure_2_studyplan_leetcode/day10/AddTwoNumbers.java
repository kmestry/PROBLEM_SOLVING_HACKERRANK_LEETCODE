package com.datastructure_2_studyplan_leetcode.day10;

import com.leetcode.ListNode;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l11 = new ListNode(4);
        ListNode l12 = new ListNode(3);
        l11.next = l12;
        l1.next = l11;

        ListNode l2 = new ListNode(5);
        ListNode l21 = new ListNode(6);
        ListNode l22 = new ListNode(4);

        l21.next = l22;
        l2.next = l21;

        addTwoNumbersOptimized(l1, l2);
    }

    public static ListNode addTwoNumbersOptimized(ListNode l1, ListNode l2) {


        ListNode result = new ListNode(-10);
        ListNode trv = result;
        int carry = 0;
        while (l1 != null && l2 != null) {

            int val = l1.val + l2.val + carry;

            trv.next = new ListNode(val % 10);
            carry = val / 10;
            l1 = l1.next;
            l2 = l2.next;
            trv = trv.next;
        }

        while (l1 != null) {
            int val = l1.val + carry;
            trv.next = new ListNode(val % 10);
            carry = val / 10;
            l1 = l1.next;
            trv = trv.next;
        }

        while (l2 != null) {
            int val = l2.val + carry;
            trv.next = new ListNode(val % 10);
            carry = val / 10;
            l2 = l2.next;
            trv = trv.next;

        }

        if (carry != 0) {
            trv.next = new ListNode(carry);
        }
        return result.next;
    }
}

