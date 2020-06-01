package com.hackerrank.linkedlist;

import java.io.IOException;
import java.util.Scanner;

public class InsertElementAtTail {


    private static final Scanner scanner = new Scanner(System.in);

    public static void printSinglyLinkedList(SinglyLinkedListNode node) throws IOException {
        while (node != null) {
            //bufferedWriter.write(String.valueOf(node.data));

            System.out.println(node.data);
            node = node.next;

            if (node != null) {
                // bufferedWriter.write(sep);
                System.out.println();
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
    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(data);
        if (head == null) {

            return node;
        }
        SinglyLinkedListNode headTemp = head;
        while (headTemp.next != null) {
            headTemp = headTemp.next;

        }
        headTemp.next = node;


        return head;
    }

    // Complete the insertNodeAtTail function below.

    public static void main(String[] args) throws IOException {
        SinglyLinkedList llist = new SinglyLinkedList();

        SinglyLinkedListNode llist_head = insertNodeAtTail(llist.head, 10);
        llist.head = llist_head;
        SinglyLinkedListNode llist_head1 = insertNodeAtTail(llist.head, 20);
        llist.head = llist_head1;
        SinglyLinkedListNode llist_head2 = insertNodeAtTail(llist.head, 30);

        printSinglyLinkedList(llist_head2);

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

        public SinglyLinkedList() {
            this.head = null;
        }


    }
}


