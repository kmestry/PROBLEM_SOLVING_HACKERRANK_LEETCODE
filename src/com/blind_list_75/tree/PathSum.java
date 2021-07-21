package com.blind_list_75.tree;

public class PathSum {

    public static void main(String[] args) {
        PathSum pathSum = new PathSum();
        pathSum.hasPathSum(new TreeNode(1, new TreeNode(2), new TreeNode(3)), 5);
    }

    // 1
    //2  3

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return pathSum(root, targetSum, 0);
    }

    private boolean pathSum(TreeNode root, int target, int sum) {

        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && target == sum + root.val) {
            return true;
        }


        return pathSum(root.left, target, sum + root.val) ||
                pathSum(root.right, target, sum + root.val);
    }
}
