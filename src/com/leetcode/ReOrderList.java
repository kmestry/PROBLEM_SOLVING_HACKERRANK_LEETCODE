package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReOrderList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        new ReOrderList().reorderList(node);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public void reorderList(ListNode head) {

        ListNode headTemp = head;
        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }


        int leftPointer = 0;
        int rightPointer = list.size() - 1;
        Queue<Integer> queue = new LinkedList<>();

        while (leftPointer <= rightPointer) {

            if (leftPointer == rightPointer) queue.add(list.get(leftPointer));
            else {
                queue.add(list.get(leftPointer));
                queue.add(list.get(rightPointer));
            }
            leftPointer++;
            rightPointer--;

        }

        ListNode node = new ListNode(0); //first Node. dummy.
        ListNode tempNode = node;
        while (!queue.isEmpty()) {
            int value = queue.poll();
            ListNode newNode = new ListNode(value);
            tempNode.next = newNode;
            tempNode = tempNode.next;

        }


        headTemp.next = node.next;

        ListNode temp = headTemp;


        temp.next = temp.next.next;


    }
}
