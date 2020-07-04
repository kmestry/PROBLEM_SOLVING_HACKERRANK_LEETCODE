package com.leetcode;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class LevelOrderTraversalReverse {

    public static void main(String[] args) {


     /*   TreeNode treeNodeLeftChild = new TreeNode(3,new TreeNode(4,new TreeNode(5,null,null),null),null);

        TreeNode treeNodeLeft = new TreeNode(2, treeNodeLeftChild,  null);
        TreeNode treeNode = new TreeNode(1, treeNodeLeft, null);*/

        TreeNode treeNode = new TreeNode(3, new TreeNode(9, null, null), new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)));

        // TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), null), new TreeNode(3, null, new TreeNode(5, null, null)));


        List<List<Integer>> resultList = levelOrderBottom(treeNode);

        System.out.println("resultList = " + resultList);
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return new ArrayList<>();
        }

        queue.offer(root);

        Deque<List<Integer>> listDeque = new ArrayDeque<>();


        while (!queue.isEmpty()) {
            List<Integer> integerList = new ArrayList<>();
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {


                TreeNode treeNode = queue.poll();


                assert treeNode != null;
                integerList.add(treeNode.val);

                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }

                if (i == queueSize - 1) {
                    listDeque.addFirst(integerList);
                }
            }


        }

        return new ArrayList<>(listDeque);
    }

}
