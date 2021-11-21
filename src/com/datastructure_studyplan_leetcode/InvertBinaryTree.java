package com.datastructure_studyplan_leetcode;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {

        if (root == null) return null;

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = invertTree(right);
        root.right = invertTree(left);

        return root;
    }
}
