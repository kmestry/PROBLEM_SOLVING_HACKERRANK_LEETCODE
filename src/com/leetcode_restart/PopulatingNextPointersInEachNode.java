package com.leetcode_restart;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextPointersInEachNode {

    public Node connect(Node root) {

        if (root == null) return root;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            Node prev = null;
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                node.next = prev;
                if (node.right != null) {
                    queue.offer(node.right);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                prev = node;
            }

        }

        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
