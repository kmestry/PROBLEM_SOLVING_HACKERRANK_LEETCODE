package com.leetcode;

public class ConvertBSTToGreaterTree {

    int total = 0;
    int leftSum = 0;

    public TreeNode convertBST(TreeNode root) {

        inOrderSum(root);
        // System.out.println("==" + total);
        inOrderNewNode(root);

        return root;
    }

    private void inOrderNewNode(TreeNode root) {

        if (root == null) {
            return;
        }

        inOrderNewNode(root.left);
        leftSum += root.val;

        int newVal = total - leftSum;
        root.val = newVal + root.val;

        inOrderNewNode(root.right);
    }


    private void inOrderSum(TreeNode root) {

        if (root == null) {
            return;
        }

        inOrderSum(root.left);
        total += root.val;
        inOrderSum(root.right);

    }
}
