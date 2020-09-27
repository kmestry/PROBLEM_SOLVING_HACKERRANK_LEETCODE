package com.leetcode;

public class LowestCommonAncestorOfBST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //using property of binary Search tree.
        //left subtree has values less than the root and right subtree has values
        //greater than the root

        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }

    }

    //Iterative approach

    public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {

        while (root != null) {

            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                return root;
            }

        }
        return null;

    }
}
