package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeNovChallengeOptimized {

    public static void main(String[] args) {
        PopulatingNextRightPointersInEachNodeNovChallengeOptimized.Node node =
                new PopulatingNextRightPointersInEachNodeNovChallengeOptimized.Node(1, new PopulatingNextRightPointersInEachNodeNovChallengeOptimized.Node(2, new PopulatingNextRightPointersInEachNodeNovChallengeOptimized.Node(4), new PopulatingNextRightPointersInEachNodeNovChallengeOptimized.Node(5), null), new PopulatingNextRightPointersInEachNodeNovChallengeOptimized.Node(3, new PopulatingNextRightPointersInEachNodeNovChallengeOptimized.Node(6), new PopulatingNextRightPointersInEachNodeNovChallengeOptimized.Node(7), null), null);

        new PopulatingNextRightPointersInEachNodeNovChallengeOptimized().connect(node);
    }

    public Node connect(Node root) {

        if (root == null) return root;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node prev = null;
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                Node node = queue.poll();
                node.next = prev;
                prev = node;
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
