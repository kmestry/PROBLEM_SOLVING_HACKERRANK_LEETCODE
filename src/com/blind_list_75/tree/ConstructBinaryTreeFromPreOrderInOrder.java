package com.blind_list_75.tree;

public class ConstructBinaryTreeFromPreOrderInOrder {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int pLength = preorder.length - 1;
        int iLength = inorder.length - 1;

        return helper(preorder, inorder, 0, pLength, 0, pLength);

    }

    private TreeNode helper(int[] preOrder, int[] inOrder, int pStart, int pEnd, int iStart, int iEnd) {

        if (iStart > iEnd) {
            return null;
        }

        TreeNode node = new TreeNode();
        node.val = preOrder[pStart];

        int index = -1;
        for (int i = iStart; i <= iEnd; i++) {
            if (node.val == inOrder[i]) {
                index = i;
                break;
            }
        }
        int leftSize = index - iStart;
        node.left = helper(preOrder, inOrder, pStart + 1, pStart + leftSize, iStart, index - 1);
        node.right = helper(preOrder, inOrder, pStart + leftSize + 1, pEnd, index + 1, iEnd);
        return node;
    }
}
