package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRightPointers {

    public static void main(String[] args) {

        Node1 node = new Node1(1, new Node1(2, new Node1(4), new Node1(5), null), new Node1(3, new Node1(6), new Node1(7), null), null);
        new PopulateNextRightPointers().connect(node);

    }

    public Node1 connect(Node1 root) {

        if (root == null) return null;

        Queue<Node1> queue = new LinkedList<>();
        queue.offer(root);


        while (!queue.isEmpty()) {

            int size = queue.size();
            Node1 prev = null;
            for (int i = 0; i < size; i++) {

                Node1 node = queue.poll();
                if (i == 0) prev = node;
                if (i > 0) {
                    node.next = prev;
                    prev = node;
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
            }

        }

        return root;

    }
}
