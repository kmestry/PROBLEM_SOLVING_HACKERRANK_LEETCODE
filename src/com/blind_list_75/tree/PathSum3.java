package com.blind_list_75.tree;

public class PathSum3 {


    int count = 0;

    public int pathSum(TreeNode root, int targetSum) {

        if (root == null) return 0;

        helper(root, targetSum, 0);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return count;
    }

    private void helper(TreeNode root, int target, int sum) {

        if (root == null) return;

        sum += root.val;

        if (sum == target) {
            count++;
        }

        helper(root.left, target, sum);
        helper(root.right, target, sum);

    }
}
