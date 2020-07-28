package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddTwoNumbers {


    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, new ListNode(8));

        ListNode l2 = new ListNode(1);


      /*  ListNode l1 = new ListNode(2);
        ListNode l11 = new ListNode(4);
        ListNode l12 = new ListNode(3);
        l11.next = l12;
        l1.next = l11;

        ListNode l2 = new ListNode(5);
        ListNode l21 = new ListNode(6);
        ListNode l22 = new ListNode(4);

        l21.next = l22;
        l2.next = l21;*/

        addTwoNumbersOptimized(l1, l2);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> firstLinkedList = new ArrayList<>();
        List<Integer> secondLinkedList = new ArrayList<>();
        List<ListNode> resultList = new ArrayList<>();

        ListNode traverseNode1 = l1;
        ListNode traverseNode2 = l2;

        while (traverseNode1 != null) {
            firstLinkedList.add(traverseNode1.val);
            traverseNode1 = traverseNode1.next;

        }
        while (traverseNode2 != null) {
            secondLinkedList.add(traverseNode2.val);
            traverseNode2 = traverseNode2.next;

        }
        int carry = 0;

        Collections.reverse(firstLinkedList);
        Collections.reverse(secondLinkedList);


        boolean isFirstListBigger = false;
        isFirstListBigger = secondLinkedList.size() <= firstLinkedList.size();

        int size = Math.abs(firstLinkedList.size() - secondLinkedList.size());

        if (isFirstListBigger) {

            for (int i = 0; i < size; i++) {
                secondLinkedList.add(0, 0);
            }
        } else {
            for (int i = 0; i < size; i++) {
                firstLinkedList.add(0, 0);
            }
        }


        for (int i = secondLinkedList.size() - 1; i >= 0; i--) {


            int value = secondLinkedList.get(i) + firstLinkedList.get(i) + carry;
            if (value > 9) {
                int remainder = value % 10;
                carry = value / 10;
                resultList.add(new ListNode(remainder));
            } else {
                resultList.add(new ListNode(value));
                carry = 0;
            }

        }
        if (carry != 0) {
            resultList.add(new ListNode(carry));
        }

        for (int i = 0; i < resultList.size(); i++) {
            if (i == resultList.size() - 1) {
                resultList.get(i).next = null;
            } else {
                resultList.get(i).next = resultList.get(i + 1);
            }
        }

        return resultList.get(0);

    }

    public static ListNode addTwoNumbersOptimized(ListNode l1, ListNode l2) {

        ListNode resultNode = new ListNode(0);
        ListNode resultTraverse = resultNode;
        ListNode traverseNode1 = l1;
        ListNode traverseNode2 = l2;

        int carry = 0;
        while (traverseNode1 != null || traverseNode2 != null) {
            int value1 = traverseNode1 == null ? 0 : traverseNode1.val;
            int value2 = traverseNode2 == null ? 0 : traverseNode2.val;

            int sum = value1 + value2 + carry;
            if (sum > 9) {
                int remainder = (sum) % 10;
                carry = (sum) / 10;
                ListNode node = new ListNode(remainder);
                resultTraverse.next = node;

            } else {
                ListNode node = new ListNode(sum);
                resultTraverse.next = node;
                carry = 0;
            }

            if (traverseNode1 != null) traverseNode1 = traverseNode1.next;
            if (traverseNode2 != null) traverseNode2 = traverseNode2.next;
            resultTraverse = resultTraverse.next;

        }
        if (carry != 0) {
            ListNode node = new ListNode(carry);
            resultTraverse.next = node;
        }

        return resultNode.next;
    }
}
