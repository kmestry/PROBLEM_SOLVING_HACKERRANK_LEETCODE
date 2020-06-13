package com.hackerrank.thirtydaysofcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class NodeBinaryLevelOrder {
    NodeBinaryLevelOrder left, right;
    int data;

    NodeBinaryLevelOrder(int data) {
        this.data = data;
        left = right = null;
    }
}

class Solution {

    static void levelOrder(NodeBinaryLevelOrder root) {
        //Write your code here
        Queue<NodeBinaryLevelOrder> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            NodeBinaryLevelOrder nodeBinaryLevelOrder = queue.poll();

            System.out.print(nodeBinaryLevelOrder.data + " ");
            if (nodeBinaryLevelOrder.left != null) {
                queue.add(nodeBinaryLevelOrder.left);
            }
            if (nodeBinaryLevelOrder.right != null) {
                queue.add(nodeBinaryLevelOrder.right);
            }
        }


    }

    public static NodeBinaryLevelOrder insert(NodeBinaryLevelOrder root, int data) {
        if (root == null) {
            return new NodeBinaryLevelOrder(data);
        } else {
            NodeBinaryLevelOrder cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        NodeBinaryLevelOrder root = null;
        while (T-- > 0) {
            int data = sc.nextInt();
            root = insert(root, data);
        }
        levelOrder(root);
    }
}