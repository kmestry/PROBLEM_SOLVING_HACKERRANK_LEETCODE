package com.datastructure_2_studyplan_leetcode.day16;


import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

    public static void main(String[] args) {
        PathSum2 pathSum2 = new PathSum2();

        TreeNode root = new TreeNode(5,
                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1))));
        pathSum2.pathSum(root, 22);
//
//        TreeNode node1 = new TreeNode(11,
//                new TreeNode(7), new TreeNode(2));
//        TreeNode node2 = new TreeNode(4,
////        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
////        pathSum2.pathSum(root, 3);node1, null);
//
//        //right
//        TreeNode nodeR1 = new TreeNode(4,
//                new TreeNode(5), new TreeNode(1));
//        TreeNode nodeR2 = new TreeNode(8, new TreeNode(13), nodeR1);
//
//        TreeNode root = new TreeNode(5, node2, nodeR2);
//        pathSum2.pathSum(root, 22);
    }


    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = new ArrayList<>();

        helper(root, targetSum, 0, new ArrayList<>(), result);
        return result;
    }

    public void helper(TreeNode root, int target, int currSum, List<Integer> list, List<List<Integer>> result) {

        if (root == null) return;
        list.add(root.val);
        currSum += root.val;
        if (root.left == null && root.right == null && currSum == target) {
            result.add(new ArrayList<>(list));
        }

        helper(root.left, target, currSum, list, result);
        helper(root.right, target, currSum, list, result);
        list.remove(list.size() - 1);

    }


}


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
