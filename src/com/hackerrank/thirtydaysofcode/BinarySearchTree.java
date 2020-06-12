package com.hackerrank.thirtydaysofcode;

import java.util.Scanner;

class NodeBinary {
    NodeBinary left, right;
    int data;

    NodeBinary(int data) {
        this.data = data;
        left = right = null;
    }
}

class BinarySearchTree {

    public static int getHeight(NodeBinary root) {
        //Write your code here
        NodeBinary traverseNode = root;
        if (traverseNode == null)
            return -1;
        int leftHeight = getHeight(traverseNode.left);
        int rightHeight = getHeight(traverseNode.right);

        return 1 + Math.max(leftHeight, rightHeight);

    }

    public static NodeBinary insert(NodeBinary root, int data) {
        if (root == null) {
            return new NodeBinary(data);
        } else {
            NodeBinary cur;
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
        NodeBinary root = null;
        while (T-- > 0) {
            int data = sc.nextInt();
            root = insert(root, data);
        }
        int height = getHeight(root);
        System.out.println(height);
    }
}
