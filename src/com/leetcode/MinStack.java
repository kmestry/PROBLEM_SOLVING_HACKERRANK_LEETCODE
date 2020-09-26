package com.leetcode;

public class MinStack {


    /**
     * initialize your data structure here.
     * <p>
     * // 1 2 3
     */
    Node head;

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.top();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
        minStack.top();
    }

    public void push(int x) {
        if (head == null) {
            head = new Node(x, x);
        } else {
            head = new Node(x, head, Math.min(x, head.min));
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    class Node {
        int val;
        Node next;
        int min;


        Node(int val, int min) {
            this(val, null, min);
        }

        Node(int val, Node next, int min) {
            this.val = val;
            this.next = next;
            this.min = min;
        }
    }
}
