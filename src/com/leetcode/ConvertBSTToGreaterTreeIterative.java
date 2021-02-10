package com.leetcode;

import java.util.Stack;

public class ConvertBSTToGreaterTreeIterative {


    public static void main(String[] args) {
        new ConvertBSTToGreaterTreeIterative().convertBST(new TreeNode(1, new TreeNode(0), new TreeNode(2)));
    }

    public TreeNode convertBST(TreeNode root) {

        int sum = 0;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (node != null) {
            stack.add(node);
            node = node.right;
        }

        TreeNode nodeLeft = null;
        while (!stack.isEmpty() || nodeLeft != null) {

            while (nodeLeft != null) {
                stack.add(nodeLeft);
                nodeLeft = nodeLeft.right;
            }


            if (!stack.isEmpty()) {
                nodeLeft = stack.pop();
                if (nodeLeft != null) {
                    sum += nodeLeft.val;
                    nodeLeft.val = sum;
                    nodeLeft = nodeLeft.left;
                }
            }

        }

        return root;

    }
}
