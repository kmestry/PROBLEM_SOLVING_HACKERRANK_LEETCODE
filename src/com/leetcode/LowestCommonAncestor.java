package com.leetcode;

public class LowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node3 = new TreeNode(3, null, node5);
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), node3);

        new LowestCommonAncestor().lowestCommonAncestor(treeNode, node3, node5);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) return null;

        if (root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null) return null;

        if (left != null && right != null) return root;

        return left != null ? left : right;
    }
}
