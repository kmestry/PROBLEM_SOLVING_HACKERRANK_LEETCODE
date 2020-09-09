package com.leetcode;

public class SumOfRootToLeafBinaryNumbers {

    int result = 0;

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(0, new TreeNode(0), new TreeNode(1)), new TreeNode(1, new TreeNode(0), new TreeNode(1)));

        new SumOfRootToLeafBinaryNumbers().sumRootToLeaf(treeNode);
    }

    public int sumRootToLeaf(TreeNode root) {

        helper(root, "");
        return result;


    }

    private void helper(TreeNode root, String binaryString) {

        if (root == null) return;
        if (root.left == null && root.right == null) {
            binaryString += root.val;
            int intVal = convertToInteger(binaryString);
            result += intVal;

        }
        binaryString += root.val;
        helper(root.left, binaryString);

        helper(root.right, binaryString);


    }


    private int convertToInteger(String binaryString) {
        System.out.println(binaryString);
        int value = 0;

        int power = 0;
        for (int i = binaryString.length() - 1; i >= 0; i--) {
            char ch = binaryString.charAt(i);
            if (ch == 49) {
                value += Math.pow(2, power);
            }
            power++;
        }

        return value;

    }
}
