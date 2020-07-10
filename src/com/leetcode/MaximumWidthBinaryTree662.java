package com.leetcode;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaximumWidthBinaryTree662 {

    public static void main(String[] args) {


     /*   TreeNode treeNodeLeftChild = new TreeNode(3,new TreeNode(4,new TreeNode(5,null,null),null),null);

        TreeNode treeNodeLeft = new TreeNode(2, treeNodeLeftChild,  null);
        TreeNode treeNode = new TreeNode(1, treeNodeLeft, null);*/

        //TreeNode treeNode = new TreeNode(3, new TreeNode(9, new TreeNode(11, null, null), null), new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)));

        TreeNode treeNode = new TreeNode(1, new TreeNode(1, new TreeNode(1, new TreeNode(1), null), null), new TreeNode(1, null, new TreeNode(1, null, new TreeNode(1))));
        // TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), null), new TreeNode(3, null, new TreeNode(5, null, null)));


        int resultList = widthOfBinaryTree(treeNode);

        System.out.println("resultList = " + resultList);
    }

    public static int widthOfBinaryTree(TreeNode root) {

        if (root == null) return 0;
        int max = 0;
        Queue<Map.Entry<TreeNode, Integer>> q = new LinkedList<>();
        q.offer(new AbstractMap.SimpleEntry<>(root, 1));

        while (!q.isEmpty()) {
            int l = q.peek().getValue(), r = l; // right started same as left
            int n = q.size();
            for (int i = 0; i < n; i++) {
                assert q.peek() != null;
                TreeNode node = q.peek().getKey();
                r = q.poll().getValue();
                if (node.left != null) q.offer(new AbstractMap.SimpleEntry<>(node.left, r * 2));
                if (node.right != null) q.offer(new AbstractMap.SimpleEntry<>(node.right, r * 2 + 1));
            }
            max = Math.max(max, r + 1 - l);
        }

        return max;

    }

}
