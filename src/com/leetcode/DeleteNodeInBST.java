package com.leetcode;

public class DeleteNodeInBST {


    //BST inorder traversal gives sorted List.
    // maximum in BST won't have right child.
    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) return null;

        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left != null && root.right != null) {
                int maxVal = findMax(root.left);
                root.val = maxVal;
                root.left = deleteNode(root.left, maxVal);
                return root;
            } else if (root.left != null) {
                return root.left;
            } else if (root.right != null) {
                return root.right;
            } else {
                return null;
            }
        }

        return root;

    }

    //maximum in BST will always be Right most node.
    // maximum in BST won't have right child.
    private int findMax(TreeNode root) {
        int max = Integer.MIN_VALUE;
        while (root != null) {
            max = root.val;
            root = root.right;
        }
        return max;
    }
}
