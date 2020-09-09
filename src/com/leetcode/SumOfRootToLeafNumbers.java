package com.leetcode;

public class SumOfRootToLeafNumbers {

    int result = 0;

    public int sumNumbers(TreeNode root) {


        helper(root, 0);
        return result;

    }


    private void helper(TreeNode root, int sum) {

        if (root == null) return;

        sum *= 10;
        sum += root.val;

        if (root.left == null && root.right == null) result += sum;

        helper(root.left, sum);
        helper(root.right, sum);


    }
}
