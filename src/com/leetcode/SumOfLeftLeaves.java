package com.leetcode;

public class SumOfLeftLeaves {

    int sum = 0;

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3, new TreeNode(9, null, null), new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)));

        int sum = new SumOfLeftLeaves().sumOfLeftLeaves(treeNode);
        System.out.println("sum = " + sum);
    }

    public int sumOfLeftLeaves(TreeNode root) {

        if (root == null) return sum;

        if (root.left != null && root.left.left == null && root.left.right == null) sum += root.left.val;


        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);


        return sum;
    }
}
