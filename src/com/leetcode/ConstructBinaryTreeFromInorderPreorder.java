package com.leetcode;

public class ConstructBinaryTreeFromInorderPreorder {

    public static void main(String[] args) {
        TreeNode result = new ConstructBinaryTreeFromInorderPreorder().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println("result = " + result);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return buildTreeHelper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);

    }

    // https://www.youtube.com/watch?v=YMVn56IQhZo

    private TreeNode buildTreeHelper(int[] preOrder, int[] inOrder, int preOrderStart, int preOrderEnd, int inOrderStart, int inOrderEnd) {

        if (preOrderStart > preOrderEnd) return null;

        int rootValue = preOrder[preOrderStart];
        TreeNode resultNode = new TreeNode();
        resultNode.val = rootValue;

        int inOrderIndex = 0;
        for (int i = inOrderStart; i <= inOrderEnd; i++) {
            if (inOrder[i] == rootValue) {
                inOrderIndex = i;
                break;
            }
        }

        int leftTreeSize = inOrderIndex - inOrderStart;
        int rightTreeSize = inOrderEnd - inOrderIndex;

        resultNode.left = buildTreeHelper(preOrder, inOrder, preOrderStart + 1, preOrderStart + 1 + leftTreeSize - 1, inOrderStart, inOrderIndex - 1);
        resultNode.right = buildTreeHelper(preOrder, inOrder, preOrderStart + 1 + leftTreeSize - 1 + 1, preOrderEnd, inOrderIndex + 1, inOrderEnd);

        return resultNode;

    }
}
