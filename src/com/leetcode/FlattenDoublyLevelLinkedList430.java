package com.leetcode;


import java.util.ArrayDeque;
import java.util.Deque;

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;


}
//1 -> 2 -> 3 ->-<-7


public class FlattenDoublyLevelLinkedList430 {

    public Node flatten(Node head) {

        Node traversalNode = head;

        Deque<Node> nodeQueue = new ArrayDeque<>();

        while (traversalNode != null) {

            System.out.println("traversalNode val " + traversalNode.val);
            if (traversalNode.child != null) {

                Node temp = traversalNode.next;
                //System.out.println("temp val"+temp.val);

                //temp.prev = null;
                if (temp != null)
                    nodeQueue.addFirst(temp);
                System.out.println("nodeQueue = " + nodeQueue.size());
                System.out.println("nodeQueue = " + nodeQueue.peek());
                traversalNode.next = traversalNode.child;
                traversalNode.child.prev = traversalNode;
                traversalNode.child = null;

            }
            traversalNode = traversalNode.next;


        }
        while (!nodeQueue.isEmpty()) {
            Node nodeTraverse = head;
            while (nodeTraverse.next != null) {
                nodeTraverse = nodeTraverse.next;
            }
            Node nodeToTail = nodeQueue.pop();
            nodeTraverse.next = nodeToTail;
            nodeToTail.prev = nodeTraverse;
        }

        Node checkNode = head;
        while (checkNode != null) {
            System.out.println("head.val = " + checkNode.val);
            System.out.println("head.val = " + checkNode);
            System.out.println("head.prev = " + checkNode.prev);
            System.out.println("head.next = " + checkNode.next);
            System.out.println("head.child = " + checkNode.child);
            checkNode = checkNode.next;

        }

        return head;

    }
}
