package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class BSTIterator {

    Deque<Integer> deque = new ArrayDeque<>();


    public BSTIterator(TreeNode root) {
        inorder(root, deque);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(7, new TreeNode(3), new TreeNode(15, new TreeNode(9), new TreeNode(20)));
        BSTIterator bstIterator = new BSTIterator(node);
        bstIterator.next();
        bstIterator.hasNext();
    }

    private void inorder(TreeNode root, Deque<Integer> deque) {

        if (root == null) {
            return;
        }

        inorder(root.left, deque);
        deque.addLast(root.val);
        inorder(root.right, deque);

    }

    public int next() {

        return deque.pop();

    }

    public boolean hasNext() {
        return !deque.isEmpty();
    }


}
