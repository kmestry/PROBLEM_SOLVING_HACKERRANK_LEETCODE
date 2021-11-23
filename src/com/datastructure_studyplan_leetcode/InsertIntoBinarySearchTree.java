package com.datastructure_studyplan_leetcode;

public class InsertIntoBinarySearchTree {

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) return new TreeNode(val);
        helper(root, val);
        return root;

    }

    private void helper(TreeNode root, int val) {

        if (val > root.val && root.right == null)
            root.right = new TreeNode(val);
        else if (val < root.val && root.left == null)
            root.left = new TreeNode(val);
        else if (val > root.val)
            helper(root.right, val);
        else
            helper(root.left, val);

    }
}
