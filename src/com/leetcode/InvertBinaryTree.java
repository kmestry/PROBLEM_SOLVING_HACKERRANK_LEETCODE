package com.leetcode;

public class InvertBinaryTree {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, null, new TreeNode(5, null, null)));
        new InvertBinaryTree().invertTree(treeNode);
    }

    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode nodeLeft = invertTree(root.left);
        TreeNode nodeRight = invertTree(root.right);

        swapNodes(root, nodeLeft, nodeRight);

        return root;

    }

    private void swapNodes(TreeNode root, TreeNode leftNode, TreeNode rightNode) {
        root.left = rightNode;
        root.right = leftNode;

    }
}
