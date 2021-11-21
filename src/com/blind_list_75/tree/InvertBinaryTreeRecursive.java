package com.blind_list_75.tree;

import java.util.LinkedList;
import java.util.Queue;

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

    public TreeNode invertTreeBFS(TreeNode root) {
        if (root == null) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        return root;
    }
}
