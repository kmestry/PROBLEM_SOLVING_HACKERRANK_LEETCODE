package com.leetcode;

public class SearchInBST {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7));
        TreeNode treeNode = new SearchInBST().searchBSTRecursion(node, 1);
        System.out.println("treeNode.val = " + treeNode.val);
    }

    public TreeNode searchBST(TreeNode root, int val) {

        if (root == null) return null;

        TreeNode tempNode = root;


        while (true) {
            if (val > tempNode.val) {
                if (tempNode.right != null) {
                    tempNode = tempNode.right;
                } else {
                    return null;
                }
            } else if (val < tempNode.val) {

                if (tempNode.left != null) {
                    tempNode = tempNode.left;
                } else {
                    return null;
                }
            } else {
                return tempNode;
            }
        }

    }

    public TreeNode searchBSTRecursion(TreeNode root, int val) {

        if (root == null) return null;
        if (root.val == val) return root;

        if (val > root.val)
            return searchBSTRecursion(root.right, val);
        else
            return searchBSTRecursion(root.left, val);

    }
}
