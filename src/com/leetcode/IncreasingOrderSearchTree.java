package com.leetcode;

public class IncreasingOrderSearchTree {

    TreeNode dummy = new TreeNode(-10);
    TreeNode dummyTraversal = dummy;

    public static void main(String[] args) {

        TreeNode node = new TreeNode(5, new TreeNode(1), new TreeNode(7));
        new IncreasingOrderSearchTree().increasingBST(node);
    }

    public TreeNode increasingBST(TreeNode root) {

        inOrder(root);
        return dummy.right;
    }

    private void inOrder(TreeNode root) {

        if (root == null) {
            return;
        }
        inOrder(root.left);

        dummyTraversal.right = new TreeNode(root.val);
        dummyTraversal = dummyTraversal.right;

        inOrder(root.right);


    }
}
