package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversalLeetCode {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, null, new TreeNode(5, null, null)));
        new InOrderTraversalLeetCode().inorderTraversal(treeNode);
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();

        if (root == null)
            return resultList;

        inorderHelper(root, resultList);

        return resultList;

    }

    void inorderHelper(TreeNode node, List<Integer> list) {

        if (node == null)
            return;

        inorderHelper(node.left, list);
        list.add(node.val);
        inorderHelper(node.right, list);

    }
}
