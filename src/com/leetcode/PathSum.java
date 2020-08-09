package com.leetcode;

public class PathSum {
    boolean result = false;

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3, new TreeNode(9, null, new TreeNode(26)), new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)));
        boolean value = new PathSum().hasPathSum(treeNode, 38);
    }


    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null)
            return false;

        boolean result = dfsHelper(root, sum, 0);

        return result;
    }

    public boolean dfsHelper(TreeNode treeNode, int sum, int cumulativeSum) {

        if (treeNode != null) {
            cumulativeSum += treeNode.val;
        }

        if (treeNode == null)
            return false;

        if (treeNode.left == null && treeNode.right == null && sum == cumulativeSum) {
            return true;
        }

        return dfsHelper(treeNode.left, sum, cumulativeSum)
                || dfsHelper(treeNode.right, sum, cumulativeSum);


    }
}
