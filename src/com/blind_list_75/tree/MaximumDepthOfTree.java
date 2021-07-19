package com.blind_list_75.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfTree {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return levelOrder(root);
    }

    private int levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }

            }
            level++;
        }
        return level;
    }
}
