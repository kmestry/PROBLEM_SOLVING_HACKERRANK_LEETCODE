package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, new ListNode(8));
        new SortList().sortList(l1);
    }

    // 2 -- > 1 -- > 3
    public ListNode sortList(ListNode head) {

        ListNode resultNode = new ListNode();

        ListNode traverseResult = resultNode;

        List<Integer> list = new ArrayList<>();

        ListNode traverseHead = head;

        while (traverseHead != null) {

            list.add(traverseHead.val);
            traverseHead = traverseHead.next;

        }

        Collections.sort(list);

        for (Integer integer : list) {
            traverseResult.next = new ListNode(integer);
            traverseResult = traverseResult.next;
        }

        return resultNode.next;

    }
}
