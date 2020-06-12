package com.hackerrank.thirtydaysofcode;

import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class LinkedList {

    public static Node insert(Node head, int data) {
        //Complete this method
        Node nodeBinaryToAdd = new Node(data);
        Node pointerHead = head;
        if (head == null) {
            return nodeBinaryToAdd;
        } else {
            while (pointerHead.next != null) {
                pointerHead = pointerHead.next;
            }
            pointerHead.next = nodeBinaryToAdd;
        }
        return head;
    }

    public static void display(Node head) {
        Node start = head;
        while (start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int N = sc.nextInt();

        while (N-- > 0) {
            int ele = sc.nextInt();
            head = insert(head, ele);
        }
        display(head);
        sc.close();
    }
}
