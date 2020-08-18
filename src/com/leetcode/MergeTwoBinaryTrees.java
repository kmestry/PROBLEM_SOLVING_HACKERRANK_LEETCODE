package com.leetcode;

public class MergeTwoBinaryTrees {


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5, new TreeNode(2, new TreeNode(4, new TreeNode(1), null), new TreeNode(3)), null);

        TreeNode treeNode1 = new TreeNode(5, new TreeNode(2, new TreeNode(4, new TreeNode(1), null), new TreeNode(3)), new TreeNode(10));

        new MergeTwoBinaryTrees().mergeTrees(treeNode, treeNode1);

    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {


        if (t1 == null) return t2;
        if (t2 == null) return t1;


        TreeNode node = new TreeNode(t1.val + t2.val);
        node.left = mergeTrees(t1.left, t2.left);
        node.right = mergeTrees(t1.right, t2.right);


        return node;
    }
}
