package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {

    public static void main(String[] args) {

        Node1 node = new Node1(1, new Node1(2, new Node1(4), new Node1(5), null), new Node1(3, new Node1(6), new Node1(7), null), null);
        new PopulatingNextRightPointersInEachNode().connect(node);

    }

    private Node1 connectRecursive(Node1 node) {

        if (node == null) return null;

        helper(node.left, node.right);
        return node;

    }


    private void helper(Node1 node1, Node1 node2) {

        if (node1 == null) return;

        node1.next = node2;
        helper(node1.left, node1.right);
        helper(node2.left, node2.right);
        helper(node1.right, node2.left);


    }

    public Node1 connect(Node1 root) {

        if (root == null)
            return null;

        Queue<Node1> queue = new LinkedList<>();
        queue.offer(root);

        List<Node1> list = new ArrayList<>();
        list.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < list.size() - 1; i++) {
                list.get(i).next = list.get(i + 1);
            }


            for (int i = 0; i < size; i++) {
                Node1 node = queue.poll();
                list.remove(0);

                if (node.left != null) {
                    queue.offer(node.left);
                    list.add(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                    list.add(node.right);
                }

            }

        }

        return root;
    }


    public Node1 connectRecursiveApproach2(Node1 root) {
        if (root == null || root.left == null) return null;
        root.left.next = root.right;
        if (root.next != null) root.right.next = root.next.left;
        connectRecursiveApproach2(root.left);
        connectRecursiveApproach2(root.right);

        return root;
    }
}

class Node1 {
    public int val;
    public Node1 left;
    public Node1 right;
    public Node1 next;

    public Node1() {
    }

    public Node1(int _val) {
        val = _val;
    }

    public Node1(int _val, Node1 _left, Node1 _right, Node1 _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}


