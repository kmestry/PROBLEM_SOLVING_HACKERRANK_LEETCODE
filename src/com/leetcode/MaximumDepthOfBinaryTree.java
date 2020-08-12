package com.leetcode;

public class MaximumDepthOfBinaryTree {


    int leftHeight = 0;
    int rightHeight = 0;

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3, new TreeNode(9, new TreeNode(21, new TreeNode(1), null), new TreeNode(35)), new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)));

        int result = new MaximumDepthOfBinaryTree().maxDepth(treeNode);
        System.out.println("result = " + result);
    }

    public int maxDepth(TreeNode root) {

        if (root == null)
            return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;


    }
}
