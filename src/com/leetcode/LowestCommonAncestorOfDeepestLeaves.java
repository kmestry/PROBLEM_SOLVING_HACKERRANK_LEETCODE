package com.leetcode;

public class LowestCommonAncestorOfDeepestLeaves {

    public TreeNode lcaDeepestLeaves(TreeNode root) {

        if (root == null) {
            return null;
        }
        int lDepth = maxDepth(root.left);
        int rDepth = maxDepth(root.right);

        if (lDepth == rDepth) {
            return root;
        } else if (lDepth > rDepth) {
            return lcaDeepestLeaves(root.left);
        } else {
            return lcaDeepestLeaves(root.right);
        }


    }

    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        return 1 + Math.max(left, right);
    }
}
