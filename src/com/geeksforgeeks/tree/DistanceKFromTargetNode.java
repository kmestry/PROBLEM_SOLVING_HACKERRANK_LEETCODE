package com.geeksforgeeks.tree;

import java.util.*;

public class DistanceKFromTargetNode {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(19, new TreeNode(13, new TreeNode(6, new TreeNode(3, null, null),
                new TreeNode(9, new TreeNode(21, null, null), new TreeNode(7, null, null))),
                new TreeNode(15, null, null)), new TreeNode(5, null, null));

        DistanceKFromTargetNode distanceKFromTargetNode = new DistanceKFromTargetNode();
        distanceKFromTargetNode.traverseTree(node);
    }

    private void traverseTree(TreeNode root) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);


        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                //assert node != null;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                list.add(node.val);


                // System.out.println(node.val);
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            map.put(level, list);
            level++;

            System.out.println("-------" + map);
        }

        System.out.println("---mapp---" + map);


    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;


    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
