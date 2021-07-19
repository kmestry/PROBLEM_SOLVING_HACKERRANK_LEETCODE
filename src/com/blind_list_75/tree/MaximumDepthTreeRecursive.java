package com.blind_list_75.tree;

public class MaximumDepthTreeRecursive {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        MaximumDepthTreeRecursive maximumDepthTreeRecursive = new MaximumDepthTreeRecursive();
        maximumDepthTreeRecursive.maxDepth(treeNode);
    }
    // 1

    //   2    3
    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1 + Math.max(left, right);

    }
}
