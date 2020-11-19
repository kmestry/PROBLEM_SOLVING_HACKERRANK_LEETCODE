package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class PopulatingNextRightPointersInEachNodeNovChallenge {

    public static void main(String[] args) {
        Node node = new Node(1, new Node(2, new Node(4), new Node(5), null), new Node(3, new Node(6), new Node(7), null), null);

        new PopulatingNextRightPointersInEachNodeNovChallenge().connect(node);
    }

    public Node connect(Node root) {

        if (root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Node> list = new ArrayList<>();


            for (int i = 0; i < size; i++) {
                Node node = queue.poll();

                list.add(node);
                // System.out.println(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }


            for (int i = 0; i < list.size() - 1; i++) {

                list.get(i).next = list.get(i + 1);

            }
            if (list.size() > 0)
                list.get(list.size() - 1).next = null;

        }

        return root;

    }

    static class Node {
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
    }

}
