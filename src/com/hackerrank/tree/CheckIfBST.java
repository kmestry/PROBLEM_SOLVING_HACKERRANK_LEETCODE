package com.hackerrank.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Java program to check if a given tree is BST.
class CheckIfBST {

    static boolean checkBST(Node root) {
        List<Integer> testIfBinaryList = new ArrayList<>();
        if (root != null) {
            testIfBinaryList.add(root.left != null ? root.left.data : Integer.MIN_VALUE);
            testIfBinaryList.add(root.data);
            testIfBinaryList.add(root.right != null ? root.right.data : Integer.MAX_VALUE);
            //boolean isListSorted = checkIfListIsSorted(testIfBinaryList);
            boolean isListSorted;
            isListSorted = testIfBinaryList.get(0) <= testIfBinaryList.get(1) && testIfBinaryList.get(1) <= testIfBinaryList.get(2);

            if (isListSorted) {
                checkBST(root.left);
                checkBST(root.right);
            } else {
                return false;
            }

        }

        return true;
    }

    static boolean checkBSTInOrderApproach(Node root) {
        Stack<Integer> stackOfNodes = new Stack<>();
        Stack nodesStack = inOrderTraversalOfTreeStack(root, stackOfNodes);

        int temp = Integer.MAX_VALUE;
        while (!nodesStack.isEmpty()) {
            Integer value = (Integer) nodesStack.pop();
            if (value < temp) {
                temp = value;
                continue;
            } else {
                return false;

            }

        }

        return true;

    }

    static Stack inOrderTraversalOfTreeStack(Node root, Stack nodes) {

        if (root != null) {
            inOrderTraversalOfTreeStack(root.left, nodes);
            nodes.push(root.data);
            inOrderTraversalOfTreeStack(root.right, nodes);

        }
        return nodes;
    }

    /* Driver code*/
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(15);
        root.left.left = new Node(10);
        root.left.right = new Node(4);

       /* if (checkBST(root))
            System.out.print("Is BST");
        else
            System.out.print("Not a BST");*/
        if (checkBSTInOrderApproach(root))
            System.out.print("Is BST");
        else
            System.out.print("Not a BST");

    }

    /* A binary tree node has data, pointer to
    left child and a pointer to right child */
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
}

// This code is contributed by PrinciRaj1992

