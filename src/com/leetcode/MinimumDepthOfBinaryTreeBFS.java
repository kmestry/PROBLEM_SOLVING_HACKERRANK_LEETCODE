package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTreeBFS {


    public int minDepth(TreeNode root) {

        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 1;

        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                if (node.left == null && node.right == null) {
                    // System.out.println(depth);
                    return depth;
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            depth++;
            // System.out.println("[[}"+depth);
        }

        return depth;
    }

}
