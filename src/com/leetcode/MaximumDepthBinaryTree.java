package com.leetcode;

public class MaximumDepthBinaryTree {

    int maxDepth = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        int res = new MaximumDepthBinaryTree().maxDepth(treeNode);

        System.out.println("res = " + res);
    }

    public int maxDepth(TreeNode root) {

        if (root == null) return 0;

        int left = 0;
        int right = 0;
        left += maxDepth(root.left);
        right += maxDepth(root.right);

        return Math.max(left, right) + 1;

    }


}
