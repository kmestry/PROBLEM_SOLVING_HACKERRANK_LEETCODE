package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversalIterative {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(3, new TreeNode(9, null, null), new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)));

        new InOrderTraversalIterative().inorderTraversal(treeNode);
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> resultList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null)
            return resultList;

        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            resultList.add(treeNode.val);

            if (treeNode.right != null) {
                TreeNode temp = treeNode.right;
                while (temp != null) {
                    stack.push(temp);
                    temp = temp.left;
                }
            }

        }

        return resultList;
    }

    public List<Integer> inorderTraversalPractise(TreeNode root) {

        Stack<TreeNode> treeNodeStack = new Stack<>();
        List<Integer> resultList = new ArrayList<>();
        if (root == null) return resultList;

        while (root != null) {
            treeNodeStack.push(root);
            root = root.left;
        }
        while (!treeNodeStack.isEmpty()) {
            TreeNode node = treeNodeStack.pop();
            resultList.add(node.val);

            if (node.right != null) {
                TreeNode temp = node.right;
                while (temp != null) {
                    treeNodeStack.push(temp);
                    temp = temp.left;
                }
            }
        }

        return resultList;
    }
}
