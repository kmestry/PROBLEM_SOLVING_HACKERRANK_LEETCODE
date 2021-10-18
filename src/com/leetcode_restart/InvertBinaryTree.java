package com.leetcode_restart;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {


        helper(root);
        return root;
    }

    private TreeNode helper(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);

        root.left = right;
        root.right = left;

        return root;

    }
}
