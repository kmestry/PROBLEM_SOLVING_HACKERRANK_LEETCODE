package com.leetcode;

public class PathSum3 {
    int counter = 0;

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3, new TreeNode(9, null, new TreeNode(26)), new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)));
        int value = new PathSum3().pathSum(treeNode, 35);
        System.out.println("value = " + value);
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;

        pathSumHelper(root, sum, 0);
        pathSum(root.left, sum);
        pathSum(root.right, sum);

        return counter;

    }

    void pathSumHelper(TreeNode root, int sum, int currentSum) {
        if (root == null) {
            return;
        }
        currentSum += root.val;
        if (currentSum == sum) {
            counter++;
        }
        pathSumHelper(root.left, sum, currentSum);
        pathSumHelper(root.right, sum, currentSum);
    }

}
