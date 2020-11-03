package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class InsertionSortLinkedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(8, new ListNode(2, new ListNode(4, new ListNode(1, new ListNode(3)))));
        new InsertionSortLinkedList().insertionSortList(l1);
    }

    public ListNode insertionSortList(ListNode head) {
        List<Integer> list = new ArrayList<>();

        ListNode traverse = head;

        while (traverse != null) {
            list.add(traverse.val);
            traverse = traverse.next;
        }
        // 8 2 4 1 3
        // 2 8 4 1 3
        // 2 4 8 1 3
        for (int i = 1; i < list.size(); i++) {

            int current = list.get(i);
            int counter = i - 1;

            while (counter >= 0 && current < list.get(counter)) {
                int temp = list.get(counter);
                list.set(counter + 1, temp);
                counter--;
            }
            list.set(counter + 1, current);

        }

        ListNode result = new ListNode(-1000);
        ListNode traverseResult = result;
        for (int i = 0; i < list.size(); i++) {
            traverseResult.next = new ListNode(list.get(i));
            traverseResult = traverseResult.next;
        }

        return result.next;
    }
}
