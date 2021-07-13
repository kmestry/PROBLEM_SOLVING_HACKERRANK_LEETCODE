package com.blind_list_75.linkedlist;

public class ReOrderListPractise {

    public static void main(String[] args) {
        ReOrderListPractise reOrderList = new ReOrderListPractise();
        reOrderList.reorderList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
    }

    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }
        ListNode firstHalfList = head;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            firstHalfList = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        firstHalfList.next = null;

        ListNode firstHalf = head;
        ListNode secondHalf = reverse(slow);
        merge(firstHalf, secondHalf);

    }

    private void merge(ListNode l1, ListNode l2) {
        while (l2 != null) {
            ListNode temp = l1.next;
            l1.next = l2;
            l1 = l2;
            l2 = temp;
        }
    }

    private ListNode reverse(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode reversed = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return reversed;
    }

}
