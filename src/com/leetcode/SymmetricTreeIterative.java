package com.leetcode;

import java.util.Stack;

public class SymmetricTreeIterative {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));

        new SymmetricTreeIterative().isSymmetric(treeNode);
    }


    public boolean isSymmetric(TreeNode root) {

        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);

        while (!stack.isEmpty()) {
            TreeNode node1 = stack.pop();
            TreeNode node2 = stack.pop();

            if (node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null) return false;

            if (node1.val != node2.val) return false;

            stack.push(node1.left);
            stack.push(node2.right);
            stack.push(node1.right);
            stack.push(node2.left);

        }

        return true;
    }

}
