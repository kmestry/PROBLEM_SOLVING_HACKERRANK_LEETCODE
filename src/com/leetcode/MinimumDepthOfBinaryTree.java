package com.leetcode;

public class MinimumDepthOfBinaryTree {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1, null, new TreeNode(3, null, new TreeNode(5, null, new TreeNode(7))));

        new MinimumDepthOfBinaryTree().minDepth(treeNode);
    }

    public int minDepth(TreeNode root) {

        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;

        int leftDepth = root.left != null ? minDepth(root.left) : Integer.MAX_VALUE;
        int rightDepth = root.right != null ? minDepth(root.right) : Integer.MAX_VALUE;

        return 1 + Math.min(leftDepth, rightDepth);
    }
}
