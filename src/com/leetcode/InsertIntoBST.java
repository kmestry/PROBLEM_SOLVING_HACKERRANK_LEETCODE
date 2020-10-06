package com.leetcode;

public class InsertIntoBST {


    public static void main(String[] args) {
        TreeNode node = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7));
        new InsertIntoBST().insertIntoBST(node, 5);
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) return new TreeNode(val);

        TreeNode traverseNode = root;
        while (true) {

            if (val > traverseNode.val) {
                if (traverseNode.right != null) {
                    traverseNode = traverseNode.right;
                } else {
                    traverseNode.right = new TreeNode(val);
                    break;
                }
            } else {
                if (traverseNode.left != null) {
                    traverseNode = traverseNode.left;
                } else {
                    traverseNode.left = new TreeNode(val);
                    break;
                }
            }

        }

        return root;
    }


    public TreeNode insertIntoBSTRecursive(TreeNode root, int val) {

        if (root == null) return new TreeNode(val);

        helper(root, val);
        return root;
    }

    private void helper(TreeNode root, int val) {

        if (val > root.val && root.right == null) {
            root.right = new TreeNode(val);
        } else if (val < root.val && root.left == null) {
            root.left = new TreeNode(val);
        } else if (val > root.val) {
            helper(root.right, val);
        } else {
            helper(root.left, val);
        }

    }
}
