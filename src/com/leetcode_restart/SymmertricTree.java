package com.leetcode_restart;

public class SymmertricTree {

    public boolean isSymmetric(TreeNode root) {

        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode rootL, TreeNode rootR) {

        if (rootL == null && rootR == null) {
            return true;
        }
        if (rootL == null && rootR != null) {
            return false;
        }
        if (rootR == null && rootL != null) {
            return false;
        }

        if (rootL.val != rootR.val) {
            return false;
        }

        return helper(rootL.left, rootR.right) && helper(rootL.right, rootR.left);
    }
}
