package com.hackerrank.linkedlist;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class MergeSortedLinkedList {

    private static final Scanner scanner = new Scanner(System.in);

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        SinglyLinkedListNode headTemp1 = head1;
        SinglyLinkedListNode headTemp2 = head2;
        SinglyLinkedListNode prev = null;
        while (headTemp1 != null) {
            while (headTemp2 != null) {
                if (headTemp1.data < headTemp2.data) {
                    System.out.println("=============");
                    headTemp1.next = headTemp2;
                    prev.next = headTemp1;
                }
                prev = headTemp2;
                headTemp2 = headTemp2.next;

            }
            headTemp1 = headTemp1.next;
            headTemp2 = head2;
        }
        return headTemp1;
    }

    static SinglyLinkedListNode MergeLists(SinglyLinkedListNode currA, SinglyLinkedListNode currB) {
        if (currA == null) {
            return currB;
        } else if (currB == null) {
            return currA;
        }

        /* Find new head pointer */
        SinglyLinkedListNode head = null;
        if (currA.data < currB.data) {
            head = currA;
            currA = currA.next;
        } else {
            head = currB;
            currB = currB.next;
        }

        /* Build rest of list */
        SinglyLinkedListNode n = head;
        while (currA != null && currB != null) {
            if (currA.data < currB.data) {
                n.next = currA;
                currA = currA.next;
            } else {
                n.next = currB;
                currB = currB.next;
            }
            n = n.next;
        }

        /* Attach the remaining elements */
        if (currA == null) {
            n.next = currB;
        } else {
            n.next = currA;
        }

        return head;
    }

    // Complete the mergeLists function below.

    public static void main(String[] args) throws IOException {

        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int testsItr = 0; testsItr < tests; testsItr++) {
            SinglyLinkedList llist1 = new SinglyLinkedList();

            int llist1Count = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llist1Count; i++) {
                int llist1Item = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist1.insertNode(llist1Item);
            }

            SinglyLinkedList llist2 = new SinglyLinkedList();

            int llist2Count = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llist2Count; i++) {
                int llist2Item = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist2.insertNode(llist2Item);
            }

            //SinglyLinkedListNode llist3 = mergeLists(llist1.head, llist2.head);

            SinglyLinkedListNode llist3 = MergeLists(llist1.head, llist2.head);

        }


        scanner.close();
    }

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
