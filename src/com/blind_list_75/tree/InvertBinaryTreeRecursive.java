package com.blind_list_75.tree;

public class InvertBinaryTreeRecursive {

    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        //swap
        TreeNode temp = left;
        root.left = right;
        root.right = temp;

        return root;
    }
}
