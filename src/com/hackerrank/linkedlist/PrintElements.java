package com.hackerrank.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PrintElements {

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static void printLinkedList(SinglyLinkedListNode head) {

        if (head == null) {
            return;
        }
        while (head != null) {

            System.out.println(head.data);
            head = head.next;
        }


    }

    static void reversePrint(SinglyLinkedListNode head) {
        Stack stack = new Stack();
        SinglyLinkedListNode singlyLinkedListNode = head;
        while (singlyLinkedListNode != null) {
            {
                stack.push(singlyLinkedListNode.data);
                singlyLinkedListNode = singlyLinkedListNode.next;
            }
        }
        SinglyLinkedListNode node;
        SinglyLinkedListNode reversedLinkListHead = null;
        SinglyLinkedListNode pointerHead = null;
        while (!stack.isEmpty()) {
            node = new SinglyLinkedListNode((Integer) stack.pop());

            if (reversedLinkListHead == null) {
                reversedLinkListHead = node;
                pointerHead = reversedLinkListHead;
            } else {
                while (pointerHead.next != null) {
                    pointerHead = pointerHead.next;
                }
                pointerHead.next = node;
            }
        }

    }

    static SinglyLinkedListNode revereLinkedList(SinglyLinkedListNode head) {
        if (head != null) {
            SinglyLinkedListNode prev, current, next;
            prev = null;
            current = head;
            while (current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            head = prev;
        }
        return head;
    }

    public static void main(String[] args) {
        SinglyLinkedList llist = new SinglyLinkedList();
        llist.insertNode(1);
        llist.insertNode(2);
        llist.insertNode(3);
        llist.insertNode(4);
        //llist.insertNode(30);
        // llist.insertNode(40);

        SinglyLinkedList llist1 = new SinglyLinkedList();
        llist1.insertNode(1);
        llist1.insertNode(2);
        llist1.insertNode(3);
        llist1.insertNode(4);
        // llist1.insertNode(30);
        //llist1.insertNode(40);

       /* printLinkedList(llist.head);
        reversePrint(llist.head);*/
        // revereLinkedList(llist.head);

        CompareListss(llist.head, llist1.head);

    }

    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();

        if (head1.next == null && head2.next == null && head1.data == head1.data) {
            return true;
        }

        while (head1 != null) {
            firstList.add(head1.data);
            head1 = head1.next;
        }
        while (head2 != null) {
            secondList.add(head2.data);
            head2 = head2.next;
        }

        if (firstList.size() != secondList.size()) {
            return false;
        }

        for (int i = 0; i < firstList.size(); i++) {
            if (firstList.get(i).intValue() != secondList.get(i).intValue()) {
                return false;
            }
        }
        return true;

    }

    static int CompareListss(SinglyLinkedListNode headA, SinglyLinkedListNode headB) {
        while (headA != null && headB != null && headA.data == headB.data) {
            headA = headA.next;
            headB = headB.next;
        }
        return (headA == headB) ? 1 : 0;

    }

    // Complete the printLinkedList function below.

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }
}
