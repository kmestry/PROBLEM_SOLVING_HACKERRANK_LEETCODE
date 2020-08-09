package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {


    List<Integer> resultList = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5, new TreeNode(2, new TreeNode(4, new TreeNode(1), null), new TreeNode(3)), null);

        new PreOrderTraversal().preOrderTraversalIterative(treeNode);
    }

    // Root Left Right
    public List<Integer> preorderTraversal(TreeNode root) {

        if (root == null)
            return resultList;
        preOrderHelper(root, resultList);
        return resultList;
    }

    void preOrderHelper(TreeNode node, List<Integer> list) {

        if (node == null)
            return;
        list.add(node.val);

        preOrderHelper(node.left, list);
        preOrderHelper(node.right, list);

    }

    public List<Integer> preOrderTraversalIterative(TreeNode root) {

        List<Integer> resultList = new ArrayList<>();
        if (root == null) return resultList;

        Stack<TreeNode> treeNodeStack = new Stack<>();
        treeNodeStack.push(root);

        while (!treeNodeStack.isEmpty()) {

            TreeNode node = treeNodeStack.pop();
            resultList.add(node.val);

            if (node.right != null) {
                treeNodeStack.push(node.right);
            }
            if (node.left != null) {
                treeNodeStack.push(node.left);
            }
        }

        return resultList;

    }
}
