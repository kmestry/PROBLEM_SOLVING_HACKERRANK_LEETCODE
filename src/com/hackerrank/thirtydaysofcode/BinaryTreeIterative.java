package com.hackerrank.thirtydaysofcode;

// An iterative java program to find height of binary tree

import java.util.LinkedList;
import java.util.Queue;

// A binary tree node
class NodeGFG {
    int data;
    NodeGFG left, right;

    NodeGFG(int item) {
        data = item;
        left = right;
    }
}

class BinaryTree {
    NodeGFG root;

    // Driver program to test above functions
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Let us create a binary tree shown in above diagram
        tree.root = new NodeGFG(1);
        tree.root.left = new NodeGFG(2);
        tree.root.right = new NodeGFG(3);
        tree.root.left.left = new NodeGFG(4);
        tree.root.left.right = new NodeGFG(5);
        System.out.println("Height of tree is " + tree.treeHeight(tree.root));
    }

    // Iterative method to find height of Binary Tree
    int treeHeight(NodeGFG node) {
        // Base Case
        if (node == null)
            return 0;

        // Create an empty queue for level order tarversal
        Queue<NodeGFG> q = new LinkedList();

        // Enqueue Root and initialize height
        q.add(node);
        int height = 0;

        while (1 == 1) {
            // nodeCount (queue size) indicates number of nodes
            // at current lelvel.
            int nodeCount = q.size();
            if (nodeCount == 0)
                return height;
            height++;

            // Dequeue all nodes of current level and Enqueue all
            // nodes of next level
            while (nodeCount > 0) {
                NodeGFG newnode = q.peek();
                q.remove();
                if (newnode.left != null)
                    q.add(newnode.left);
                if (newnode.right != null)
                    q.add(newnode.right);
                nodeCount--;
            }
        }
    }
}

// This code has been contributed by Mayank Jaiswal
