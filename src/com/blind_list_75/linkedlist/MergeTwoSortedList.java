package com.blind_list_75.linkedlist;

public class MergeTwoSortedList {

    public static void main(String[] args) {
        MergeTwoSortedList mergeTwoSortedList = new MergeTwoSortedList();
        mergeTwoSortedList.mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(4))),
                new ListNode(1, new ListNode(3, new ListNode(4))));
    }

    public ListNode mergeTwoLists(ListNode t1, ListNode t2) {

        ListNode dummy = new ListNode(-100);
        ListNode tDummy = dummy;


        while (t1 != null && t2 != null) {

            if (t1.val < t2.val) {
                tDummy.next = t1;
                tDummy = tDummy.next;
                t1 = t1.next;
            } else {
                tDummy.next = t2;
                tDummy = tDummy.next;
                t2 = t2.next;
            }
        }

        while (t1 != null) {
            tDummy.next = t1;
            tDummy = tDummy.next;
            t1 = t1.next;
        }
        while (t2 != null) {
            tDummy.next = t2;
            tDummy = tDummy.next;
            t2 = t2.next;
        }

        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
