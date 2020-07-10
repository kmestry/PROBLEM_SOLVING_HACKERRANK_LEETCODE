package com.leetcode;


import java.util.ArrayDeque;
import java.util.Deque;


//1 -> 2 -> 3 ->-<-7


public class FlattenDoublyLevelLinkedListOptimized430 {

    public Node flatten(Node head) {

        Node traversalNode = head;
        Deque<Node> nodeQueue = new ArrayDeque<>();
        while (traversalNode != null) {

            if (traversalNode.child != null) {
                Node temp = traversalNode.next;
                if (temp != null)
                    nodeQueue.addFirst(temp);
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
        return head;
    }
}
