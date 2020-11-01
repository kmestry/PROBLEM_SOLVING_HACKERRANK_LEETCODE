package com.leetcode;

public class RecoverBinarySearchTree {

    TreeNode previousNode;
    TreeNode firstNode;
    TreeNode secondNode;

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1, new TreeNode(3, null, new TreeNode(2)), null);
        new RecoverBinarySearchTree().recoverTree(root);
    }

    public void recoverTree(TreeNode root) {


        inOrder(root);

        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;


    }


    private void inOrder(TreeNode root) {

        if (root == null) {
            return;
        }

        inOrder(root.left);

        if (previousNode != null) {
            
            if (previousNode.val > root.val && firstNode == null) {
                firstNode = previousNode;
            }
            if (previousNode.val > root.val && firstNode != null) {
                secondNode = root;
            }
        }


        previousNode = root;
        inOrder(root.right);

    }
}
