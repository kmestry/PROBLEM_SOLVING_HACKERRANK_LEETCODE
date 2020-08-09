package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversalIterative {

    public static void main(String[] args) {

    }

    public List<Integer> postorderTraversal(TreeNode root) {


        List<Integer> resultList = new ArrayList<>();
        if (root == null) return resultList;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode treeNode = stack1.pop();
            stack2.push(treeNode);
            if (treeNode.left != null) {
                stack1.push(treeNode.left);
            }
            if (treeNode.right != null) {
                stack1.push(treeNode.right);
            }
        }

        while (!stack2.isEmpty()) {
            TreeNode treeNode = stack2.pop();
            resultList.add(treeNode.val);
        }

        return resultList;
    }
}
