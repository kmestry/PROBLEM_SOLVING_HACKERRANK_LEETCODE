package com.leetcode_restart;

public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {

        return helper(root, targetSum, 0);
    }

    private boolean helper(TreeNode root, int targetSum, int currSum) {

        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            if (targetSum == currSum + root.val) {
                return true;
            }
        }

        return helper(root.left, targetSum, currSum + root.val) ||
                helper(root.right, targetSum, currSum + root.val);
    }
}
