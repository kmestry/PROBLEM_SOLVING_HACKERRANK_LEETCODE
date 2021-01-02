package com.leetcode;

public class PseudoPalindromicPathsInBinaryTree {


    int count = 0;

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1, new TreeNode(1), new TreeNode(3, null, new TreeNode(1)));
        TreeNode treeNode = new TreeNode(2, node, new TreeNode(1));
        PseudoPalindromicPathsInBinaryTree obj = new PseudoPalindromicPathsInBinaryTree();
        obj.pseudoPalindromicPaths(treeNode);
    }

    public int pseudoPalindromicPaths(TreeNode root) {
        int[] array = new int[10]; // for 1 - 9 digits
        dfs(root, array);
        return count;
    }

    private void dfs(TreeNode root, int[] array) {

        if (root == null) {
            return;
        }

        array[root.val]++;
        if (root.left == null && root.right == null) {
            int oddParity = 0;
            for (int i = 1; i <= 9; i++) {
                if (array[i] % 2 != 0) {
                    oddParity++;
                    if (oddParity > 1) {
                        break;
                    }
                }
            }
            if (oddParity <= 1) {
                count++;
            }
        }


        dfs(root.left, array);
        dfs(root.right, array);
        array[root.val]--;


    }
}
