package com.leetcode;

public class PathSumPractise {


    public boolean hasPathSum(TreeNode root, int sum) {

        return pathSumHelper(root, sum, 0);

    }


    public boolean pathSumHelper(TreeNode root, int sum, int runningSum) {


        if (root == null) return false;
        runningSum += root.val;

        if (root.left == null && root.right == null) {
            if (runningSum == sum)
                return true;
        }


        return pathSumHelper(root.left, sum, runningSum) ||
                pathSumHelper(root.right, sum, runningSum);

    }

}
