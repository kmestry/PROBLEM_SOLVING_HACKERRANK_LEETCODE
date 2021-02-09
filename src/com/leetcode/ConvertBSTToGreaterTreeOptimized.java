package com.leetcode;

public class ConvertBSTToGreaterTreeOptimized {

    //reverse inorder traversal
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {

        inOrder(root);
        return root;

    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.right);

        sum += root.val;
        root.val = sum;

        inOrder(root.left);
    }
}
