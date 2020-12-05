package com.leetcode;

public class IncreasingOrderSearchTreeOptimized {

    TreeNode current;

    public static void main(String[] args) {

        TreeNode node = new TreeNode(5, new TreeNode(1), new TreeNode(7));
        new IncreasingOrderSearchTreeOptimized().increasingBST(node);
    }

    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummyRoot = new TreeNode(0);
        current = dummyRoot;
        inorder(root);
        return dummyRoot.right;
    }

    private void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        root.left = null;
        current.right = root;
        current = current.right;

        inorder(root.right);
    }
}
