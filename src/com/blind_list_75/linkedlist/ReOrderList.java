package com.blind_list_75.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class ReOrderList {

    public static void main(String[] args) {
        ReOrderList reOrderList = new ReOrderList();
        reOrderList.reorderList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
    }

    public void reorderList(ListNode head) {
        List<Integer> list = new ArrayList<>();

        ListNode curr = head;

        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }

        int left = 0;
        int right = list.size() - 1;
        System.out.println(list.size());
        System.out.println(list);
        ListNode dummy = new ListNode(-100);
        ListNode t = dummy;
        while (left <= right) {
            t.next = new ListNode(list.get(left));
            t = t.next;
            t.next = new ListNode(list.get(right));
            t = t.next;
            left++;
            right--;
        }


        head = dummy.next;
        System.out.println(head);
    }
}
