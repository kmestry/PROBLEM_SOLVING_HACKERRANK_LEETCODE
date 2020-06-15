package com.hackerrank.tree;

import java.util.Scanner;


class Solution {

    /*
    class Node
        int data;
        Node left;
        Node right;
    */
    public static int height(Node root) {
        // Write your code here.
        int leftTreeHeight = 0;
        int rightTreeHeight = 0;
        if (root == null) {
            return -1;
        }
        leftTreeHeight = height(root.left);
        rightTreeHeight = height(root.right);
        int heightOfTree = 1 + Math.max(leftTreeHeight, rightTreeHeight);
        return heightOfTree;


    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
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
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }
}
