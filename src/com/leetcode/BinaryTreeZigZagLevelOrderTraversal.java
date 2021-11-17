package com.leetcode;

import java.util.*;

public class BinaryTreeZigZagLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, null, new TreeNode(5, null, null)));

        //TreeNode treeNode = new TreeNode(1, new TreeNode(2, null, null), null);

        List<List<Integer>> result = zigzagLevelOrder(treeNode);
        System.out.println("result = " + result);

    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> integerQueue = new LinkedList<>();


        if (root != null) {
            integerQueue.offer(root);
        }


        int oddEvenIndicator = 0;

        while (!integerQueue.isEmpty()) {


            List<Integer> integerList = new ArrayList<>();

            int size = integerQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = integerQueue.poll();
                integerList.add(treeNode.val);

                if (treeNode.left != null) {
                    integerQueue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    integerQueue.offer(treeNode.right);
                }

            }
            oddEvenIndicator++;
            if (oddEvenIndicator % 2 == 0) {
                Stack<Integer> stack = new Stack<>();
                stack.addAll(integerList);

                List<Integer> reverseList = new ArrayList<>();
                while (!stack.isEmpty()) {
                    reverseList.add(stack.pop());
                }

                result.add(reverseList);

            } else {
                result.add(integerList);
            }
        }
        return result;

    }

    private static void putElementsInQueue(Queue<TreeNode> integerQueue, TreeNode treeNode, int oddEvenIndicator) {
        if (oddEvenIndicator % 2 == 0) {

        } else {
            if (treeNode.right != null)
                integerQueue.offer(treeNode.right);
            if (treeNode.left != null)
                integerQueue.offer(treeNode.left);

        }
    }

}
