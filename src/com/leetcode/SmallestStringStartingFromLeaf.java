package com.leetcode;

public class SmallestStringStartingFromLeaf {

    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    String smallest = "zzzzzzzzzzzzzzzzzzzzzzzzzz";

    public String smallestFromLeaf(TreeNode root) {

        helper(root, "");

        return smallest;

    }

    private void helper(TreeNode root, String currentString) {

        if (root == null) return;


        currentString = alphabet[root.val] + currentString;


        if (root.left == null && root.right == null) {

            if (currentString.compareTo(smallest) < 0) {
                smallest = currentString;
            }

        }

        helper(root.left, currentString);
        helper(root.right, currentString);

    }

}
