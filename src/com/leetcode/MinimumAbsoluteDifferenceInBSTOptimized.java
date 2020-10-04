package com.leetcode;

public class MinimumAbsoluteDifferenceInBSTOptimized {

    int min = Integer.MAX_VALUE;
    Integer prev = null;

    public int getMinimumDifference(TreeNode root) {

        helper(root);
        return min;


    }

    private void helper(TreeNode root) {

        if (root == null) return;

        helper(root.left);

        if (prev != null) {
            min = Math.min(min, root.val - prev);
        }

        prev = root.val;

        helper(root.right);


    }

}
