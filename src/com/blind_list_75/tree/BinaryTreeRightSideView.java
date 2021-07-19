package com.blind_list_75.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {

        if (root == null) return new ArrayList<>();

        List<Integer> list = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            boolean isFirst = false;
            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                if (!isFirst) {
                    list.add(node.val);
                    isFirst = true;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
            }
        }

        return list;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;


    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
