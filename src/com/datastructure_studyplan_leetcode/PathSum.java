package com.datastructure_studyplan_leetcode;

public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {

        return helper(root, targetSum, 0);
    }

    private boolean helper(TreeNode root, int target, int sum) {

        if (root == null) return false;

        if (root.left == null && root.right == null && target == sum + root.val) {
            return true;
        }

        return helper(root.left, target, sum + root.val) || helper(root.right, target, sum + root.val);

    }
}
