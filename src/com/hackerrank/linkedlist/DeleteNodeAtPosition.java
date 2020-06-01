package com.hackerrank.linkedlist;

import java.io.IOException;
import java.util.Scanner;

public class DeleteNodeAtPosition {

    private static final Scanner scanner = new Scanner(System.in);

    public static void printSinglyLinkedList(SinglyLinkedListNode node) throws IOException {
        while (node != null) {
            System.out.print(node.data + " ");

            node = node.next;

            if (node != null) {
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
     *    20->6->2->19->7->4->15->9     delete at position 3
     *
     *
     *         4

                11   ---- 0

                9    ------ 1

                2   -------- 2

                9   ------- 3

                1
     */
    static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
        SinglyLinkedListNode dummyHead = head;
        SinglyLinkedListNode node = null;

        if (position == 0) {
            head = head.next;
            return head;
        }
        for (int i = 0; i <= position - 1; i++) {
            node = dummyHead.next;
            dummyHead = node;
        }
        SinglyLinkedListNode nodeAtPositionNextAddress = node.next;
        SinglyLinkedListNode dummyHeadPrevious = head;
        SinglyLinkedListNode nodePrevious = null;

        if (position - 1 == 0) {
            nodePrevious = dummyHeadPrevious;
            dummyHeadPrevious = nodePrevious;
        } else {
            for (int i = 0; i < position - 1; i++) {
                nodePrevious = dummyHeadPrevious.next;
                dummyHeadPrevious = nodePrevious;

            }
        }
        nodePrevious.next = nodeAtPositionNextAddress;
        return head;


    }

    // Complete the deleteNode function below.

    public static void main(String[] args) throws IOException {

        SinglyLinkedList llist = new SinglyLinkedList();

        int llistCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < llistCount; i++) {
            int llistItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            llist.insertNode(llistItem);
        }

        int position = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        SinglyLinkedListNode llist1 = deleteNode(llist.head, position);

        printSinglyLinkedList(llist1);


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

